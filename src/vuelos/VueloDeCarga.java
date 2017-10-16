package vuelos;

import avion.Avion;
import criterioDeVentaPasajes.Criterio;

public class VueloDeCarga extends Vuelo{
	
	private static int cantDeAsientosLibres = 30;

	public VueloDeCarga(Avion avion,Criterio criterio){
		super(avion, criterio);
	}

	public int getCantDeAsientosLibres() {
		return this.cantDeAsientosLibres - this.getCantDeAsientosOcupados();
	}

	public int getCantDeAsientosOcupados() {
		return this.getCantDePasajesVendidos();
	}

}
