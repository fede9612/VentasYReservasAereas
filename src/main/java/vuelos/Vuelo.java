package vuelos;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import asociacionInternacionalTransporteAereo.IATA;
import avion.Avion;
import criterioDeVentaPasajes.Criterio;
import empresa.Empresa;
import pasajeroPersona.Pasajero;
import politicaPrecioAsientosParaVuelo.PoliticaDePrecio;
import ventaDelPasaje.Venta;

@Observable
public abstract class Vuelo {
	
	private int cantDePasajesVendidos;
	private Avion avion;
	private Empresa empresa = Empresa.empresaUnica();
	private PoliticaDePrecio politicaDePrecio;
	private Collection<Venta> ventas = new HashSet<>();
	private double distanciaDelVueloKM;
	private LocalDate fecha;
	private Ciudad ciudadDestino;
	private Ciudad ciudadOrigen;
	
	public Vuelo(Avion avion){
		this.avion = avion;
	}

	public Vuelo() {

	}

	public void setPoliticaDePrecio(PoliticaDePrecio poli){
		this.politicaDePrecio = poli;
	}
	
	public Avion getAvion(){
		return this.avion;
	}
	
	public double getPrecio(){
		return this.politicaDePrecio.getPrecio(this);
	}
	
	public void setCantDePasajesVendidos(){
		this.cantDePasajesVendidos += 1; 
	}
	
	public int getCantDePasajesVendidos(){
		return this.cantDePasajesVendidos;
	}
	
	public boolean getEsRelajado(){
		return (this.getAvion().getAlturaDeCabina() > 4) && (this.getCantAsientos() < 100);
	}
	
	public abstract int getCantAsientos();

	public Criterio getCriterio(){
		return this.getDestino().getCriterio().orElse(this.empresa.getCriterio());
	}
	
	public boolean verificarDisponibilidad(){
		if(this.getCriterio().getPuedeVenderPasajes(this)){
			return true;
		}else{
			throw new RuntimeException("El vuelo no se puede vender");
		}
		
	}
	
	public double getImporteTotalGeneradoPorVentas(){
		return this.ventas.stream().mapToDouble(v -> v.getPrecioDelVuelo()).sum();
	}
	
	public abstract int getCantDeAsientosLibres();

	public void addVentas(Venta venta) {
		this.ventas.add(venta);
	}
	
	//Templay Method
	public double getPesoMaximo(){
		return this.getAvion().getPeso() + (this.getPesoDeLosPasajeros()) +
				this.getPesoDeLaCarga() + this.getPesoDeLaNafta() + this.getPesoEquipamientoReglamentarioIATA();
				
	}

	private double getPesoEquipamientoReglamentarioIATA() {
		return IATA.iata().getPesoEquipamientoReglamentario();
	}

	private double getPesoDeLaNafta() {
		return this.getDistanciaDelVueloKM() * this.getAvion().getConsumoNafta();
	}

	public double getCantDePasajeros() {
		return this.cantDePasajesVendidos;
	}
	
	public abstract double getPesoDeLosPasajeros();
	public abstract double getPesoDeLaCarga();

	public double getDistanciaDelVueloKM() {
		return distanciaDelVueloKM;
	}

	public void setDistanciaDelVueloKM(double distanciaDelVueloKM) {
		this.distanciaDelVueloKM = distanciaDelVueloKM;
	}

	public LocalDate getFechaDelViaje() {
		return this.fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Boolean estePasajeroPerteneceAlVuelo(Pasajero pasajero){
		return this.ventas.stream().anyMatch(p -> p.getDni() == pasajero.getDni());
	}
	
	public Ciudad getDestino() {
		return ciudadDestino;
	}

	public void setDestino(Ciudad ciudad) {
		this.ciudadDestino = ciudad;
	}
	
	public Ciudad getOrigen() {
		return ciudadOrigen;
	}

	public void setOrigen(Ciudad ciudad) {
		this.ciudadOrigen = ciudad;
	}
	
	public double getMontoEfectivamenteCobrado(){
		return this.ventas.stream().mapToDouble(v -> v.getTotalDePagos()).count();
	}
	
	public double getDeudaDePasajesPersona(Pasajero pasajero){
		return this.pasajesCompradosPorPasajero(pasajero).stream().mapToDouble(v -> v.getDeudaDeUnaPersona()).sum();
	}
	
	private Collection<Venta> pasajesCompradosPorPasajero(Pasajero pasajero){
		return this.ventas.stream().filter(v -> v.getDni() == pasajero.getDni()).collect(Collectors.toSet());
	}

	public Collection<Pasajero> getPasajerosDelVuelo(){
		return this.ventas.stream().map(p -> p.getPasajero()).collect(Collectors.toSet());
	}

	public abstract String getTipo();

	public Collection<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Collection<Venta> ventas) {
		this.ventas = ventas;
	}
	
}
