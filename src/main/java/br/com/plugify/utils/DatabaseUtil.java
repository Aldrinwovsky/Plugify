package com.plugify.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // Informações de conexão (substitua pelos seus dados reais)
    private static final String URL = "jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL";
    private static final String USER = "RM551679";
    private static final String PASSWORD = "210498";

    // Método para obter a conexão
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            throw e;
        }
    }
}
