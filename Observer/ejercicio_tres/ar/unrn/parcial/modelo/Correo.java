package ar.unrn.parcial.modelo;

public class Correo {

	private String direccion;

	public Correo(String direccion) throws Exception {
		if (!this.checkEmail(direccion))
			throw new Exception("email debe ser válido");
		this.direccion = direccion;
	}

	private boolean checkEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		return email.matches(regex);
	}

	private boolean esNulo(String email) {
		return email.equals("");
	}

	protected String direccionDeEmail() {
		return this.direccion;
	}
}
