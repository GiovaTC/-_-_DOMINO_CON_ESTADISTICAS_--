package model;

import java.time.LocalDate;

public class Partida {
    private int fichasUsadas;
    private boolean ganada;
    private LocalDate fecha;

    public Partida(int fichasUsadas, boolean ganada) {
        this.fichasUsadas = fichasUsadas;
        this.ganada = ganada;
        this.fecha = LocalDate.now();
    }
}   
