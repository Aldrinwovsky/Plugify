package br.com.plugify.view;

import br.com.plugify.dao.ConsumptionDao;
import br.com.plugify.dao.OutletDao;
import br.com.plugify.dao.RoomDao;
import br.com.plugify.model.Consumption;
import br.com.plugify.model.Outlet;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CadastroConsumptionView {
    public static void executarCadastro() {
        try{
            String nomeResposta;
            Date DataResposta;
            Double quantidadeGastaResposta;
            int idTomadaResposta = 0;

            ConsumptionDao consumoDao = new ConsumptionDao();
            OutletDao tomadaDao = new OutletDao();


            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // Define o formato desejado para a data e hora
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Formata o Timestamp para o formato especificado
            String formattedDate = sdf.format(timestamp);

            System.out.println("Qual o gasto até agora?");
            quantidadeGastaResposta = RoomDao.inputRoom.nextDouble();
            RoomDao.inputRoom.nextLine();

            Outlet outlet = null;
            while (outlet == null) {
                System.out.println("Qual o ID da tomada vinculada a esse consumo?");
                while (true) {
                    if (RoomDao.inputRoom.hasNextInt()) {
                        idTomadaResposta = RoomDao.inputRoom.nextInt();
                        RoomDao.inputRoom.nextLine();  // Limpa o buffer após a leitura do número
                        break;  // Encerra o loop se a entrada for válida
                    } else {
                        System.out.println("Isso não é um número inteiro. Tente novamente.");
                        RoomDao.inputRoom.next();  // Limpa a entrada inválida
                    }
                }

                // Recuperar o objeto Room associado ao idRoomResposta
                outlet = tomadaDao.buscarOutletPorId(idTomadaResposta);
                if (outlet == null) {
                    System.out.println("ID de tomada não encontrado no banco de dados. Tente novamente.");
                }
            }

            Consumption consumo = new Consumption(Timestamp.valueOf(formattedDate), quantidadeGastaResposta, outlet);

            consumoDao.cadastrar(consumo);

            consumoDao.fechaConexao();
            tomadaDao.fechaConexao();

            System.out.println("Produto Cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
