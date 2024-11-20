package br.com.plugify.view;

import br.com.plugify.dao.OutletDao;
import br.com.plugify.dao.RoomDao;
import br.com.plugify.model.Outlet;
import br.com.plugify.model.Room;

import java.sql.SQLException;

public class CadastroOutletView {
    public static void main(String[] args) {
        try {
            int idReposta;
            String nomeResposta;
            String macResposta;
            Boolean statusResposta;
            int idRoomResposta;

            // Instância do DAO de Outlet e Room
            OutletDao dao = new OutletDao();
            RoomDao roomDao = new RoomDao();

            // Receber dados da tomada
            while (true) {
                System.out.println("Qual o ID da tomada?");
                if (RoomDao.inputRoom.hasNextInt()) {
                    idReposta = RoomDao.inputRoom.nextInt();
                    RoomDao.inputRoom.nextLine();
                    break; // Encerra o loop se a entrada for válida
                } else {
                    System.out.println("Isso não é um número inteiro. Tente novamente.");
                    RoomDao.inputRoom.next(); // Limpa a entrada inválida
                }
            }

            System.out.println("Qual o nome quer dar a tomada?");
            nomeResposta = RoomDao.inputRoom.nextLine();

            System.out.println("Qual o endereço MAC?");
            macResposta = RoomDao.inputRoom.nextLine();

            System.out.println("A tomada está ligada? Sim(true) Não(false)");
            statusResposta = RoomDao.inputRoom.nextBoolean();

            // Perguntar o ID da sala e verificar se existe no banco
            Room room = null;
            while (room == null) {
                System.out.println("Qual o ID da sala que está essa tomada?");
                while (true) {
                    if (RoomDao.inputRoom.hasNextInt()) {
                        idRoomResposta = RoomDao.inputRoom.nextInt();
                        RoomDao.inputRoom.nextLine();  // Limpa o buffer após a leitura do número
                        break;  // Encerra o loop se a entrada for válida
                    } else {
                        System.out.println("Isso não é um número inteiro. Tente novamente.");
                        RoomDao.inputRoom.next();  // Limpa a entrada inválida
                    }
                }

                // Recuperar o objeto Room associado ao idRoomResposta
                room = roomDao.buscarRoomPorId(idRoomResposta);
                if (room == null) {
                    System.out.println("ID da sala não encontrado no banco de dados. Tente novamente.");
                }
            }

            // Criar o objeto Outlet, passando o room ao invés de idRoomResposta
            Outlet tomada = new Outlet(idReposta, nomeResposta, macResposta, statusResposta, room);

            // Cadastrar a tomada no banco
            dao.cadastrar(tomada);

            // Fechar a conexão com o banco
            dao.fechaConexao();
            roomDao.fechaConexao();  // Fechar também a conexão do RoomDao

            System.out.println("Produto Cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
