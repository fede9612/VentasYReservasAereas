package empresa;


import criterioDeVentaPasajes.Criterio;

public class Empresa {
	private Criterio criterioDeVuelo;
	private static Empresa empresaUnica = new Empresa();
	private double pesoMaximoCarga;
	
	public Criterio getCriterio(){
		return this.criterioDeVuelo;
	}
	
	public static Empresa empresaUnica(){
		return empresaUnica;
	}

	public void cambiarCriterio(Criterio criterio) {
		this.criterioDeVuelo = criterio;
	}

	public double getPesoMaximoDeCargaPorPersona() {
		return this.pesoMaximoCarga;
	}

	public void setPesoMaximoCarga(double pesoMaximoCarga) {
		this.pesoMaximoCarga = pesoMaximoCarga;
	}
	
}
