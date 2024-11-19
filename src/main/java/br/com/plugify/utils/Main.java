package com.plugify;

import com.plugify.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            if (connection != null) {
                System.out.println("Conexão bem-sucedida ao banco de dados!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
