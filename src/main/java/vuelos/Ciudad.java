package vuelos;

import java.util.Optional;

import criterioDeVentaPasajes.Criterio;
import org.uqbar.commons.utils.Observable;

@Observable
public enum Ciudad {
	Tahiti("Tahiti"), Barcelona("Barcelona"), LosAngeles("Los Angeles"), BsAs("Buenos Aires"),
	Mendoza("Mendoza"), SanLuis("San Luis"), Cordoba(Criterio.AMENAZA, "Cordoba");

	private Optional<Criterio> criterio;
	private String nombre;
	
	private Ciudad(Criterio criterio, String nombre){
		this.criterio = Optional.of(criterio);
		this.nombre = nombre;
		CiudadStore.store().setCiudades(this);
	}
	
	private Ciudad(String nombre){
		this.criterio = Optional.empty();
		this.nombre = nombre;
		CiudadStore.store().setCiudades(this);
	}
	
	public Optional<Criterio> getCriterio(){
		return this.criterio;
	}

	public String getNombre(){
		return this.nombre;
	}
}
