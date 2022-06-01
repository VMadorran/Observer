package ar.unrn.parcial.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Observable {

	private List<EnvioDeCorreo> observadores = new ArrayList<EnvioDeCorreo>();

	public void agregarObservador(EnvioDeCorreo envioDeCorreo) {

		this.observadores.add(envioDeCorreo);
	}

	protected void notificarVenta(HashMap<String, String> datos) {
		for (EnvioDeCorreo observador : observadores) {
			observador.actualizar(datos);
			;
		}
	}

}
