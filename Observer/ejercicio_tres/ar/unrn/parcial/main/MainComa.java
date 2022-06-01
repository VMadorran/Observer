package ar.unrn.parcial.main;

import ar.unrn.parcial.correo.MailTrap;
import ar.unrn.parcial.modelo.Calculador;
import ar.unrn.parcial.modelo.ProveedorDeFecha;
import ar.unrn.parcial.modelo.RegistroDeVentasImplementacion;
import ar.unrn.parcial.persistencia.EnArchivoPersistencia;
import ar.unrn.parcial.ui.VentanaUI;

public class MainComa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var archivo = new EnArchivoPersistencia(",");
		var registro = new RegistroDeVentasImplementacion(archivo);
		var calculador = new Calculador(registro);
		calculador.agregarObservador(new MailTrap());
		var fecha = new ProveedorDeFecha();
		var ventana = new VentanaUI(calculador, fecha);
	}

}
