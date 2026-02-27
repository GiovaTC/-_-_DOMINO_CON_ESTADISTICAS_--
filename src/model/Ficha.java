package model;

public class Ficha {

    private int izquierda;
    private int derecha;

    public Ficha(int izquierda, int derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public boolean esDoble() {
        return izquierda == derecha;
    }

    @Override
    public String toString() {
        return "[" +  izquierda + "|" + derecha + "]";
    }
}   
