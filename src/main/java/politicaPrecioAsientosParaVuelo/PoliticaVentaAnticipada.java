package politicaPrecioAsientosParaVuelo;

import vuelos.Vuelo;

public class PoliticaVentaAnticipada extends PoliticaDePrecio{
	
	public PoliticaVentaAnticipada(double precio) {
		super(precio);
	}

	public boolean getVueloTieneMenosDe40PasajesVendidos(Vuelo vuelo){
		return vuelo.getCantDePasajesVendidos() < 40;
	}
	
	public boolean getVueloTieneEntre40Y79PasajesVendidos(Vuelo vuelo){
		return vuelo.getCantDePasajesVendidos() >= 40 &&
				vuelo.getCantDePasajesVendidos() <=79;
	}
	
	@Override
	public double getPrecio(Vuelo vuelo) {
		if(this.getVueloTieneMenosDe40PasajesVendidos(vuelo)){
			return this.getPrecioStandar() - ((this.getPrecioStandar() * 30) / 100);
		}
		if(this.getVueloTieneEntre40Y79PasajesVendidos(vuelo)){
			return this.getPrecioStandar() - ((this.getPrecioStandar() * 60) / 100);
		}
		return this.getPrecioStandar();
	}

}
