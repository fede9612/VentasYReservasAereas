package vuelos;

import asociacionInternacionalTransporteAereo.IATA;
import avion.Avion;
import empresa.Empresa;

public class VueloDeCarga extends Vuelo{
	
	private static int cantDeAsientosLibres = 30;

	public VueloDeCarga(Avion avion){
		super(avion);
	}

	public int getCantDeAsientosLibres() {
		return this.cantDeAsientosLibres - this.getCantDeAsientosOcupados();
	}

	public int getCantDeAsientosOcupados() {
		return this.getCantDePasajesVendidos();
	}

	@Override
	public double getPesoDeLaCarga() {
		return this.getPesoDeCarga() + this.get700KgDeEquipamientoSeguridad();
	}

	private double get700KgDeEquipamientoSeguridad() {
		return 700;
	}

	public double getPesoDeCarga() {
		return this.getCantDeAsientosOcupados() * Empresa.empresaUnica().getPesoMaximoDeCargaPorPersona();
	}


	@Override
	public double getPesoDeLosPasajeros() {
		return this.getCantDeAsientosOcupados() * IATA.iata().getPesoStandarPersona();
	}

	@Override
	public int getCantAsientos() {
		return this.cantDeAsientosLibres;
	}

}
