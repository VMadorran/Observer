package ar.unrn.parcial.test;

import java.time.LocalDateTime;
import java.util.HashMap;

import ar.unrn.parcial.modelo.EnvioDeCorreo;

public class ServicioEnvioDeCorreo implements EnvioDeCorreo {

	private String contenido = "";

	@Override
	public void actualizar(HashMap<String, String> datos) {
		// TODO Auto-generated method stub
		this.contenido += "Fecha: " + datos.get("Fecha") + "\n" + "cantidad: " + datos.get("Cantidad") + "\n"
				+ "Monto total:" + datos.get("Monto") + "\n" + datos.get("Correo") + "\n";
	}

	@Override
	public String recuperarContenidoDeCorreo() {
		// TODO Auto-generated method stub
		return this.contenido;
	}

}
