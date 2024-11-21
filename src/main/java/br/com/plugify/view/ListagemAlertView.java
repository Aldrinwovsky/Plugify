package br.com.plugify.view;

import br.com.plugify.dao.AlertDao;
import br.com.plugify.model.Alert;

import java.sql.SQLException;
import java.util.List;

public class ListagemAlertView {
    public static void listagem(){
        try {
            AlertDao dao = new AlertDao();
            List<Alert> alertas = dao.lista();
            for (Alert alert: alertas){
                System.out.println("ID: " + alert.getIdAlert() + ", Tipo de erro: " + alert.getAlertType() + ", Mensagem: " + alert.getMessage() + ", Data: " + alert.getAlertDate());
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
