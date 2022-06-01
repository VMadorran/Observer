package ar.unrn.tp6.main;

import java.util.List;

import ar.unrn.tp6.modelo.Caldera;
import ar.unrn.tp6.modelo.Medidor;
import ar.unrn.tp6.modelo.RegistroDeTemperatura;
import ar.unrn.tp6.modelo.WeatherChannelService;

public class ClimaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var medidor = new Medidor(new WeatherChannelService(), List.of(new RegistroDeTemperatura(), new Caldera()));

		System.out.println(medidor.leerTemperatura());
	}

}
