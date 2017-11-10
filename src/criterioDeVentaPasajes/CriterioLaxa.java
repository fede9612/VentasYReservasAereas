package criterioDeVentaPasajes;

import vuelos.Vuelo;

public class CriterioLaxa extends Criterio{

	@Override
	public boolean getPuedeVenderPasajes(Vuelo vuelo) {
		return (vuelo.getCantDeAsientosLibres() + 10) >= 1;
	}

}
