package br.com.plugify.view;

import br.com.plugify.dao.RoomDao;
import br.com.plugify.model.Room;

import java.sql.SQLException;
import java.util.List;

public class ListagemRoomView {
    public static void main(String[] args) {
        try {
            RoomDao dao = new RoomDao();
            List<Room> salas = dao.listar();
            for (Room room : salas){
                System.out.println("ID: " + room.getIdRoom() + ", Name: " + room.getName() + ", Description: " + room.getDescription());
            }
            dao.fechaConexao();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
