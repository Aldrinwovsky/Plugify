package br.com.plugify.view;

import br.com.plugify.dao.OutletDao;
import br.com.plugify.dao.RoomDao;
import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.model.Outlet;

import java.sql.SQLException;

public class PesquisaOutletView {
    public static void main(String[] args) {
        int idPesquisa;
        try{
            OutletDao dao = new OutletDao();

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

            Outlet tomada = dao.pesquisar(idPesquisa);
            System.out.println("ID: " + tomada.getIdOutlet() + "\nNome: " + tomada.getName() + "\nMAC: " + tomada.getMacAddress() + "\nStatus: " + tomada.getStatus() + "\nCômodo: " + tomada.getRoom().getIdRoom());


        }catch(SQLException e){
            System.err.println(e.getMessage());
        }catch (EntidadeNaoEncontradaException e){
            System.err.println("Código não existe na tabela");
        }
    }

}
