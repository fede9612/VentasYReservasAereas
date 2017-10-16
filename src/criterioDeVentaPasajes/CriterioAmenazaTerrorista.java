package criterioDeVentaPasajes;

import vuelos.Vuelo;

public class CriterioAmenazaTerrorista extends Criterio{

	@Override
	public boolean getPuedeVenerPasajes(Vuelo vuelo) {
		return false;
	}

}
