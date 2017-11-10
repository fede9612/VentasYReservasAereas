package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import avion.Avion;
import criterioDeVentaPasajes.CriterioSegura;
import pasaje.Pasaje;
import politicaPrecioAsientosParaVuelo.PoliticaEstricta;
import politicaPrecioAsientosParaVuelo.PoliticaRemate;
import politicaPrecioAsientosParaVuelo.PoliticaVentaAnticipada;
import vuelos.Vuelo;
import vuelos.VueloNormal;

public class TestPoliticaPreciosDeVuelo {
	
	
	private Avion avionN32;
	private Vuelo vueloNormal;

	public TestPoliticaPreciosDeVuelo() {
		
	}

	@Before
	public void setUp(){
		avionN32 = new Avion(200, 5);
		vueloNormal = new VueloNormal(avionN32);
	}
	
	@Test
	public void precioStandar2000ParaUnVuelo() {
		vueloNormal.setPoliticaDePrecio(new PoliticaEstricta(2000));
		
		assertEquals(2000, vueloNormal.getPrecio(), 0.0001);
													
	}
	
	@Test
	public void tiene30PorcientoDelPrecioStandar2000PorSerAnticipada(){
		vueloNormal.setPoliticaDePrecio(new PoliticaVentaAnticipada(2000));
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(33);
		
		assertEquals(1400,vueloNormal.getPrecio(),0.1);
	}
	
	@Test
	public void tiene60PorcientoDelPrecioStandarPorSerAnticipada(){
		vueloNormal.setPoliticaDePrecio(new PoliticaVentaAnticipada(2000));
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(55);
		
		assertEquals(800, vueloNormal.getPrecio(),0.1);
	}
	
	@Test
	public void noTieneDescuentoVentaAnticipadaPor15PasajesVendidos(){
		vueloNormal.setPoliticaDePrecio(new PoliticaVentaAnticipada(2000));
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(80);
	
		assertEquals(2000, vueloNormal.getPrecio(),0.1);
	}
	
	@Test
	public void porciento25PorSerRemateYTenerMasDe30AsientosLibre(){
		vueloNormal.setPoliticaDePrecio(new PoliticaRemate(2000));
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(80);
		
		assertEquals(1500, vueloNormal.getPrecio(),0.1);
	}
	
	@Test
	public void porciento50PorSerRemateYTenerMasDe30AsientosLibre(){
		vueloNormal.setPoliticaDePrecio(new PoliticaRemate(2000));
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(195);
		
		assertEquals(1000, vueloNormal.getPrecio(),0.1);
	}
	
	
}
