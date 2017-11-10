package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import avion.Avion;
import criterioDeVentaPasajes.Criterio;
import criterioDeVentaPasajes.CriterioLaxa;
import criterioDeVentaPasajes.CriterioPorcentaje;
import criterioDeVentaPasajes.CriterioAmenazaTerrorista;
import criterioDeVentaPasajes.CriterioSegura;
import empresa.Empresa;
import exeption.ExeptionDeAmenazaTerrorista;
import pasaje.Pasaje;
import pasajeroPersona.Pasajero;
import politicaPrecioAsientosParaVuelo.PoliticaDePrecio;
import politicaPrecioAsientosParaVuelo.PoliticaEstricta;
import ventaDelPasaje.Venta;
import vuelos.Origen;
import vuelos.Vuelo;
import vuelos.VueloDeCarga;
import vuelos.VueloNormal;

public class TestVuelo {
	
	private Avion avionN23;
	private Vuelo vueloNormal;

	public TestVuelo() {
		
	}

	@Before
	public void setUp(){
		avionN23 = new Avion(200, 4.5);
		vueloNormal = new VueloNormal(avionN23);
		vueloNormal.setOrigen(Origen.BsAs);
	}
	
	@Test
	public void vueloNormalTieneAsientosLibres200() {
		Vuelo vueloNormal = new VueloNormal(avionN23);
		
		assertEquals(200, vueloNormal.getCantDeAsientosLibres());
	}
	
	@Test
	public void vueloNormalTieneAsientosLibres30(){
		VueloNormal vueloNormal = new VueloNormal(avionN23);
		Pasaje pasajes = new Pasaje(vueloNormal);// cargar 170 pasajes, hacer un repeat de n veces(la cnatidad de pasajes en este caso 170
		pasajes.setAgregarPasajesAlVuelo(170);	//hacerlo en el pasajes, pasaje.setCantAsientos(cantidad).
		
		assertEquals(30, vueloNormal.getCantDeAsientosLibres());
		
	}
	
	@Test
	public void vueloDeCargaCon30PasajesOcupados(){
		VueloDeCarga vueloDeCarga = new VueloDeCarga(avionN23);
	
		
		//Cargo 30 pasajes al vuelo de carga
		this.cargarVueloDeCargaCon30Pasajes(vueloDeCarga);
		
		assertEquals(0, vueloDeCarga.getCantDeAsientosLibres());
	}

	private void cargarVueloDeCargaCon30Pasajes(VueloDeCarga vueloDeCarga) {
		Pasaje pasaje1 = new Pasaje(vueloDeCarga);
		Pasaje pasaje2 = new Pasaje(vueloDeCarga);
		Pasaje pasaje3 = new Pasaje(vueloDeCarga);
		Pasaje pasaje4 = new Pasaje(vueloDeCarga);
		Pasaje pasaje5 = new Pasaje(vueloDeCarga);
		Pasaje pasaje6 = new Pasaje(vueloDeCarga);
		Pasaje pasaje7 = new Pasaje(vueloDeCarga);
		Pasaje pasaje8 = new Pasaje(vueloDeCarga);
		Pasaje pasaje9 = new Pasaje(vueloDeCarga);
		Pasaje pasaje10 = new Pasaje(vueloDeCarga);
		Pasaje pasaje11 = new Pasaje(vueloDeCarga);
		Pasaje pasaje12 = new Pasaje(vueloDeCarga);
		Pasaje pasaje13 = new Pasaje(vueloDeCarga);
		Pasaje pasaje14 = new Pasaje(vueloDeCarga);
		Pasaje pasaje15 = new Pasaje(vueloDeCarga);
		Pasaje pasaje16 = new Pasaje(vueloDeCarga);
		Pasaje pasaje17 = new Pasaje(vueloDeCarga);
		Pasaje pasaje18 = new Pasaje(vueloDeCarga);
		Pasaje pasaje19 = new Pasaje(vueloDeCarga);
		Pasaje pasaje20 = new Pasaje(vueloDeCarga);
		Pasaje pasaje21 = new Pasaje(vueloDeCarga);
		Pasaje pasaje22 = new Pasaje(vueloDeCarga);
		Pasaje pasaje23 = new Pasaje(vueloDeCarga);
		Pasaje pasaje24 = new Pasaje(vueloDeCarga);
		Pasaje pasaje25 = new Pasaje(vueloDeCarga);
		Pasaje pasaje26 = new Pasaje(vueloDeCarga);
		Pasaje pasaje27 = new Pasaje(vueloDeCarga);
		Pasaje pasaje28 = new Pasaje(vueloDeCarga);
		Pasaje pasaje29 = new Pasaje(vueloDeCarga);
		Pasaje pasaje30 = new Pasaje(vueloDeCarga);
	}
	
