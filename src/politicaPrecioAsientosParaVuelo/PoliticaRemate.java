package politicaPrecioAsientosParaVuelo;

import vuelos.Vuelo;

public class PoliticaRemate extends PoliticaDePrecio{

	public PoliticaRemate(double precio) {
		super(precio);
	}

	@Override
	public double getPrecio(Vuelo vuelo) {
		if(vuelo.getCantDeAsientosLibres() > 30){
			return this.getPrecioStandar() - ((this.getPrecioStandar() * 25) / 100);
		}
		return this.getPrecioStandar() - ((this.getPrecioStandar() * 50) / 100);
	}

}
