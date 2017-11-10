package avion;

public class Avion {

	private int cantAsientos;
	private double alturaDeCabina;
	private double peso;

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
	
}
