package ventaDelPasaje;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import pasaje.Pasaje;
import pasajeroPersona.Pasajero;
import vuelos.Destino;
import vuelos.Vuelo;

public class Venta {
	private Pasaje pasaje;
	private Vuelo vuelo;
	private double precioDelPasaje;
	private LocalDate fechaDelVuelo;
	private Pasajero pasajero;
	private Collection<Pago> pagos = new HashSet<>();
	
	
	public Venta(Vuelo vuelo, Pasaje pasaje, Pasajero pasajero){
		vuelo.getPuedeVenderse();
		this.pasaje = pasaje;
		this.vuelo = vuelo;
		this.precioDelPasaje = vuelo.getPrecio();
		this.pasajero = pasajero;
		this.vuelo.setVentas(this); //Cada vez que se instacie una venta, se suma a la lista de ventas del vuelo
		this.fechaDelVuelo = this.getVuelo().getFechaDelViaje();
	}
	
	public void setPago(Pago pago){
		this.pagos.add(pago);
	}
	
	public Collection<Pago> getPagos(){
		return this.pagos;
	}
	
	public double getTotalDePagos(){
		return 0 + this.pagos.stream().mapToDouble(p -> p.getMonto()).sum();
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

	public int getDni() {
		return this.pasajero.getDni();
	}

	public LocalDate getFechaDeVenta() {
		return this.fechaDelVuelo;
	}
	
	public Destino getDestino(){
		return this.vuelo.getDestino();
	}
	
}
