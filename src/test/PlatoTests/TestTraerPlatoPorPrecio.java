package test.PlatoTests;

import java.util.List;

import datos.Plato;
import negocio.PlatoABM;

public class TestTraerPlatoPorPrecio {

    public static void main(String[] args) {
        PlatoABM abm = new PlatoABM();
        List<Plato> lista = abm.traerPorPrecioMayorA(1000f);
        for (Plato p : lista) {
            System.out.println(p);
        }
    }
}
	