package vuelos;

import avion.Avion;
import criterioDeVentaPasajes.Criterio;

public class VueloDeCarga extends Vuelo{
	
	private static int cantDeAsientosLibres = 30;
	private double pesoDeCarga;

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
		return pesoDeCarga;
	}

	public void setPesoDeCarga(double pesoDeCarga) {
		this.pesoDeCarga = pesoDeCarga;
	}

	@Override
	public double getPesoDeLosPasajeros() {
		return 0;
	}

}
