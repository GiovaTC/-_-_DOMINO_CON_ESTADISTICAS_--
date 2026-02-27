package model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int id;
    private String nombre;
    private List<Ficha> fichas = new ArrayList<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }
}
