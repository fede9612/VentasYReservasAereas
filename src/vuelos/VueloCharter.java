package vuelos;

import asociacionInternacionalTransporteAereo.IATA;
import avion.Avion;
import criterioDeVentaPasajes.Criterio;

public class VueloCharter extends Vuelo{

	private int cantPasajeros;
	
	public VueloCharter(Avion avion, int cantPasajeros){
		super(avion);
		this.cantPasajeros = cantPasajeros;
	}
	
	
	public int getCantPasajeros(){
		return this.cantPasajeros;
	}
	
	@Override
	public int getCantDeAsientosLibres() {
		return (this.getAvion().getCantAsientos() - 30) - (this.cantPasajeros) - this.getCantDePasajesVendidos();
	}


	@Override
	public double getPesoDeLaCarga() {
		return this.get5000KgFijos();
	}


	private double get5000KgFijos() {
		return 5000;
	}


	@Override
	public double getPesoDeLosPasajeros() {
		return this.getCantDePasajeros() * IATA.iata().getPesoStandarPersona();
	}



}
