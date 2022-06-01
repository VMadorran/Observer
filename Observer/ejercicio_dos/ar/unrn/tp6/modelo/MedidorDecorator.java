package ar.unrn.tp6.modelo;

public class MedidorDecorator implements Decorator {
	private String temperatura;
	private ClimaOnlineDecorator clima;

	public MedidorDecorator(ClimaOnlineDecorator clima) {
		this.clima = clima;
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		return this.temperatura;
	}
}
