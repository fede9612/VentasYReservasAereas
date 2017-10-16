package criterioDeVentaPasajes;

import vuelos.Vuelo;

public class CriterioSegura extends Criterio{

	@Override
	public boolean getPuedeVenerPasajes(Vuelo vuelo) {
		return vuelo.getCantDeAsientosLibres() >= 3;
	}

}
