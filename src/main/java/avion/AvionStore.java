package avion;

import java.util.ArrayList;

public class AvionStore {

    private static AvionStore store = new AvionStore();
    private ArrayList<Avion> aviones = new ArrayList<>();

    public static AvionStore avionStore(){
        return store;
    }

    private AvionStore(){}


    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(Avion aviones) {
        this.aviones.add(aviones);
    }
}
