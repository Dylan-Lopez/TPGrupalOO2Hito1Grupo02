package test.PedidoTests;

import java.time.LocalDate;

import negocio.PedidoABM;

public class TestAgregarPedido {

    public static void main(String[] args) {
    	

        PedidoABM pedidoABM = new PedidoABM();
        
        try {

        int idPedido = pedidoABM.agregar(LocalDate.of(2026, 8, 20),1L);

        System.out.printf( "Id Pedido agregado: %d\n",idPedido);
        
        } catch (Exception e) {
        	System.out.println("Error: " + e.getMessage());
        }
    }
}