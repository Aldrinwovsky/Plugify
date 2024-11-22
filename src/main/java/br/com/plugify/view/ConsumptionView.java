package br.com.plugify.view;

import br.com.plugify.dao.ConsumptionDao;
import br.com.plugify.dao.RoomDao;

import java.sql.SQLException;
import java.util.Scanner;

public class ConsumptionView {
    private static void cadastrar() {
        CadastroConsumptionView.executarCadastro();
    }
    private static void pesquisarProduto() {
        PesquisaConsumptionView.pesquisa();
    }
    private static void listar() {
        ListagemConsumptionView.listagem();
    }

    public static void Menu(){
        Scanner scanner = new Scanner(System.in);
        ConsumptionDao dao;
        System.out.println("Bem vindo as configurações de Consumo!");
        try {
            dao = new ConsumptionDao();
            int escolha;
            do {
                System.out.println("Escolha uma opção:\n1-Cadastrar\n2-Pesquisar por ID\n3-Listar\n0-Voltar");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        pesquisarProduto();
                        break;
                    case 3:
                        listar();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (escolha != 0);

            dao.fechaConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }


    }
}
