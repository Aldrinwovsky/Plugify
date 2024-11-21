package br.com.plugify.view;

import br.com.plugify.dao.OutletDao;
import br.com.plugify.dao.RoomDao;

import java.sql.SQLException;
import java.util.Scanner;

public class OutletView {

    private static void cadastrar() {
        CadastroOutletView.executarCadastro();
    }
    private static void pesquisarProduto() {
        PesquisaOutletView.pesquisa();
    }
    private static void listar() {
        ListagemOutletView.listagem();
    }
    private static void atualizar() {
        AtualizacaoOutletView.atualiza();
    }
    private static void removerProduto() {
        RemocaoOutletView.remocao();
    }

    public static void Menu(){
        Scanner scanner = new Scanner(System.in);
        OutletDao dao;
        System.out.println("Bem vindo as configurações da tomada!");
        try {
            dao = new OutletDao();
            int escolha;
            do {
                System.out.println("Escolha uma opção:\n1-Cadastrar\n2-Pesquisar por ID\n3-Listar\n4-Atualizar\n5-Remover\n0-Sair");
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
                    case 4:
                        atualizar();
                        break;
                    case 5:
                        removerProduto();
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
