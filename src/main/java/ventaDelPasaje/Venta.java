package ventaDelPasaje;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import org.uqbar.commons.utils.Observable;
import pasaje.Pasaje;
import pasajeroPersona.Pasajero;
import vuelos.Ciudad;
import vuelos.Vuelo;

@Observable
public class Venta {
	private Pasaje pasaje;
	private Vuelo vuelo;
	private double precioDelPasaje;
	private LocalDate fechaDelVuelo;
	private LocalDate fechaDeCompra;
	private Pasajero pasajero;

	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}

	private Collection<Pago> pagos;


	public Venta(Vuelo vuelo, Pasaje pasaje, Pasajero pasajero){
		vuelo.verificarDisponibilidad();
		this.pagos = new HashSet<>();
		this.pasaje = pasaje;
		this.vuelo = vuelo;
		this.precioDelPasaje = vuelo.getPrecio();
		this.pasajero = pasajero;
		this.fechaDelVuelo = this.getVuelo().getFechaDelViaje();
		this.vuelo.addVentas(this); //Cada vez que se instacie una venta, se suma a la lista de ventas del vuelo
	}
	
	public void agregarPago(Pago pago){
		this.pagos.add(pago);
	}
	
	public Collection<Pago> getPagos(){
		return this.pagos;
	}
	
	public double getTotalDePagos(){
		return 0 + this.pagos.stream().mapToDouble(p -> p.getMontoDelPago()).sum();
	}
	
	public double getDeudaDeUnaPersona(){
		return this.getPrecioDelVuelo() - this.getTotalDePagos();
	}
	
	public Pasaje getPasaje() {
		return this.pasaje;
	}

	public Vuelo getVuelo() {
		return this.vuelo;
	}

	public double getPrecioDelVuelo() {
		return this.precioDelPasaje;
	}

	public String getDni() {
		return this.pasajero.getDni();
	}

	public LocalDate getFechaDeVenta() {
		return this.fechaDelVuelo;
	}
	
	public Ciudad getDestino(){
		return this.vuelo.getDestino();
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public LocalDate getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(LocalDate fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
}
