package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import avion.Avion;
import criterioDeVentaPasajes.CriterioSegura;
import empresa.Empresa;
import pasaje.Pasaje;
import pasajeroPersona.Pasajero;
import politicaPrecioAsientosParaVuelo.PoliticaDePrecio;
import politicaPrecioAsientosParaVuelo.PoliticaEstricta;
import ventaDelPasaje.Venta;
import vuelos.Ciudad;
import vuelos.Vuelo;
import vuelos.VueloNormal;
import vuelos.VueloStore;

public class TestVueloStore {
	
	private Vuelo vuelo1;
	private Vuelo vuelo2;
	private Vuelo vuelo3;
	private Pasajero pasajero1;
	private Pasajero pasajero2;
	
	@Before
	public void setUp(){
		//Vacio los vuelos para que esten limpio en cada test.
		VueloStore.store().limpiarVuelos();
		Avion avionN23 = new Avion(200, 4.5);
		
		Empresa.empresaUnica().cambiarCriterio(new CriterioSegura());
		//Ver si aca hay un error porque tendria que haber una empresa que le pone a sus vuelo la politica de precio
		vuelo1 = new VueloNormal(avionN23);
		vuelo1.setPoliticaDePrecio(new PoliticaEstricta(2000));
		vuelo1.setFecha(LocalDate.now());
		vuelo1.setCiudad(Ciudad.BsAs);
		
		vuelo2 = new VueloNormal(avionN23);
		vuelo2.setPoliticaDePrecio(new PoliticaEstricta(2000));
		vuelo2.setFecha(LocalDate.now());
		vuelo2.setCiudad(Ciudad.BsAs);
		
		vuelo3 = new VueloNormal(avionN23);
		vuelo3.setPoliticaDePrecio(new PoliticaEstricta(2000));
		vuelo3.setFecha(LocalDate.now());
		vuelo3.setCiudad(Ciudad.BsAs);
		
		pasajero1 = new Pasajero(39146980);
		pasajero2 = new Pasajero(39146925);
	}
	
	@Test
	public void dosPersonasSoncompanierasPorCompartirAlMenos3ViajesJuntos() {
		Venta ventaPasajero1 = new Venta(vuelo1, new Pasaje(vuelo1), pasajero1);
		Venta venta2Pasajero1 = new Venta(vuelo2, new Pasaje(vuelo2), pasajero1);
		Venta venta3Pasajero1 = new Venta(vuelo3, new Pasaje(vuelo3), pasajero1);

		Venta ventaPasajero2 = new Venta(vuelo1, new Pasaje(vuelo1), pasajero2);
		Venta venta2Pasajero2 = new Venta(vuelo2, new Pasaje(vuelo2), pasajero2);
		Venta venta3Pasajero2 = new Venta(vuelo3, new Pasaje(vuelo3), pasajero2);
		
		VueloStore.store().addVuelo(vuelo1);
		VueloStore.store().addVuelo(vuelo2);
		VueloStore.store().addVuelo(vuelo3);
		
		assertTrue(VueloStore.store().getSonCompanieros(pasajero1, pasajero2));
	}
	
	@Test
	public void dosPersonasNoSonCompanierasPorNoCompartirAlMenos3ViajesJuntos(){
		Venta ventaPasajero1 = new Venta(vuelo1, new Pasaje(vuelo1), pasajero1);
		Venta venta2Pasajero1 = new Venta(vuelo2, new Pasaje(vuelo2), pasajero1);
		//Venta venta3Pasajero1 = new Venta(vuelo3, new Pasaje(vuelo3), pasajero1); Este vuelo no lo comparten

		Venta ventaPasajero2 = new Venta(vuelo1, new Pasaje(vuelo1), pasajero2);
		Venta venta2Pasajero2 = new Venta(vuelo2, new Pasaje(vuelo2), pasajero2);
		Venta venta3Pasajero2 = new Venta(vuelo3, new Pasaje(vuelo3), pasajero2);
		
		VueloStore.store().addVuelo(vuelo1);
		VueloStore.store().addVuelo(vuelo2);
		VueloStore.store().addVuelo(vuelo3);
		
		assertFalse(VueloStore.store().getSonCompanieros(pasajero1, pasajero2));
	}
	
