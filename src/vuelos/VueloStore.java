package vuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import pasajeroPersona.Pasajero;

public class VueloStore {
	private static VueloStore store = new VueloStore();
	
	private List<Vuelo> vuelos = new ArrayList<>();
	
	public List<Vuelo> getVuelos(){
		return this.vuelos;
	}
	
	public static VueloStore store(){
		return store;
	}
	
	public void addVuelo(Vuelo vuelo){
		this.vuelos.add(vuelo);
	}
	
	public Collection<LocalDate> getFechasDeDestinoParaUnaPersonaTodosLosVuelos(Pasajero pasajero, Destino destino){
		return this.getPersonaViajaEnVueloSegunDestino(pasajero, destino).stream().map(v -> v.getFechaDelViaje()).collect(Collectors.toSet());
	}
	
	private Collection<Vuelo> getPersonaViajaEnVueloSegunDestino(Pasajero pasajero, Destino destino){
		return this.getDestinoDelVueloEs(destino).stream().filter(v -> v.estePasajeroPerteneceAlVuelo(pasajero)).collect(Collectors.toSet());
	}
	
	private Collection<Vuelo> getDestinoDelVueloEs(Destino destino){
		return this.getVuelos().stream().filter(v -> v.getDestino() == destino).collect(Collectors.toSet());
	}
	
	public Boolean getSonCompanieros(Pasajero pasajero1, Pasajero pasajero2){
		return this.getVuelosCompartidosEntreDosPersonas(pasajero1, pasajero2).size() >= 3;
	}
	
	private Collection<Vuelo> getVuelosCompartidosEntreDosPersonas(Pasajero pasajero1, Pasajero pasajero2){
		return this.getVuelos().stream().filter(v -> v.estePasajeroPerteneceAlVuelo(pasajero1) && v.estePasajeroPerteneceAlVuelo(pasajero2)).collect(Collectors.toSet());
	}

	public void limpiarVuelos() {
		this.vuelos.clear();
	}
	
	//Hacer test de esto
	public Collection<Vuelo> getVueloEntreDosFechas(LocalDate fecha1, LocalDate fecha2){
		return this.getVuelos().stream().filter(v -> v.getFechaDelViaje().isAfter(fecha1) && fecha2.isAfter(v.getFechaDelViaje())).collect(Collectors.toSet());
	}
}
