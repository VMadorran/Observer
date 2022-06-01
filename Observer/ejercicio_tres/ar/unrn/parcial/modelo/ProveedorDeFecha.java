package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class ProveedorDeFecha implements Fecha {

	@Override
	public LocalDateTime now(int dia, int mes, int anio, int hora, int minutos) {
		// TODO Auto-generated method stub
		LocalDateTime hoy = LocalDateTime.of(anio, mes, dia, hora, minutos);

		return hoy;
	}

	@Override
	public LocalDateTime now() {

		return LocalDateTime.now();
	}
}
