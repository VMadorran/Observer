package ar.unrn.tp6.modelo;

import java.util.List;

public class DecoradorMedidor extends ObservableDecorator implements Decorator {

	private Decorator medidor;

	public DecoradorMedidor(Decorator medidor, List<ObserverDecorator> observadores) {
		this.medidor = medidor;
		for (ObserverDecorator observador : observadores) {
			this.agregarServicio(observador);
		}
	}

	@Override
	public String leerTemperatura() {

		String temperatura = this.medidor.leerTemperatura();
		this.notificarCambioDeTemperatura(temperatura);
		return temperatura;
	}

}
