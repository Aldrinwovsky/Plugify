package br.com.plugify.view;

import br.com.plugify.dao.RoomDao;
import br.com.plugify.model.Room;

import java.sql.SQLException;

public class CadastroRoomView {
    public static void main(String[] args) {
        try{

            int idReposta;
            String nomeResposta;
            String descricaoResposta;

            RoomDao dao = new RoomDao();

            //Pega os valores do usuário para colocar no cadastro
            while (true) {
                System.out.println("Qual o ID do cômodo?");

                if (RoomDao.inputRoom.hasNextInt()) {
                    idReposta = RoomDao.inputRoom.nextInt();
                    RoomDao.inputRoom.nextLine();
                    break; // Encerra o loop se a entrada for válida
                } else {
                    System.out.println("Isso não é um número inteiro. Tente novamente.");
                    RoomDao.inputRoom.next(); // Limpa a entrada inválida
                }
            }

            System.out.println("Qual o nome do cômodo?");
            nomeResposta = RoomDao.inputRoom.nextLine();

            System.out.println("Qual a descrição do cômodo?");
            descricaoResposta = RoomDao.inputRoom.nextLine();


            Room sala = new Room(idReposta, nomeResposta, descricaoResposta);
            dao.cadastrar(sala);
            dao.fechaConexao();
            System.out.printf("Produto cadastrado!");

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
