package br.com.plugify.dao;

import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.plugify.model.Consumption;
import br.com.plugify.model.Outlet;

public class ConsumptionDao {
    private Connection conexao;

    public ConsumptionDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Consumption consumption) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO consumption(id_consumption, consumption_date, amount, outlets_id_outlet) VALUES (seq_consumption.nextval, ?, ?, ?)");
        stm.setTimestamp(1, consumption.getConsumptionTimestamp());
        stm.setDouble(2, consumption.getAmount());
        stm.setInt(3, consumption.getOutlet().getIdOutlet());
        stm.executeUpdate();
    }

    public Consumption pesquisar(int id_consumption) throws SQLException, EntidadeNaoEncontradaException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM consumption WHERE id_consumption = ?");
        stm.setInt(1, id_consumption);

        ResultSet resultado = stm.executeQuery();
        if(!resultado.next()){
            throw new EntidadeNaoEncontradaException("Consumo não encontrado");
        }

        parseConsumption(resultado);
        return parseConsumption(resultado);
    }

    private Consumption parseConsumption(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id_consumption");
        Timestamp data = resultado.getTimestamp("consumption_date");
        double consumoTotal = resultado.getDouble("amount");
        int id_tomada = resultado.getInt("outlets_id_outlet");

        Outlet outlet = new Outlet(id_tomada);
        outlet.setIdOutlet(id_tomada);

        return new Consumption(id,data,consumoTotal, outlet);
    }

    public List<Consumption> lista() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM consumption");
        ResultSet resultado = stm.executeQuery();
        List<Consumption> lista = new ArrayList<>();
        while(resultado.next()){
            lista.add(parseConsumption(resultado));
        }

        return lista;
    }

    public void fechaConexao() throws SQLException{
        conexao.close();
    }
}
