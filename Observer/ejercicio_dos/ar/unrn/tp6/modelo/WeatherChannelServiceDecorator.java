package ar.unrn.tp6.modelo;

import java.util.Random;

public class WeatherChannelServiceDecorator implements ClimaOnlineDecorator {
	@Override
	public String temperatura() {
		int temp = new Random().nextInt(100);
		return temp + " c";
	}
}