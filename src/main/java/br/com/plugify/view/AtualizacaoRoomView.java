package br.com.plugify.view;

import br.com.plugify.dao.RoomDao;
import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.model.Room;

import java.sql.SQLException;

public class AtualizacaoRoomView {
    public static void atualiza() {
        String nomeResposta;
        String descricaoResposta;
        try{
            int idPesquisa;
            RoomDao dao = new RoomDao();
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
            Room comodo = dao.pesquisar(idPesquisa);

            System.out.println("Qual o nome do cômodo?");
            nomeResposta = RoomDao.inputRoom.nextLine();

            System.out.println("Qual a descrição do cômodo?");
            descricaoResposta = RoomDao.inputRoom.nextLine();

            dao.atualizar(comodo);
            dao.fechaConexao();
            System.out.println("Cômodo Atualizado!");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch (EntidadeNaoEncontradaException e){
            System.err.println("Código não existe na tabela");
        }
    }

}
