package vuelos;

import java.util.Optional;

import criterioDeVentaPasajes.Criterio;

public enum Ciudad {
	Tahiti, Barcelona, LosAngeles, BsAs, Cordoba(Criterio.AMENAZA);
	
	private Optional<Criterio> criterio;
	
	private Ciudad(Criterio criterio){
		this.criterio = Optional.of(criterio);
	}
	
	private Ciudad(){
		this.criterio = Optional.empty();
	}
	
	public Optional<Criterio> getCriterio(){
		return this.criterio;
	}
}
