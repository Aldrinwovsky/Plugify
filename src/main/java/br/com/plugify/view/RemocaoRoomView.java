package br.com.plugify.view;

import br.com.plugify.dao.RoomDao;
import br.com.plugify.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemocaoRoomView {
    public static void remocao(){
        int idPesquisa;
        try {
            RoomDao dao = new RoomDao();
            while (true){
                System.out.print("Digite o ID: ");

                if (RoomDao.inputRoom.hasNextInt()) {
                    idPesquisa = RoomDao.inputRoom.nextInt();
                    break; // Encerra o loop se a entrada for válida
                } else {
                    System.out.println("Isso não é um número inteiro. Tente novamente.");
                    RoomDao.inputRoom.nextLine(); // Limpa a entrada inválida
                }
            }
            dao.remover(idPesquisa);
            dao.fechaConexao();
            System.out.println("Cômodo removido");


        }catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e){
            System.err.println("Código não existe na tabela");
        }
    }
}
