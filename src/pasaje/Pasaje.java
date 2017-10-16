package pasaje;

import vuelos.Vuelo;

public class Pasaje {
	
	private Vuelo vuelo;
	
	public Pasaje(Vuelo vuelo){
		this.vuelo = vuelo;
		this.setAgregarPasajeAlVuelo();
	}

	public Vuelo getVuelo() {
		return vuelo;
	}
	
	private void setAgregarPasajeAlVuelo(){
		this.getVuelo().setCantDePasajesVendidos();
	}
	
	//Este metodo lo uso solo para los test
	public void setAgregarPasajesAlVuelo(int n){
		for(int i=1;i<n;i++){
			this.getVuelo().setCantDePasajesVendidos();
		}
	}
}
