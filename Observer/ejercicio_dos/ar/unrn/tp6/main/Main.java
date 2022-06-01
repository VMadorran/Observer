package ar.unrn.tp6.main;

import java.util.List;

import ar.unrn.tp6.modelo.CalderaDecorator;
import ar.unrn.tp6.modelo.DecoradorMedidor;
import ar.unrn.tp6.modelo.MedidorDecorator;
import ar.unrn.tp6.modelo.RegistroDeTemperaturaDecorator;
import ar.unrn.tp6.modelo.WeatherChannelServiceDecorator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var calderaYRegistro = new DecoradorMedidor(new MedidorDecorator(new WeatherChannelServiceDecorator()),
				List.of(new RegistroDeTemperaturaDecorator(), new CalderaDecorator()));

		System.out.println(calderaYRegistro.leerTemperatura());

	}

}
