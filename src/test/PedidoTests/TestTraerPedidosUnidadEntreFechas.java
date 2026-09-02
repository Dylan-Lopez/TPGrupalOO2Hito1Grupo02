package test.PedidoTests;

import java.time.LocalDate;
import java.util.List;

import datos.Pedido;
import negocio.PedidoABM;

public class TestTraerPedidosUnidadEntreFechas {

    public static void main(String[] args) {

        PedidoABM abm = new PedidoABM();

        try {

            List<Pedido> pedidos = abm.traerPedidosPorUnidadEntreFechas(1L,LocalDate.of(2026, 8, 15),LocalDate.of(2026, 8, 17));

            System.out.println("Pedidos encontrados:\n");

            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}