package ar.unrn.parcial.modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Estampada extends Remera {
	private double precio = PRECIO_ESTAMPADA;
	private LocalDateTime fechaDeCompra;

	public Estampada(LocalDateTime fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	@Override
	public double calcularMontoDeRemera(int cantidad) {

		double montoTotal = cantidad * this.precio;

		montoTotal = montoTotal - this.masDeTresRemeras(cantidad);
		montoTotal = montoTotal - this.descuentoDeDomingo(montoTotal);

		return montoTotal;
	}

	private double masDeTresRemeras(int cantidadDeRemeras) {

		double montoTotal = 0;

		if ((cantidadDeRemeras > CANTIDAD_DE_REMERAS) && (this.esSabado())) {

			double monto = cantidadDeRemeras * this.precio;
			montoTotal = (monto * DESCUENTO_MAS_DE_TRES) / 100;
		}
		return montoTotal;
	}

	private double descuentoDeDomingo(double monto) {

		double montoTotal = 0;

		if (this.esDomingo())
			montoTotal = (monto * DESCUENTO_DOMINGO) / 100;
		return montoTotal;
	}

	private boolean esSabado() {
		DayOfWeek dia = this.fechaDeCompra.getDayOfWeek();
		return (dia.equals(DayOfWeek.SATURDAY));
	}

	private boolean esDomingo() {
		DayOfWeek dia = this.fechaDeCompra.getDayOfWeek();
		return (dia.equals(DayOfWeek.SUNDAY));
	}
}
