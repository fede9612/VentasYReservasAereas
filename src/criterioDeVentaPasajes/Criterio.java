package criterioDeVentaPasajes;

import vuelos.Vuelo;

public abstract class Criterio {
	public abstract boolean getPuedeVenerPasajes(Vuelo vuelo);
}
