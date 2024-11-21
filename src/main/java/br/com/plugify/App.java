package br.com.plugify;

import br.com.plugify.dao.RoomDao;
import br.com.plugify.factory.ConnectionFactory;
import br.com.plugify.model.Room;
import br.com.plugify.view.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
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



























