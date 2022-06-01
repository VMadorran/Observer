package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class Venta {

	private LocalDateTime fecha;
	private int cantidadDeRemeras;
	private double montoTotal;
	private Correo email;

	public Venta(LocalDateTime fecha, int cantidadDeRemeras, Correo email, double montoTotal) throws Exception {
		if (cantidadDeRemeras < 1)
			throw new Exception("Las remeras deben ser mas de 0");
		this.fecha = fecha;
		this.cantidadDeRemeras = cantidadDeRemeras;
		this.email = email;
		this.montoTotal = montoTotal;
	}

	public String datosDeVenta(String separador) {

		return this.fecha + separador + cantidadDeRemeras + separador + montoTotal + separador
				+ email.direccionDeEmail() + "\n";
	}

}
