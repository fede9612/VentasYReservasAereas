package criterioDeVentaPasajes;

import vuelos.Vuelo;

public class CriterioPorcentaje extends Criterio{

	@Override
	public boolean getPuedeVenderPasajes(Vuelo vuelo) {
		return (vuelo.getCantDeAsientosLibres() * 1.01) >= 1;
	}

}
