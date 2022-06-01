package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public abstract class Remera {
	private double precio;
	private LocalDateTime fechaDeCompra;
	private String nombre;
	public static final double DESCUENTO_DOMINGO = 10;
	public static final double DESCUENTO_MAS_DE_TRES = 12;
	public static final double PRECIO_ESTAMPADA = 2500;
	public static final double PRECIO_LISA = 2000;
	public static final double DESCUENTO_DE_MANIANA = 5;
	public static final int CANTIDAD_DE_REMERAS = 3;
	public static final int HORA_RANGO_INFERIOR = 8;
	public static final int HORA_RANGO_SUPERIOR = 10;

	public abstract double calcularMontoDeRemera(int cantidad);

}