	@Test
	public void vueloDeCargaCon30PasajesLibres(){
		
		VueloDeCarga vueloDeCarga = new VueloDeCarga(avionN23);
		
		//En este punto no importa que avion le carguemos siempre va a tener 30 asientos libres al comienzo
		//En este test es lo que estoy chequeando ya que avionN23 tiene 200 pasajes pero restringe solo 30
		assertEquals(30, vueloDeCarga.getCantDeAsientosLibres());
	}
	
	@Test
	public void vueloNoEsRelajadoConLaCabina4YMedioAsientos200(){
		Vuelo vueloNormal = new VueloNormal(avionN23);
		assertFalse(vueloNormal.getEsRelajado());
	}
	
	@Test
	public void vueloRelajadoConCabina5YAsientos80(){
		Avion avionL21 = new Avion(80, 5);
		Vuelo vueloNormal = new VueloNormal(avionL21);
		
		assertTrue(vueloNormal.getEsRelajado());
	}
	
	@Test
	public void sePuedeVenderVueloConCriterioSeguraConTodosLosAsientosDisponible(){
		assertTrue(vueloNormal.getPuedeVenderse());
	}
	
	@Test
	public void noSePuedeVenderVueloConCriterioSeguraCon1AsientoDisponible(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioSegura());
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(199);
		vueloNormal.setOrigen(Origen.BsAs);
		
		assertFalse(vueloNormal.getPuedeVenderse());
	}
	
	@Test
	public void sePuedeVenderVueloConCriterioLaxaConTodosLosAsientosOcupadosMas5(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioLaxa());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(205);
		vueloNormal.setOrigen(Origen.BsAs);
		
		assertTrue(vueloNormal.getPuedeVenderse());
	}
	
	@Test
	public void noSePuedeVenderVueloConCriterioLaxaConTodosLosAsientosOcupadosMas10(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioLaxa());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(210);
		vueloNormal.setOrigen(Origen.BsAs);
		
		assertFalse(vueloNormal.getPuedeVenderse());
	}

	//HacerTestDeNoSePuedeVenderVueloConCriterioAmenazaTerrorista
	@Test (expected = ExeptionDeAmenazaTerrorista.class)
	public void NoSePuedeVenderVueloConCriterioAmenazaTerrorista(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioAmenazaTerrorista());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		vueloNormal.setOrigen(Origen.BsAs);
		vueloNormal.getPuedeVenderse();
	}
	
	//HacerTestDeSePuedeVenderConCriterioDePorcentaje
	public void sePuedeVenderConCriterioDePorcentajeCon200AsientosDisponibles(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioPorcentaje());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(200);
		
		assertTrue(vueloNormal.getPuedeVenderse());
	}

	//HacerTestDeNoSePuedeVenderConCriterioDePorcentaje
	public void NoSePuedeVenderConCriterioDePorcentajeCon202AsientosDisponibles(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioPorcentaje());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		Pasaje pasaje = new Pasaje(vueloNormal);
		pasaje.setAgregarPasajesAlVuelo(202);
		
		assertFalse(vueloNormal.getPuedeVenderse());
	}
	
	//Punto 6
	@Test
	public void vueloCon400MilPesosGeneradoPorLasVentas(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioSegura());
		PoliticaDePrecio politicaPrecio = new PoliticaEstricta(2000);
		vueloNormal.setPoliticaDePrecio(politicaPrecio);
		for(int i = 0; i < 200; i++){
			Venta venta = new Venta(vueloNormal, new Pasaje(vueloNormal), new Pasajero(39146980 + i));
		}
		
		assertEquals(400000, vueloNormal.getImporteTotalGeneradoPorVentas(),0.11);
	}
	
	//Punto 7
	@Test
	public void pesoDeUnAvion20000PesoPasajeros15000Nafta28000Equipamiento300(){
		avionN23.setPeso(20000);
		Pasaje pasajes = new Pasaje(vueloNormal);
		pasajes.setAgregarPasajesAlVuelo(200);
		vueloNormal.setDistanciaDelVueloKM(28000);
		//20000 + (200 * 75) + 0(peso de carga en este caso no tiene) + 28000(nafta) + 300(equipamiento regammentario) 
		assertEquals(63300, vueloNormal.getPesoMaximo(),0.1);
	}
	
	@Test
	public void pesoMaximoDeUnVueloDeCargaAvion20000Carga10000Equipamiento300EquipamientoCarga700Nafta15000(){
		avionN23.setPeso(20000);
		VueloDeCarga vueloDeCarga = new VueloDeCarga(avionN23);
		vueloDeCarga.setPesoDeCarga(10000);
		vueloDeCarga.setDistanciaDelVueloKM(15000);
		
		assertEquals(46000, vueloDeCarga.getPesoMaximo(),0.1);
	}
	
}
