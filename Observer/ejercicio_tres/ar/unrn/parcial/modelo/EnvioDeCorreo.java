package ar.unrn.parcial.modelo;

import java.util.HashMap;

public interface EnvioDeCorreo {

	public void actualizar(HashMap<String, String> datos);

	public String recuperarContenidoDeCorreo();
}
