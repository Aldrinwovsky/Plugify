package br.com.plugify.dao;

import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.model.Room;
import br.com.plugify.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomDao {


    public static Scanner inputRoom = new Scanner(System.in);
    private Connection conexao;

    // Construtor que inicializa a conexão com o banco de dados
    public RoomDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    // Método para cadastrar um Room no banco de dados
    public void cadastrar(Room room) throws SQLException {
        String query = "INSERT INTO rooms (id_room, name, description) VALUES (seq_rooms.nextval, ?, ?)";
        try (PreparedStatement stm = conexao.prepareStatement(query)) {
            stm.setString(1, room.getName());
            stm.setString(2, room.getDescription());
            stm.executeUpdate();
        }
    }

    // Método para pesquisar um Room por ID
    public Room pesquisar(long idRoom) throws SQLException, EntidadeNaoEncontradaException {
        String query = "SELECT * FROM rooms WHERE id_room = ?";
        try (PreparedStatement stm = conexao.prepareStatement(query)) {
            stm.setLong(1, idRoom);
            try (ResultSet resultado = stm.executeQuery()) {
                if (!resultado.next()) {
                    throw new EntidadeNaoEncontradaException("Cômodo não encontrado");
                }
                return parseRoom(resultado);
            }
        }
    }

    // Método auxiliar para converter o ResultSet em um objeto Room
    private Room parseRoom(ResultSet result) throws SQLException {
        int id = result.getInt("id_room");
        String nome = result.getString("name");
        String descricao = result.getString("description");
        return new Room(id, nome, descricao);
    }

    // Método para listar todos os rooms no banco de dados
    public List<Room> listar() throws SQLException {
        String query = "SELECT * FROM rooms";
        try (PreparedStatement stm = conexao.prepareStatement(query);
             ResultSet resultado = stm.executeQuery()) {
            List<Room> lista = new ArrayList<>();
            while (resultado.next()) {
                lista.add(parseRoom(resultado));
            }
            return lista;
        }
    }

    // Método para buscar um Room por ID
    public Room buscarRoomPorId(int idRoom) throws SQLException {
        String query = "SELECT * FROM rooms WHERE id_room = ?";
        try (PreparedStatement stm = conexao.prepareStatement(query)) {
            stm.setInt(1, idRoom);
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    return parseRoom(resultado);
                }
            }
        }
        return null; // Retorna null se não encontrar a sala
    }

    // Método para fechar a conexão
    public void fechaConexao() throws SQLException {
        conexao.close();
    }
}