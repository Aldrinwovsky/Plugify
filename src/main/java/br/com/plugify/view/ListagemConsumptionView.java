package br.com.plugify.view;

import br.com.plugify.dao.ConsumptionDao;
import br.com.plugify.model.Consumption;

import java.sql.SQLException;
import java.util.List;

public class ListagemConsumptionView {
    public static void listagem() {
        try{
            ConsumptionDao dao = new ConsumptionDao();
            List<Consumption> consumos = dao.lista();
            for(Consumption consumo: consumos){
                System.out.println("ID: " + consumo.getIdConsumption() + ", Data: " + consumo.getConsumptionTimestamp() + ", kWh: " + consumo.getAmount() + ", Tomada: " + consumo.getOutlet().getIdOutlet());
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
