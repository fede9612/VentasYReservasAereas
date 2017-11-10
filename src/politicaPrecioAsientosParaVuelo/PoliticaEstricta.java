package politicaPrecioAsientosParaVuelo;

import vuelos.Vuelo;

public class PoliticaEstricta extends PoliticaDePrecio{
	
	public PoliticaEstricta(double precio) {
		super(precio);
	}

	@Override
	public double getPrecio(Vuelo vuelo) {
		return this.getPrecioStandar();
	}

}
