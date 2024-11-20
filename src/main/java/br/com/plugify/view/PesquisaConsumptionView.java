package br.com.plugify.view;

import br.com.plugify.dao.ConsumptionDao;
import br.com.plugify.dao.RoomDao;
import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.model.Consumption;

import java.sql.SQLException;

public class PesquisaConsumptionView {
    public static void main(String[] args) {
        int idPesquisa;
        try {
            ConsumptionDao dao = new ConsumptionDao();

            while (true){
                System.out.print("Digite o ID: ");

                if (RoomDao.inputRoom.hasNextInt()) {
                    idPesquisa = RoomDao.inputRoom.nextInt();
                    break; // Encerra o loop se a entrada for válida
                } else {
                    System.out.println("Isso não é um número inteiro. Tente novamente.");
                    RoomDao.inputRoom.next(); // Limpa a entrada inválida
                }
            }

            Consumption consumo = dao.pesquisar(idPesquisa);
            System.out.println("ID: " + consumo.getIdConsumption() + "\nData: " + consumo.getConsumptionTimestamp() + "\nkWh: " + consumo.getAmount() + "\nTomada: " + consumo.getOutlet().getIdOutlet());

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch (EntidadeNaoEncontradaException e){
            System.err.println("Código não existe na tabela");
        }
    }
}
