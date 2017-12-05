package criterioDeVentaPasajes;

import vuelos.Vuelo;

public abstract class Criterio {
	public abstract boolean getPuedeVenderPasajes(Vuelo vuelo);
	
	public static Criterio AMENAZA = new CriterioAmenazaTerrorista();
}
