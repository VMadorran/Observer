package ar.unrn.tp6.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableDecorator {
	private List<ObserverDecorator> observadores = new ArrayList<ObserverDecorator>();

	protected void agregarServicio(ObserverDecorator observador) {
		this.observadores.add(observador);
	}

	protected void notificarCambioDeTemperatura(String temperatura) {
		for (ObserverDecorator observador : observadores) {
			observador.climaActualizado(temperatura);
		}
	}
}
