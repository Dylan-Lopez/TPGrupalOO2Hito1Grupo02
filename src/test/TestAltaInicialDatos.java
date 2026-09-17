package test;

import java.time.LocalDate;

import datos.Costo;
import datos.Personal;
import datos.Plato;
import datos.Pedido;
import datos.Festival;
import datos.UnidadVenta;

import negocio.CostoABM;
import negocio.PersonalABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.DetallePedidoABM;

public class TestAltaInicialDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciamos TODOS los ABM que vamos a necesitar
		
		CostoABM costoABM = new CostoABM();
		PersonalABM personalABM = new PersonalABM();
		PlatoABM platoABM = new PlatoABM();
		UnidadVentaABM unidadABM = new UnidadVentaABM();
		FestivalABM festivalABM = new FestivalABM();
		PedidoABM pedidoABM = new PedidoABM();
		DetallePedidoABM detalleABM = new DetallePedidoABM();

		try {

			// -----------------------------------------
			// 1) COSTOS (los necesita Festival)
			// -----------------------------------------
			int idCosto1 = costoABM.agregar(2200.00f, 950.50f, 0f); // plusElectricidad = 20 (> 0)
			int idCosto2 = costoABM.agregar(80f, 40f, 0f);   // plusElectricidad = 0
			System.out.println("Costos creados: " + idCosto1 + ", " + idCosto2);

			// -----------------------------------------
			// 2) PERSONAL (responsables y staff de las unidades)
			//    fechaNacimiento >= 18 años | fechaIngreso variada
			// -----------------------------------------
			int idCaj1 = personalABM.agregarCajero("Carlos", "Gomez", 30123458L, LocalDate.of(1985, 5, 10),
					LocalDate.of(2010, 3, 1), 450000.0, "mañana");
			int idCaj2 = personalABM.agregarCajero("Luis", "Perez", 30222333L,
					LocalDate.of(1988, 8, 15), LocalDate.of(2022, 6, 1), 260000, "Tarde");
			int idCoc1 = personalABM.agregarCocinero("Marta", "Rodriguez", 32987655L, LocalDate.of(1988, 8, 20),
					LocalDate.of(2012, 6, 15), 600000.0, "Comida Italiana", 15000.0f);
			int idCoc2 = personalABM.agregarCocinero("Jorge", "Diaz", 30444555L,
					LocalDate.of(1985, 11, 30), LocalDate.of(2019, 2, 1), 320000, "Pastas", 2f);
			System.out.println("Personal creado: " + idCaj1 + ", " + idCaj2 + ", " + idCoc1 + ", " + idCoc2);

			// Recuperamos los objetos Personal que usaremos como responsables
			Personal resp1 = personalABM.traer(idCaj1);
			Personal resp2 = personalABM.traer(idCaj2);
			Personal resp3 = personalABM.traer(idCoc1);
			Personal resp4 = personalABM.traer(idCoc2);

			// -----------------------------------------
			// 3) PLATOS
			// -----------------------------------------
			int idPlato1 = platoABM.agregar("Milanesa con papas", 8500.00f, 3200.00f);
			int idPlato2 = platoABM.agregar("Pancho", 3000f, 1000f);
			int idPlato3 = platoABM.agregar("Choripan", 4000f, 1500f);
			System.out.println("Platos creados: " + idPlato1 + ", " + idPlato2 + ", " + idPlato3);

			// -----------------------------------------
			// 4) UNIDADES DE VENTA (FoodTruck y PuestoDesarmable)
			// -----------------------------------------
			// FoodTruck que cumple TODO (superficie > 25 | conexion = true)
			int idFt1 = unidadABM.agregarFoodTruck("Food Truck Sabores", 25.5f, "FT-001", null, "AB123CD", true);
			// FoodTruck que NO cumple (superficie < 25 | conexion = false)
			int idFt2 = unidadABM.agregarFoodTruck("Mini Truck", 20f, "FT-002", resp3, "EF456GH", false);
			// Puesto que cumple (mas de 3 carpas | montaje < 30)
			int idPd1 = unidadABM.agregarPuestoDesarmable("Puesto Desarmable Pepitos", 36, "PD-001", null, 5, 24);
			// Puesto que NO cumple (pocas carpas | montaje + 30)
			int idPd2 = unidadABM.agregarPuestoDesarmable("Carpa Carpitas", 15f, "PD-002", resp4, 2, 45f);
			System.out.println("Unidades creadas: " + idFt1 + ", " + idFt2 + ", " + idPd1 + ", " + idPd2);

			// -----------------------------------------
			// 5) FESTIVALES (necesitan un Costo)
			// -----------------------------------------
			Costo costo1 = costoABM.traer(idCosto1);
			Costo costo2 = costoABM.traer(idCosto2);
			int idFest1 = festivalABM.agregar("Festival de Navidad", "Verano",
	                LocalDate.of(2026, 12, 22), LocalDate.of(2026, 12, 25), costo1);
			int idFest2 = festivalABM.agregar("Festival Otoño", "Otoño",
					LocalDate.of(2026, 4, 5), LocalDate.of(2026, 4, 15), costo2);
			System.out.println("Festivales creados: " + idFest1 + ", " + idFest2);

			// -----------------------------------------
			// 6) Relacion FESTIVAL <-> UNIDAD
			// -----------------------------------------
			UnidadVenta unidadConFest = unidadABM.traerUnidadYFestivales(idFt1);
			Festival festival1 = festivalABM.traer(idFest1);
			unidadConFest.agregar(festival1);
			unidadABM.modificar(unidadConFest);
			System.out.println("Festival " + idFest1 + " asociado a la unidad " + idFt1);

			// -----------------------------------------
			// 7) Relacion STAFF
			// -----------------------------------------
			UnidadVenta unidadConStaff = unidadABM.traerUnidadYStaff(idFt1);
			Personal integrante = personalABM.traer(idCoc1);
			unidadConStaff.getLstStaff().add(integrante);
			unidadABM.modificar(unidadConStaff);
			System.out.println("Personal " + idCoc1 + " agregado al staff de la unidad " + idFt1);

			// -----------------------------------------
			// 8) PEDIDOS (necesitan el id de una unidad)
			// -----------------------------------------
			int idPedido1 = pedidoABM.agregar(LocalDate.of(2026, 2, 1), idFt1);
			int idPedido2 = pedidoABM.agregar(LocalDate.of(2026, 2, 15), idFt1);
			System.out.println("Pedidos creados: " + idPedido1 + ", " + idPedido2);

			// -----------------------------------------
			// 9) DETALLES DE PEDIDO (necesitan Plato Y Pedido)
			// -----------------------------------------
			Plato plato1 = platoABM.traer(idPlato1);
			Plato plato2 = platoABM.traer(idPlato2);
			Pedido pedido1 = pedidoABM.traer(idPedido1);
			Pedido pedido2 = pedidoABM.traer(idPedido2);

			detalleABM.agregar(plato1, 2, pedido1);
			detalleABM.agregar(plato2, 3, pedido1);
			detalleABM.agregar(plato1, 1, pedido2);
			System.out.println("Detalles de pedido creados.");

			System.out.println("\n=== CARGA INICIAL COMPLETADA CON EXITO ===");

		} catch (Exception e) {
			System.out.println("ERROR en la carga inicial: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
