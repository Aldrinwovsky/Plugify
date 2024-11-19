package br.com.plugify;

import br.com.plugify.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada!");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}



























