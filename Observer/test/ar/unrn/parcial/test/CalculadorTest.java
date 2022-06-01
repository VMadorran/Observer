package ar.unrn.parcial.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import ar.unrn.parcial.modelo.Calculador;
import ar.unrn.parcial.modelo.EnvioDeCorreo;
import ar.unrn.parcial.modelo.Estampada;
import ar.unrn.parcial.modelo.Fecha;
import ar.unrn.parcial.modelo.Lisa;
import ar.unrn.parcial.modelo.Persistencia;
import ar.unrn.parcial.modelo.ProveedorDeFecha;
import ar.unrn.parcial.modelo.RegistroDeVentasImplementacion;
import ar.unrn.parcial.modelo.RegistroVentas;
import ar.unrn.parcial.modelo.Remera;

public class CalculadorTest {

	@Test
	public void remeraEstampada() {

		Fecha fecha = new ProveedorDeFecha();
		// int dia, int mes, int anio, int hora, int minutos)
		LocalDateTime fechaActual = fecha.now(3, 5, 2022, 15, 0);

		Persistencia persistencia = new ServicioPersistencia("|");
		RegistroVentas registro = new RegistroDeVentasImplementacion(persistencia);

		Calculador calculador = new Calculador(registro);
		calculador.agregarObservador(new ServicioEnvioDeCorreo());

		double valorEsperado = 7500;

		Remera estampada = new Estampada(fechaActual);

		assertEquals(valorEsperado, calculador.calcularMonto(estampada, 3));
	}

	@Test
	public void remeraEstampadaDescuento() {

		Fecha fecha = new ProveedorDeFecha();
		// int dia, int mes, int anio, int hora, int minutos)
		LocalDateTime fechaActual = fecha.now(7, 5, 2022, 9, 0);
		Persistencia persistencia = new ServicioPersistencia("|");
		RegistroVentas registro = new RegistroDeVentasImplementacion(persistencia);

		Calculador calculador = new Calculador(registro);
		calculador.agregarObservador(new ServicioEnvioDeCorreo());

		Remera estampada = new Estampada(fechaActual);

		double valorEsperado = 8800;

		assertEquals(valorEsperado, calculador.calcularMonto(estampada, 4));
	}

	@Test
	public void remeraLisa() {

		Fecha fecha = new ProveedorDeFecha();
		// int dia, int mes, int anio, int hora, int minutos)
		LocalDateTime fechaActual = fecha.now(7, 5, 2022, 12, 0);
		Persistencia persistencia = new ServicioPersistencia("|");
		RegistroVentas registro = new RegistroDeVentasImplementacion(persistencia);

		Calculador calculador = new Calculador(registro);
		calculador.agregarObservador(new ServicioEnvioDeCorreo());

		Remera lisa = new Lisa(fechaActual);

		double valorEsperado = 8000;
		assertEquals(valorEsperado, calculador.calcularMonto(lisa, 4));

	}

	@Test
	public void remeraLisaDescuento() {

		Fecha fecha = new ProveedorDeFecha();

		LocalDateTime fechaActual = fecha.now(1, 5, 2022, 9, 0);
		Persistencia persistencia = new ServicioPersistencia("|");
		RegistroVentas registro = new RegistroDeVentasImplementacion(persistencia);

		Calculador calculador = new Calculador(registro);
		calculador.agregarObservador(new ServicioEnvioDeCorreo());

		Remera lisa = new Lisa(fechaActual);

		double valorEsperado = 3800;

		assertEquals(valorEsperado, calculador.calcularMonto(lisa, 2));
	}

	@Test
	public void correoEnviado() {

		Fecha fecha = new ProveedorDeFecha();
		LocalDateTime fechaActual = fecha.now(1, 5, 2022, 3, 0);
		Persistencia persistencia = new ServicioPersistencia("|");
		EnvioDeCorreo enviarCorreo = new ServicioEnvioDeCorreo();
		RegistroVentas registro = new RegistroDeVentasImplementacion(persistencia);

		Calculador calculador = new Calculador(registro);
		calculador.agregarObservador(new ServicioEnvioDeCorreo());

		Remera lisa = new Lisa(fechaActual);

		try {
			calculador.registrarVenta(lisa, 4, "angus@acdc.com", fechaActual);
			String valorEsperado = "Fecha: 01/05/2022" + "\n" + "cantidad: 4" + "\n" + "Monto total:8000.0" + "\n"
					+ "angus@acdc.com" + "\n";
			String valorReal = enviarCorreo.recuperarContenidoDeCorreo();

			assertEquals(valorEsperado, valorReal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
