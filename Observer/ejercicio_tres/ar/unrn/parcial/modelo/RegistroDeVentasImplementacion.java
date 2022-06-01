package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class RegistroDeVentasImplementacion implements RegistroVentas {

	private Persistencia persistencia;

	public RegistroDeVentasImplementacion(Persistencia persistencia) {
		this.persistencia = persistencia;
	}

	@Override
	public void registrarVenta(LocalDateTime fecha, int cantidadDeRemeras, String direccion, double montoTotal)
			throws Exception {

		Correo correo = new Correo(direccion);
		// LocalDate fecha, int cantidadDeRemeras, Correo email, double montoTotal
		Venta nuevaVenta = new Venta(fecha, cantidadDeRemeras, correo, montoTotal);
		persistencia.registrarVenta(nuevaVenta);

	}

}
