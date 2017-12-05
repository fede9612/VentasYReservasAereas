package politicaPrecioAsientosParaVuelo;

import vuelos.Vuelo;

public abstract class PoliticaDePrecio{
	private double precioVuelo;

	public PoliticaDePrecio(double precio) {
		this.precioVuelo = precio;
	}
	
	public double getPrecioStandar(){
		return this.precioVuelo;
	}
	
	public abstract double getPrecio(Vuelo vuelo);
}
