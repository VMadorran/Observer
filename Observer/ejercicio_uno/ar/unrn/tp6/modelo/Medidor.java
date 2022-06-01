package ar.unrn.tp6.modelo;

import java.util.List;

public class Medidor extends ObservableDecorator {
	private String temperatura;
	private ClimaOnlineDecorator clima;

	public Medidor(ClimaOnlineDecorator clima, List<ObserverDecorator> observadores) {
		this.clima = clima;

		for (ObserverDecorator observador : observadores) {
			this.agregarServicio(observador);
		}
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		this.notificarCambioDeTemperatura(temperatura);//
		return this.temperatura;

	}
}