package test.PedidoTests;

// Caso de Uso - Uno a Muchos
// Traer todos los pedidos de una UnidadVenta entre fechas determinadas.

import java.time.LocalDate;
import java.util.List;

import datos.Pedido;
import negocio.PedidoABM;

public class TestTraerPedidosUnidadEntreFechas {

    public static void main(String[] args) {

        PedidoABM abm = new PedidoABM();

        try {

            int idUnidad = 1L;

            LocalDate fechaDesde = LocalDate.of(2026, 8, 1);
            LocalDate fechaHasta = LocalDate.of(2026, 8, 31);

            List<Pedido> pedidos =
                    abm.traerPedidosPorUnidadEntreFechas(
                            idUnidad,
                            fechaDesde,
                            fechaHasta);

            System.out.println("Pedidos encontrados:\n");

            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
