package ar.unrn.parcial.test;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.parcial.modelo.Persistencia;
import ar.unrn.parcial.modelo.Venta;

public class ServicioPersistencia implements Persistencia {

	private List<Venta> ventas = new ArrayList<Venta>();
	private String separadorDeCampo;

	public ServicioPersistencia(String separadorDeCampo) {
		this.separadorDeCampo = separadorDeCampo;
	}

	@Override
	public void registrarVenta(Venta venta) {
		// TODO Auto-generated method stub
		ventas.add(venta);
	}

	@Override
	public List<Venta> recuperarVentas() {
		// TODO Auto-generated method stub
		return this.ventas;
	}

}
