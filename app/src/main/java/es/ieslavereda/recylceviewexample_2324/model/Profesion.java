package es.ieslavereda.recylceviewexample_2324.model;

import java.io.Serializable;

public class Profesion implements Serializable {
    private int image;
    private String nombre;

    public Profesion(String nombre,int image) {
        this.image = image;
        this.nombre = nombre;
    }

    public int getImage() {
        return image;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