	@Test
	public void paraLaFecha23102018TieneSacadoPasajeEnTahitiLaPersonaConDNI39146925(){
		//Le seteo el destino, la fecha, creo la venta, etc al vuelo
		vuelo1.setDestino(Ciudad.Tahiti);
		LocalDate fechaTahiti = LocalDate.of(2018, Month.OCTOBER, 23);
		vuelo1.setFecha(fechaTahiti);
		Venta ventaParaTahiti = new Venta(vuelo1, new Pasaje(vuelo1), pasajero2);
		
		//añado el vuelo al store y creo una coleccion de fechas, y a la coleccion le agrego la fecha de tahiti
		VueloStore.store().addVuelo(vuelo1);
		Collection<LocalDate> fechas = new HashSet<>();
		fechas.add(fechaTahiti);
		
		assertEquals(fechas, VueloStore.store().getFechasDeDestinoParaUnaPersonaTodosLosVuelos(pasajero2, Ciudad.Tahiti));
	}
	
	@Test
	public void paraLasFechas23102020Y11082019TieneSacadoPasajesEnBarcelonaLaPersonaConDNI39146980(){
		//Le seteo el destino, la fecha, creo la venta, etc al vuelo
		vuelo1.setDestino(Ciudad.Barcelona);
		vuelo2.setDestino(Ciudad.Barcelona);
		LocalDate fechaBarcelona = LocalDate.of(2019, Month.AUGUST, 11);
		LocalDate fechaBarcelona2 = LocalDate.of(2020, Month.OCTOBER, 23);
		vuelo1.setFecha(fechaBarcelona);
		vuelo2.setFecha(fechaBarcelona2);
		Venta ventaParaBarcelona = new Venta(vuelo1, new Pasaje(vuelo1), pasajero2);
		Venta ventaParaBarcelona2 = new Venta(vuelo2, new Pasaje(vuelo2), pasajero2);
		 
		//añado el vuelo al store y creo una coleccion de fechas, y a la coleccion le agrego la fecha de tahiti
		VueloStore.store().addVuelo(vuelo1);
		VueloStore.store().addVuelo(vuelo2);
		Collection<LocalDate> fechas = new HashSet<>();
		fechas.add(fechaBarcelona);
		fechas.add(fechaBarcelona2);
		
		assertEquals(fechas, VueloStore.store().getFechasDeDestinoParaUnaPersonaTodosLosVuelos(pasajero2, Ciudad.Barcelona));
	}
	
	
	/*@Test
	public void asientosLibresEntreDosFechas(){
		//Le seteo el destino, la fecha, creo la venta, etc al vuelo
		vuelo1.setDestino(Ciudad.Barcelona);
		vuelo2.setDestino(Ciudad.Barcelona);
		LocalDate fechaBarcelona = LocalDate.of(2019, Month.AUGUST, 11);
		LocalDate fechaBarcelona2 = LocalDate.of(2020, Month.OCTOBER, 23);
		vuelo1.setFecha(fechaBarcelona);
		vuelo2.setFecha(fechaBarcelona2);
		Venta ventaParaBarcelona = new Venta(vuelo1, new Pasaje(vuelo1), pasajero2);
		Venta ventaParaBarcelona2 = new Venta(vuelo2, new Pasaje(vuelo2), pasajero2);
		 
		//añado el vuelo al store y creo una coleccion de fechas, y a la coleccion le agrego la fecha de tahiti
		VueloStore.store().addVuelo(vuelo1);
		VueloStore.store().addVuelo(vuelo2);
		Collection<LocalDate> fechas = new HashSet<>();
		fechas.add(fechaBarcelona);
		fechas.add(fechaBarcelona2);
		
		LocalDate fecha1 = LocalDate.of(2019, Month.APRIL, 10);
		LocalDate fecha2 = LocalDate.of(2020, Month.DECEMBER, 10);
		
		assertEquals(400, VueloStore.store().getCantidadDeAsientosLibresEntreDosFechas(fecha1, fecha2, Ciudad.Barcelona));
	}*/
}
