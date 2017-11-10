package vuelos;

import java.util.Optional;

import criterioDeVentaPasajes.Criterio;
import criterioDeVentaPasajes.CriterioAmenazaTerrorista;

public enum Origen {
	BsAs, Cordoba(Criterio.AMENAZA);
	
	private Optional<Criterio> criterio;
	
	private Origen(Criterio criterio){
		this.criterio = Optional.of(criterio);
	}
	
	private Origen(){
		this.criterio = Optional.empty();
	}
	
	public Optional<Criterio> getCriterio(){
		return this.criterio;
	}
	
	 
}
