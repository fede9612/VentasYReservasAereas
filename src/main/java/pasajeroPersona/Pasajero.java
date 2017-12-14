package pasajeroPersona;

import org.uqbar.commons.utils.Observable;

@Observable
public class Pasajero {

	private String dni;
	private String nomApe;

	public Pasajero(){

	}

	public Pasajero(String dni){
		this.dni = dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public String getNomApe() {
		return nomApe;
	}

	public void setNomApe(String nomApe) {
		this.nomApe = nomApe;
	}
}
