package vuelos;

import avion.Avion;
import criterioDeVentaPasajes.Criterio;

public class VueloNormal extends Vuelo{
	
	public VueloNormal(Avion avion, Criterio criterio){
		super(avion, criterio);
	}
	
	
	public int getCantDeAsientosLibres() {
		return (this.getAvion().getCantAsientos() - this.getCantDeAsientosOcupados());
	}
	
	
	public int getCantDeAsientosOcupados() {
		return this.getCantDePasajesVendidos();
	}



}
