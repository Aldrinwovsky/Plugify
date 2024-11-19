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

        public RoomDao() throws SQLException {
            conexao = ConnectionFactory.getConnection();
        }

        public void cadastrar(Room room) throws SQLException{
            PreparedStatement stm = conexao.prepareStatement("INSERT INTO rooms (id_room, name, description) VALUES (?, ?, ?)");
            stm.setInt(1, room.getIdRoom());
            stm.setString(2, room.getName());
            stm.setString(3, room.getDescription());
            stm.executeUpdate();

        }

        public Room pesquisar(long id_room) throws SQLException,EntidadeNaoEncontradaException{
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM rooms WHERE id_room = ?");
            stm.setLong(1, id_room);

            ResultSet resultado = stm.executeQuery();
            if (!resultado.next())
                throw new EntidadeNaoEncontradaException("Produto não encontrado");
            parseRoom(resultado);


            return parseRoom(resultado);
        }

        private Room parseRoom(ResultSet result) throws SQLException{
            int id = result.getInt("id_room");
            String nome = result.getString("name");
            String descricao = result.getString("description");
            return new Room(id, nome, descricao);
        }

        public List<Room> listar() throws SQLException{
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM rooms");
            ResultSet resultado = stm.executeQuery();
            List<Room> lista = new ArrayList<>();

            while (resultado.next()){
                lista.add(parseRoom(resultado));
            }
            return lista;
        }


        public void fechaConexao() throws SQLException{
            conexao.close();
        }





















}
