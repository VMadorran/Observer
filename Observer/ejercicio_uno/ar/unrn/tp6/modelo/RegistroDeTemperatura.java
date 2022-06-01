package ar.unrn.tp6.modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class RegistroDeTemperatura implements ObserverDecorator {

	@Override
	public void climaActualizado(String clima) {
		// TODO Auto-generated method stub

		LocalDate hoy = LocalDate.now();
		try {

			String ruta = "C:\\Users\\valen\\Desktop\\registro de temperatura.txt";
			String registro = clima + " Fecha: " + hoy.toString() + "\n";
			File file = new File(ruta);

			if (!file.exists()) {

				file.createNewFile();
			}
			Files.write(Paths.get(ruta), registro.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
