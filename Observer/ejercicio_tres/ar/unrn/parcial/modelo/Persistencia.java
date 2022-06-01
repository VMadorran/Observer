package ar.unrn.parcial.modelo;

import java.util.List;

public interface Persistencia {

	public void registrarVenta(Venta venta);

	public List<Venta> recuperarVentas();

}
