package vuelos;

import java.util.ArrayList;

public class CiudadStore {

    private static CiudadStore store = new CiudadStore();
    private ArrayList<Ciudad> ciudades = new ArrayList<>();

    public static CiudadStore store(){
        return store;
    }

    private CiudadStore(){}

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudad ciudades) {
        this.ciudades.add(ciudades);
    }
}
