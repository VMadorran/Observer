package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public interface Fecha {// Lo usa la UI

	public LocalDateTime now(int dia, int mes, int anio, int hora, int minutos);

	public LocalDateTime now();
}
