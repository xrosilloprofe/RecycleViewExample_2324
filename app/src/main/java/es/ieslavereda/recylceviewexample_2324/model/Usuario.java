package es.ieslavereda.recylceviewexample_2324.model;

import java.io.Serializable;
import java.util.Comparator;

public class Usuario implements Serializable {

    public static final Comparator<Usuario> SORT_BY_NAME
            = (usuario1, usuario2) -> {
        if(usuario1.apellidos.compareToIgnoreCase(usuario2.apellidos)==0)
            return usuario1.nombre.compareToIgnoreCase(usuario2.nombre);
        return usuario1.apellidos.compareToIgnoreCase(usuario2.apellidos);
    };

    public static final Comparator<Usuario> SORT_BY_JOB =
            (usuario1,usuario2) -> usuario1.profesion.getNombre().
                    compareToIgnoreCase(usuario2.profesion.getNombre());
    private String nombre;
    private String apellidos;
    private Profesion profesion;

    public Usuario(String nombre, String apellidos, Profesion profesion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Profesion getProfesion() {
        return profesion;
    }
}
