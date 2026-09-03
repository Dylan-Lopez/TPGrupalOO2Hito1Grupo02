package test.DetallePedidoTests;

import datos.DetallePedido;
import negocio.DetallePedidoABM;

public class TestActualizarDetallePedido {

    public static void main(String[] args) {

        DetallePedidoABM abm = new DetallePedidoABM();

        
        try {
        DetallePedido detalle = abm.traer(3L);
        detalle.setCantidad(5);
        abm.modificar(detalle);

        DetallePedido detalleModificado = abm.traer(3L);

        System.out.println(detalleModificado);
        
        } catch (Exception e){
        	System.out.println(e.getMessage());
        }
    }
}