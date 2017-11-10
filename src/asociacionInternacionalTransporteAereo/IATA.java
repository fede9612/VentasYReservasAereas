package asociacionInternacionalTransporteAereo;

public class IATA {
	
	private static IATA iata = new IATA();
	private static double pesoStandarPersona = 75;
	private static double pesoEquipamientoReglamentario = 300;

	public static double getPesoStandarPersona() {
		return pesoStandarPersona;
	}
	
	public static IATA iata(){
		return iata;
	}

	public static void setPesoStandarPersona(double pesoStandarPersona) {
		IATA.pesoStandarPersona = pesoStandarPersona;
	}

	public static double getPesoEquipamientoReglamentario() {
		return pesoEquipamientoReglamentario;
	}
	
	
	
}
