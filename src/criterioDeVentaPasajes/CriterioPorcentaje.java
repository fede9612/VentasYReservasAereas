package criterioDeVentaPasajes;

import vuelos.Vuelo;

public class CriterioPorcentaje extends Criterio{

	@Override
	public boolean getPuedeVenderPasajes(Vuelo vuelo) {
		return (vuelo.getCantAsientos() * 1.01) >= 1;
	}
	
	//Este metodo es para mostrarte que anda en el test
	//public double getCantDePasajesQueSePuedenVender(Vuelo vuelo){
		//return (vuelo.getCantAsientos() * 1.01);
	//}
}
