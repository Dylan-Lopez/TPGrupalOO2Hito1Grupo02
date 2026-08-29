package test;

import java.time.LocalDate;

import negocio.PedidoABM;

public class TestAgregarPedido {

    public static void main(String[] args) throws Exception {

        PedidoABM pedidoABM = new PedidoABM();

        int idPedido = pedidoABM.agregar(LocalDate.of(2026, 8, 15),1L);

        System.out.printf( "Id Pedido agregado: %d\n",idPedido);
    }
}