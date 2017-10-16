package vuelos;

import avion.Avion;
import criterioDeVentaPasajes.Criterio;

public class VueloCharter extends Vuelo{

	private int cantPasajeros;
	
	public VueloCharter(Avion avion, int cantPasajeros, Criterio criterio){
		super(avion, criterio);
		this.cantPasajeros = cantPasajeros;
	}
	
	
	public int getCantPasajeros(){
		return this.cantPasajeros;
	}
	
	@Override
	public int getCantDeAsientosLibres() {
		return (this.getAvion().getCantAsientos() - 30) - (this.cantPasajeros) - this.getCantDePasajesVendidos();
	}



}
