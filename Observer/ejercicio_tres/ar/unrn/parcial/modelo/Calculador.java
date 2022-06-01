package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Calculador extends Observable {

	// teniendo la remera y la cantidad calcula el monto correspondiente

	private RegistroVentas registroVentas;

	public Calculador(RegistroVentas registroVentas) {
		this.registroVentas = registroVentas;
	}

	public void registrarVenta(int posicion, int cantidad, String correo, LocalDateTime fecha) throws Exception {

		Remera remera = this.remeraElegida(posicion, fecha);

		this.registrarVenta(remera, cantidad, correo, fecha);
	}

	public void registrarVenta(Remera remera, int cantidad, String correo, LocalDateTime fecha) throws Exception {

		double monto = this.calcularMonto(remera, cantidad);

		this.registroVentas.registrarVenta(fecha, cantidad, correo, monto);
		this.notificar(cantidad, correo, fecha, monto);
	}

	public double calcularMonto(Remera remera, int cantidad) {

		return remera.calcularMontoDeRemera(cantidad);
	}

	public double consultarMonto(int posicion, int cantidad, LocalDateTime fecha) throws Exception {

		Remera remera = this.remeraElegida(posicion, fecha);

		return remera.calcularMontoDeRemera(cantidad);
	}

	private Remera remeraElegida(int posicion, LocalDateTime fecha) throws Exception {

		if (posicion == 0)
			throw new Exception("Elija un tipo de remera");
		if (posicion == 1) {
			Remera lisa = new Lisa(fecha);
			return lisa;
		}
		Remera estampada = new Estampada(fecha);
		return estampada;
	}

	private void notificar(int cantidad, String correo, LocalDateTime fecha, double monto) {

		HashMap<String, String> datos = new HashMap<String, String>();
		datos.put("Cantidad", String.valueOf(cantidad));
		datos.put("Correo", correo);
		datos.put("Fecha", fecha.toString());
		datos.put("Monto", String.valueOf(monto));

		this.notificarVenta(datos);

	}

}
