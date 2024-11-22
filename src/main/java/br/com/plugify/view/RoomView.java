package br.com.plugify.view;

import br.com.plugify.dao.RoomDao;
import br.com.plugify.model.Room;

import java.sql.SQLException;
import java.util.Scanner;

public class RoomView {
    private static void cadastrar() {
        CadastroRoomView.executarCadastro();
    }
    private static void pesquisarProduto() {
        PesquisaRoomPorIdView.pesquisa();
    }
    private static void listar() {
        ListagemRoomView.listagem();
    }
    private static void atualizar() {
        AtualizacaoRoomView.atualiza();
    }
    private static void removerProduto() {
        RemocaoRoomView.remocao();
    }

    public static void Menu(){
        Scanner scanner = new Scanner(System.in);
        RoomDao dao;
        System.out.println("Bem vindo as configurações de cômodo!");
        try {
                dao = new RoomDao();
                int escolha;
                do {
                    System.out.println("Escolha uma opção:\n1-Cadastrar\n2-Pesquisar por ID\n3-Listar\n4-Atualizar\n5-Remover\n0-Voltar");
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
