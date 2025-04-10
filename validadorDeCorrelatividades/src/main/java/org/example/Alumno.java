package org.example;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    // Agrega una materia aprobada a la lista de materiasAprobadas del alumno.
    public void agregarMateriaAprobada(Materia materia) {
        materiasAprobadas.add(materia);
    }

    // Verifica si el alumno tiene aprobado la materia.
    public boolean estaAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }

}
