package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public interface RegistroVentas {

	void registrarVenta(LocalDateTime fecha, int cantidadDeRemeras, String direccion, double montoTotal)
			throws Exception;

}
