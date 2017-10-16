package vuelos;

import avion.Avion;
import criterioDeVentaPasajes.Criterio;

public abstract class Vuelo {
	
	private int cantDePasajesVendidos;
	private Avion avion;
	private Criterio criterio;
	
	public Vuelo(Avion avion,Criterio criterio){
		this.avion = avion;
		this.criterio = criterio;
	}
	
	public Avion getAvion(){
		return this.avion;
	}
	
	public void setCantDePasajesVendidos(){
		this.cantDePasajesVendidos += 1; 
	}
	
	public int getCantDePasajesVendidos(){
		return this.cantDePasajesVendidos;
	}
	
	public boolean getEsRelajado(){
		return (this.getAvion().getAlturaDeCabina() > 4) && (this.getAvion().getCantAsientos() < 100);
	}
	
	public Criterio getCriterio(){
		return this.criterio;
	}
	
	public boolean getPuedeVenderse(){
		return this.getCriterio().getPuedeVenerPasajes(this);
	}
	
	public abstract int getCantDeAsientosLibres();

}
