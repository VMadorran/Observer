package ar.unrn.parcial.persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import ar.unrn.parcial.modelo.Persistencia;
import ar.unrn.parcial.modelo.Venta;

public class EnArchivoPersistencia implements Persistencia {

	private String separadorDeCampo;

	public EnArchivoPersistencia(String separadorDeCampo) {
		this.separadorDeCampo = separadorDeCampo;
	}

	@Override
	public void registrarVenta(Venta venta) {
		// TODO Auto-generated method stub
		try {
			String datos = venta.datosDeVenta(separadorDeCampo);
			String ruta = "C:\\Users\\valen\\Desktop\\datosdeventas.txt";
			File file = new File(ruta);

			// Si el archivo no existe es creado
			if (!file.exists()) {

				file.createNewFile();
			}
			Files.write(Paths.get(ruta), datos.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Venta> recuperarVentas() {
		// TODO Auto-generated method stub
		return null;
	}

}
