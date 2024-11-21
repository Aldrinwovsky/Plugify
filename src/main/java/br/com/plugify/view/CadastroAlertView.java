package br.com.plugify.view;

import br.com.plugify.dao.AlertDao;
import br.com.plugify.dao.RoomDao;
import br.com.plugify.model.Alert;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CadastroAlertView {
    public static void executarCadastro() {
        try{
            String alertTypeString;
            String messageString;

            System.out.println("Qual o tipo de alerta?");
            alertTypeString = RoomDao.inputRoom.nextLine();

            System.out.println("Qual a mensagem do alerta?");
            messageString = RoomDao.inputRoom.nextLine();

            AlertDao dao = new AlertDao();


            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // Define o formato desejado para a data e hora
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Formata o Timestamp para o formato especificado
            String formattedDate = sdf.format(timestamp);

            Alert alerta = new Alert(alertTypeString, messageString, Timestamp.valueOf(formattedDate));

            dao.cadastrar(alerta);
            dao.fechaConexao();

            System.out.println("Produto Cadastrado com sucesso!");


        }catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
