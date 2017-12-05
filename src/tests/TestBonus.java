package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import avion.Avion;
import criterioDeVentaPasajes.Criterio;
import criterioDeVentaPasajes.CriterioSegura;
import empresa.Empresa;
import pasaje.Pasaje;
import pasajeroPersona.Pasajero;
import politicaPrecioAsientosParaVuelo.PoliticaEstricta;
import ventaDelPasaje.Pago;
import ventaDelPasaje.Venta;
import vuelos.Ciudad;
import vuelos.Vuelo;
import vuelos.VueloNormal;

public class TestBonus {
	
	
	private Vuelo vueloNormal;
	private Pasajero pasajeroRamon;
	
	@Before
	public void setUp(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioSegura());
		Avion avionN23 = new Avion(200, 4.5);
		vueloNormal = new VueloNormal(avionN23);
		vueloNormal.setPoliticaDePrecio(new PoliticaEstricta(2000));
		vueloNormal.setFecha(LocalDate.now());
		
		pasajeroRamon = new Pasajero(45898753);
	}
	
	//Punto 1 del bonus
	
	@Test
	public void elCriterioDeLaEmpresaNoCambiaPorqueLaCiudadDeOrigenBsAsNoTieneCriterio() {
		Criterio criterioOriginal = Empresa.empresaUnica().getCriterio();
		vueloNormal.setDestino(Ciudad.BsAs);
		//Como buenos aires no tiene un criterio, en el vuelo se usa el criterio de la empresa.
		
		assertEquals(criterioOriginal, vueloNormal.getCriterio());
	}
	
	@Test
	public void elCriterioDeLaEmpresaCambiaPorqueLaCiudadDeOrigenCordobaTieneCriterio(){
		Criterio criterioOriginal = Empresa.empresaUnica().getCriterio();
		vueloNormal.setDestino(Ciudad.Cordoba);
		//Como Cordoba tiene criterio, en el vuelo se usa el criterio de la ciudad de origen.
		
		assertNotEquals(criterioOriginal, vueloNormal.getCriterio());
	}
	
	
	//Punto 2 del bonus
	
	@Test
	public void unaPersonaAbono2CuotasYTieneUnaDeudaDe800pesos(){
		vueloNormal.setDestino(Ciudad.BsAs);
		Pasaje pasaje = new Pasaje(vueloNormal);
		Venta ventaDelPasaje = new Venta(vueloNormal, pasaje, pasajeroRamon);
		ventaDelPasaje.setPago(new Pago(1000));
		ventaDelPasaje.setPago(new Pago(200));
		
		assertEquals(800, ventaDelPasaje.getDeudaDeUnaPersona(),0.0);
	}
	
	
	@Test
	public void unaPersonaQueTiene3PasajesDe2000PesosSacadoYNoPagoNingunoParaUnVuelo(){
		vueloNormal.setDestino(Ciudad.BsAs);
		Pasaje pasaje = new Pasaje(vueloNormal);
		Venta ventaDelPasaje = new Venta(vueloNormal, pasaje, pasajeroRamon);
		Venta ventaDelPasaje2 = new Venta(vueloNormal, new Pasaje(vueloNormal), pasajeroRamon);
		Venta ventaDelPasaje3 = new Venta(vueloNormal, new Pasaje(vueloNormal), pasajeroRamon);
		
		assertEquals(6000, vueloNormal.getDeudaDePasajesPersona(pasajeroRamon),0.0);
	}
}
