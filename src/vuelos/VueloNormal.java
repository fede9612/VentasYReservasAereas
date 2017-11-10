package vuelos;

import asociacionInternacionalTransporteAereo.IATA;
import avion.Avion;
import criterioDeVentaPasajes.Criterio;

public class VueloNormal extends Vuelo{
	
	private double kgDeCargaPorPasajero;
	
	public VueloNormal(Avion avion){
		super(avion);
	}
	
	
	public int getCantDeAsientosLibres() {
		return (this.getAvion().getCantAsientos() - this.getCantDeAsientosOcupados());
	}
	
	
	public int getCantDeAsientosOcupados() {
		return this.getCantDePasajesVendidos();
	}


	@Override
	public double getPesoDeLaCarga() {
		return this.getCantDePasajeros() * this.getKgDeCargaPorPasajero();
	}


	public double getKgDeCargaPorPasajero() {
		return kgDeCargaPorPasajero;
	}


	public void setKgDeCargaPorPasajero(double kgDeCargaPorPasajero) {
		this.kgDeCargaPorPasajero = kgDeCargaPorPasajero;
	}


	@Override
	public double getPesoDeLosPasajeros() {
		return this.getCantDePasajeros() * IATA.iata().getPesoStandarPersona();
	}



}
