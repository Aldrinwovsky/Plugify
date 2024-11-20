package br.com.plugify.dao;

import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.factory.ConnectionFactory;
import br.com.plugify.model.Outlet;
import br.com.plugify.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutletDao {
    public static Scanner inputOutlet = new Scanner(System.in);
    private Connection conexao;

    public OutletDao() throws SQLException{
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Outlet outlet) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO outlets(id_outlet, name, mac_address, status, rooms_id_room) VALUES (?, ?, ?, ?, ?)");
        stm.setInt(1,outlet.getIdOutlet());
        stm.setString(2, outlet.getName());
        stm.setString(3, outlet.getMacAddress());
        stm.setBoolean(4,outlet.getStatus());
        stm.setInt(5, outlet.getRoom().getIdRoom());
        stm.executeUpdate();
    }

    public Outlet pesquisar(int id_Outlet) throws SQLException, EntidadeNaoEncontradaException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM outlets WHERE id_outlet = ?");
        stm.setLong(1, id_Outlet);

        ResultSet resultado = stm.executeQuery();
        if (!resultado.next()){
            throw new EntidadeNaoEncontradaException("Tomada não encontrada");
        }
        parseOutlet(resultado);

        return  parseOutlet(resultado);
    }

    private Outlet parseOutlet(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id_outlet");
        String nome = resultado.getString("name");
        String macAddress = resultado.getString("mac_address");
        boolean status = resultado.getBoolean("status");
        int rooms_id_room = resultado.getInt("rooms_id_room");

        Room room = new Room(rooms_id_room);
        room.setIdRoom(rooms_id_room);

        return new Outlet(id, nome, macAddress, status, room);
    }

    public List<Outlet> lista() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM outlets");
        ResultSet resultado = stm.executeQuery();
        List<Outlet> lista = new ArrayList<>();
        while (resultado.next()){
            lista.add(parseOutlet(resultado));//////
        }
        return lista;
    }

    public void fechaConexao() throws SQLException{
        conexao.close();
    }


}
