package br.com.plugify.view;

import br.com.plugify.dao.OutletDao;
import br.com.plugify.model.Outlet;

import java.sql.SQLException;
import java.util.List;


public class ListagemOutletView {
    public static void main(String[] args) {
        try{
            OutletDao dao = new OutletDao();
            List<Outlet> tomadas = dao.lista();
            for(Outlet tomada : tomadas){
                System.out.println("ID: " + tomada.getIdOutlet() + ", Nome: " + tomada.getName() + ", MAC: " + tomada.getMacAddress() + ", Cômodo: " + tomada.getRoom().getIdRoom() + ", Status: " + tomada.getStatus());
            }
            dao.fechaConexao();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }
}
