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
	
	public Collection<LocalDate> getFechasDeDestinoParaUnaPersonaTodosLosVuelos(Pasajero pasajero, Ciudad ciudad){
		return this.getPersonaViajaEnVueloSegunDestino(pasajero, ciudad).stream().map(v -> v.getFechaDelViaje()).collect(Collectors.toSet());
	}
	
	private Collection<Vuelo> getPersonaViajaEnVueloSegunDestino(Pasajero pasajero, Ciudad ciudad){
		return this.getDestinoDelVueloEs(ciudad).stream().filter(v -> v.estePasajeroPerteneceAlVuelo(pasajero)).collect(Collectors.toSet());
	}
	
	private Collection<Vuelo> getDestinoDelVueloEs(Ciudad ciudad){
		return this.getVuelos().stream().filter(v -> v.getDestino() == ciudad).collect(Collectors.toSet());
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
		return this.getVuelos().stream().filter(v -> v.getFechaDelViaje().isAfter(fecha1) && fecha2.isBefore(v.getFechaDelViaje())).collect(Collectors.toSet());
	}
	
	public Collection<Vuelo> getVuelosEntreFechasSegunDestino(LocalDate fecha1, LocalDate fecha2, Ciudad ciudad){
		return this.getVueloEntreDosFechas(fecha1, fecha2).stream().filter(v -> v.getDestino().equals(ciudad)).collect(Collectors.toSet());
	}
	
	public int getCantidadDeAsientosLibresEntreDosFechas(LocalDate fecha1, LocalDate fecha2, Ciudad ciudad){
		return this.getVuelosEntreFechasSegunDestino(fecha1, fecha2, ciudad).stream()
							.mapToInt(v -> v.getCantDeAsientosLibres()).sum();
	}
}
