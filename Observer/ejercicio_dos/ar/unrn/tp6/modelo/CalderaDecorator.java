package ar.unrn.tp6.modelo;

public class CalderaDecorator implements ObserverDecorator {

	@Override
	public void climaActualizado(String clima) {
		// TODO Auto-generated method stub

		int temperatura = this.cambiarFormato(clima);

		if (temperatura < 12)
			System.out.println("“Hace frio, se encenderá la caldera”");
		if (temperatura > 17)
			System.out.println("“Hace calor, se encenderá el aire acondicionado”");

	}

	private int cambiarFormato(String clima) {

		String temperatura = "";
		char[] cadena = clima.toCharArray();
		for (int i = 0; i < cadena.length; i++) {

			if (Character.isDigit(cadena[i]))
				temperatura = temperatura + cadena[i];
		}
		int digitos = Integer.parseInt(temperatura);
		return digitos;
	}
}
