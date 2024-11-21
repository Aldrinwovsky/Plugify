package br.com.plugify.view;

import br.com.plugify.dao.RoomDao;
import br.com.plugify.model.Room;

import java.sql.SQLException;

public class CadastroRoomView {
    public static void executarCadastro() {
        try{
            String nomeResposta;
            String descricaoResposta;

            RoomDao dao = new RoomDao();

            //Pega os valores do usuário para colocar no cadastro

            System.out.println("Qual o nome do cômodo?");
            nomeResposta = RoomDao.inputRoom.nextLine();

            System.out.println("Qual a descrição do cômodo?");
            descricaoResposta = RoomDao.inputRoom.nextLine();

            Room sala = new Room(nomeResposta, descricaoResposta);
            dao.cadastrar(sala);
            dao.fechaConexao();
            System.out.printf("Produto cadastrado!");

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
