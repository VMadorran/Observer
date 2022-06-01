package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class Lisa extends Remera {
	LocalDateTime fechaDeCompra;
	private double precio = PRECIO_LISA;

	public Lisa(LocalDateTime fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	@Override
	public double calcularMontoDeRemera(int cantidad) {
		// TODO Auto-generated method stub
		double monto = cantidad * this.precio;
		double montoTotal = monto - this.descuentoRangoHorario(cantidad);

		return montoTotal;
	}

	private double descuentoRangoHorario(int cantidad) {

		double montoTotal = 0;

		if ((this.horaRangoInferior()) && (this.horaRangoSuperior()))
			montoTotal = ((this.precio * DESCUENTO_DE_MANIANA) / 100) * cantidad;
		return montoTotal;
	}

	private boolean horaRangoInferior() {
		boolean esLaHora = false;

		if ((fechaDeCompra.getHour() > HORA_RANGO_INFERIOR) || (fechaDeCompra.getHour() == HORA_RANGO_INFERIOR))
			esLaHora = true;
		return esLaHora;
	}

	private boolean horaRangoSuperior() {
		boolean esLaHora = false;

		if ((fechaDeCompra.getHour() < HORA_RANGO_SUPERIOR) || (fechaDeCompra.getHour() == HORA_RANGO_SUPERIOR))
			esLaHora = true;
		return esLaHora;
	}
}
