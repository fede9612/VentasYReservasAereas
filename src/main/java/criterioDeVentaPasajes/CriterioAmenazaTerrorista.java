package criterioDeVentaPasajes;

import exeption.ExeptionDeAmenazaTerrorista;
import vuelos.Vuelo;

public class CriterioAmenazaTerrorista extends Criterio{

	@Override
	public boolean getPuedeVenderPasajes(Vuelo vuelo) {
		throw new ExeptionDeAmenazaTerrorista("No se puede vender por amenaza terrorista");
	}

}
