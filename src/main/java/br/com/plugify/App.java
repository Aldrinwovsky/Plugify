package br.com.plugify;

import br.com.plugify.view.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        System.out.println("Seja bem vindo ao Menu do Plugify!");
        System.out.println("Qual tabela gostaria de editar?");
        do {

            System.out.println("Escolha uma opção:\n1-Cômodos\n2-Tomadas\n3-Consumo\n4-Alertas\n0-Sair");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    RoomView.Menu();
                    break;
                case 2:
                    OutletView.Menu();
                    break;
                case 3:
                    ConsumptionView.Menu();
                    break;
                case 4:
                    AlertView.Menu();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (escolha != 0);
    }

}



























