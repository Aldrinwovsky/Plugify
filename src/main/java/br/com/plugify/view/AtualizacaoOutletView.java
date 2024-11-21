package br.com.plugify.view;

import br.com.plugify.dao.OutletDao;
import br.com.plugify.dao.RoomDao;
import br.com.plugify.exception.EntidadeNaoEncontradaException;
import br.com.plugify.model.Outlet;

import java.sql.SQLException;

public class AtualizacaoOutletView {
    public static void atualiza() {
        try{
            String nomeResposta;
            String descricaoResposta;
            boolean respostaBoolean;
            int idPesquisa;

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
            Outlet outlet = dao.pesquisar(idPesquisa);

            System.out.println("Qual o nome da tomada?");
            nomeResposta = RoomDao.inputRoom.nextLine();

            System.out.println("Qual o MAC?");
            descricaoResposta = RoomDao.inputRoom.nextLine();

            System.out.println("A tomada está ligada? Sim(true) Não(false)");
            respostaBoolean = RoomDao.inputRoom.nextBoolean();

            dao.atualizar(outlet);
            dao.fechaConexao();
            System.out.println("Tomada Atualizada!");

        }catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            throw new RuntimeException(e);
        }
    }
}
