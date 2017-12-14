package avion;

import org.uqbar.commons.utils.Observable;

@Observable
public class Avion {

	private int cantAsientos;
	private double alturaDeCabina;
	private double peso;
	private double consumo;
	private String nombre;

	public Avion(int asientos, double alturaCabina){
		this.cantAsientos = asientos;
		this.alturaDeCabina = alturaCabina;
	}
	
	public int getCantAsientos() {
		return cantAsientos;
	}
	
	public double getAlturaDeCabina() {
		return alturaDeCabina;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getConsumoNafta() {
		return this.consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public String getNombre() { return nombre; }

	public void setNombre(String nombre) { this.nombre = nombre; }
	
}
