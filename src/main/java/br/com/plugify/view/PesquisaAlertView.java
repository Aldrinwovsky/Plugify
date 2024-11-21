package br.com.plugify.view;

import br.com.plugify.dao.AlertDao;
import br.com.plugify.dao.RoomDao;
import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.model.Alert;

import java.sql.SQLException;

public class PesquisaAlertView {
    public static void pesquisa() {
        try{
            int idPesquisa;
            AlertDao dao= new AlertDao();

            while (true){
                System.out.print("Digite o ID: ");

                if (RoomDao.inputRoom.hasNextInt()) {
                    idPesquisa = RoomDao.inputRoom.nextInt();
                    break; // Encerra o loop se a entrada for válida
                } else {
                    System.out.println("Isso não é um número inteiro. Tente novamente.");
                    RoomDao.inputRoom.next(); // Limpa a entrada inválida
                }
            }

            Alert alert = dao.pesquisar(idPesquisa);
            System.out.println("ID: " + alert.getIdAlert() + "\nTipo de erro: " + alert.getAlertType() + "\nMensagem: " + alert.getMessage() + "\nData: " + alert.getAlertDate());

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch (EntidadeNaoEncontradaException e){
            System.err.println("Código não existe na tabela");
        }
    }
}
