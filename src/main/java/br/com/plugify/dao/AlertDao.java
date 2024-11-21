package br.com.plugify.dao;

import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.factory.ConnectionFactory;
import br.com.plugify.model.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertDao {
    private Connection conexao;

    public AlertDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Alert alert) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO alerts(id_alert, alert_type, message, alert_date) VALUES (seq_alerts.nextval, ?, ?, ?)");
        stm.setString(1, alert.getAlertType());
        stm.setString(2, alert.getMessage());
        stm.setTimestamp(3, alert.getAlertDate());
        stm.executeUpdate();
    }

    public Alert pesquisar(int id_alert) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM alerts WHERE id_alert = ?");
        stm.setInt(1, id_alert);

        ResultSet resultado = stm.executeQuery();
        if (!resultado.next()){
            throw new EntidadeNaoEncontradaException("Alert não encontrado");
        }

        parseAlert(resultado);
        return parseAlert(resultado);

    }

    private Alert parseAlert(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id_alert");
        Timestamp data = resultado.getTimestamp("alert_date");
        String message = resultado.getString("message");
        String alert = resultado.getString("alert_type");


        return new Alert(id, alert, message, data);
    }

    public List<Alert> lista() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM alerts");
        ResultSet resultado = stm.executeQuery();
        List<Alert> lista = new ArrayList<>();
        while (resultado.next()){
            lista.add(parseAlert(resultado));
        }

        return lista;
    }

    public void fechaConexao() throws SQLException{
        conexao.close();
    }

}
