package asociacionInternacionalTransporteAereo;

public class IATA {
	
	private static IATA iata = new IATA();
	private double pesoStandarPersona = 75;
	private double pesoEquipamientoReglamentario = 300;

	public double getPesoStandarPersona() {
		return this.pesoStandarPersona;
	}
	
	public static IATA iata(){
		return iata;
	}

	public void setPesoStandarPersona(double pesoStandarPersona) {
		this.pesoStandarPersona = pesoStandarPersona;
	}

	public double getPesoEquipamientoReglamentario() {
		return this.pesoEquipamientoReglamentario;
	}
	
	
	
}
