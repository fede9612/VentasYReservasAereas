package tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import avion.Avion;
import criterioDeVentaPasajes.CriterioAmenazaTerrorista;
import criterioDeVentaPasajes.CriterioSegura;
import empresa.Empresa;
import exeption.ExeptionDeAmenazaTerrorista;
import pasaje.Pasaje;
import pasajeroPersona.Pasajero;
import ventaDelPasaje.Venta;
import vuelos.Origen;
import vuelos.VueloNormal;

public class TestPasaje {
	
	private Avion avionN23;
	private VueloNormal vueloNormal;
	
	@Before
	public void setUp(){
		avionN23 = new Avion(200, 4.5);
		vueloNormal = new VueloNormal(avionN23);
	}
	
	
	//Punto 5
	@Test (expected = ExeptionDeAmenazaTerrorista.class)
	public void noSePuedeRegistarLaVentaDeUnPasajeDeVueloNormalConAmenazaTerrorista(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioAmenazaTerrorista());
		Pasaje pasaje1 = new Pasaje(vueloNormal);
		Pasajero matias = new Pasajero(39146980);
		vueloNormal.setOrigen(Origen.BsAs);
		Venta venta1 = new Venta(vueloNormal, pasaje1, matias);
		
	}
}
