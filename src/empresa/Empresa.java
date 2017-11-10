package empresa;

import java.util.ArrayList;
import java.util.List;

import criterioDeVentaPasajes.Criterio;
import criterioDeVentaPasajes.CriterioAmenazaTerrorista;
import vuelos.Vuelo;

public class Empresa {
	private static Criterio criterioDeVuelo;
	private static Empresa empresaUnica = new Empresa();
	
	private List<Vuelo> vuelos = new ArrayList<>();
	
	public static Criterio getCriterio(){
		return criterioDeVuelo;
	}
	
	public static Empresa empresaUnica(){
		return empresaUnica;
	}

	public void cambiarCriterio(Criterio criterio) {
		this.criterioDeVuelo = criterio;
	}
	
}
