package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import avion.Avion;
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
import vuelos.Ciudad;
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
		avionN23.setConsumo(20);
		vueloNormal = new VueloNormal(avionN23);
		vueloNormal.setDestino(Ciudad.BsAs);
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
		//pasajes.setAgregarPasajesAlVuelo(170);	//hacerlo en el pasajes, pasaje.setCantAsientos(cantidad).
		this.setPasajesAlVuelo(vueloNormal, 170);
		assertEquals(30, vueloNormal.getCantDeAsientosLibres());
		
	}
	
	@Test
	public void vueloDeCargaCon30PasajesOcupados(){
		VueloDeCarga vueloDeCarga = new VueloDeCarga(avionN23);
	
		
		//Cargo 30 pasajes al vuelo de carga
		this.cargarVueloDeCargaCon30Pasajes(vueloDeCarga);
		
		assertEquals(0, vueloDeCarga.getCantDeAsientosLibres());
	}

	//Este metodo lo pudiera haber hecho con el for que arme, nada mas que lo deje para que veas que implementaba
	//Metodos en el test
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
	public void vueloDeCargaEsRelajadoPorqueTiene30Asientos(){
		Vuelo vueloDeCarga = new VueloDeCarga(avionN23);
		
		assertTrue(vueloDeCarga.getEsRelajado());
	}
	
	@Test
	public void sePuedeVenderVueloConCriterioSeguraConTodosLosAsientosDisponible(){
		assertTrue(vueloNormal.getPuedeVenderse());
	}
	
	@Test (expected = RuntimeException.class)
	public void noSePuedeVenderVueloConCriterioSeguraCon1AsientoDisponible(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioSegura());
		Pasaje pasaje = new Pasaje(vueloNormal);
		this.setPasajesAlVuelo(vueloNormal,199);
		vueloNormal.setDestino(Ciudad.BsAs);
		
		//assertFalse(vueloNormal.getPuedeVenderse());
	}
	
	private void setPasajesAlVuelo(Vuelo vuelo, int n) {
		for(int i=1;i<n;i++){
			vuelo.setCantDePasajesVendidos();
		}
	}

	@Test
	public void sePuedeVenderVueloConCriterioLaxaConTodosLosAsientosOcupadosMas5(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioLaxa());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		Pasaje pasaje = new Pasaje(vueloNormal);
		//pasaje.setAgregarPasajesAlVuelo(205);
		this.setPasajesAlVuelo(vueloNormal, 205);
		vueloNormal.setDestino(Ciudad.BsAs);
		
		assertTrue(vueloNormal.getPuedeVenderse());
	}
	
	@Test (expected = RuntimeException.class) 
	public void noSePuedeVenderVueloConCriterioLaxaConTodosLosAsientosOcupadosMas10(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioLaxa());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		Pasaje pasaje = new Pasaje(vueloNormal);
		//pasaje.setAgregarPasajesAlVuelo(210);
		this.setPasajesAlVuelo(vueloNormal, 210);
		vueloNormal.setDestino(Ciudad.BsAs);
		
		//assertFalse(vueloNormal.getPuedeVenderse());
	}

	//HacerTestDeNoSePuedeVenderVueloConCriterioAmenazaTerrorista
	@Test (expected = ExeptionDeAmenazaTerrorista.class)
	public void NoSePuedeVenderVueloConCriterioAmenazaTerrorista(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioAmenazaTerrorista());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		vueloNormal.setDestino(Ciudad.BsAs);
		vueloNormal.getPuedeVenderse();
	}
	
	//HacerTestDeSePuedeVenderConCriterioDePorcentaje
	@Test
	public void sePuedeVenderConCriterioDePorcentajeCon200AsientosDisponibles(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioPorcentaje());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		vueloNormal.setDestino(Ciudad.BsAs);
		Pasaje pasaje = new Pasaje(vueloNormal);
		//pasaje.setAgregarPasajesAlVuelo(199);
		this.setPasajesAlVuelo(vueloNormal, 199);
		
		assertTrue(vueloNormal.getPuedeVenderse());
		//assertEquals(202, Empresa.empresaUnica().getCriterio().getCantDePasajesQueSePuedenVender(vueloNormal),0.1);
	}

	//HacerTestDeNoSePuedeVenderConCriterioDePorcentaje
	public void NoSePuedeVenderConCriterioDePorcentajeCon202AsientosDisponibles(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioPorcentaje());
		Vuelo vueloNormal = new VueloNormal(avionN23);
		Pasaje pasaje = new Pasaje(vueloNormal);
		//pasaje.setAgregarPasajesAlVuelo(202);
		this.setPasajesAlVuelo(vueloNormal, 202);
		
		assertFalse(vueloNormal.getPuedeVenderse());
	}
	
	//Punto 6
	@Test
	public void vueloCon400MilPesosGeneradoPorLasVentas(){
		Empresa.empresaUnica().cambiarCriterio(new CriterioLaxa());
		PoliticaDePrecio politicaPrecio = new PoliticaEstricta(2000);
		vueloNormal.setPoliticaDePrecio(politicaPrecio);
		for(int i = 0; i < 200; i++){
			Venta venta = new Venta(vueloNormal, new Pasaje(vueloNormal), new Pasajero(39146980 + i));
		}
		
		assertEquals(400000, vueloNormal.getImporteTotalGeneradoPorVentas(),0.11);
	}
	
	//Punto 7
	@Test
	public void pesoDeUnAvion20000PesoPasajeros1800Nafta28000Equipamiento300(){
		avionN23.setPeso(20000);
		avionN23.setConsumo(25);
		Pasaje pasajes = new Pasaje(vueloNormal);
		//pasajes.setAgregarPasajesAlVuelo(200);
		this.setPasajesAlVuelo(vueloNormal, 200);
		vueloNormal.setDistanciaDelVueloKM(1800);
		
		assertEquals(80300, vueloNormal.getPesoMaximo(),0.1);
	}
	
	@Test
	public void pesoMaximoDeUnVueloDeCargaAvion20000Carga21Pesonas10kgEquipamiento300EquipamientoCarga700Nafta1500(){
		Empresa.empresaUnica().setPesoMaximoCarga(10);
		avionN23.setPeso(20000);
		avionN23.setConsumo(20);
		VueloDeCarga vueloDeCarga = new VueloDeCarga(avionN23);
		vueloDeCarga.setDistanciaDelVueloKM(1500);
		this.setPasajesAlVuelo(vueloDeCarga, 21);
		
		assertEquals(52700, vueloDeCarga.getPesoMaximo(),0.1);
	}
	
}
