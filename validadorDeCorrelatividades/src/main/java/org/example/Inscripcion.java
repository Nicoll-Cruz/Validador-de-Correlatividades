package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.Alumno;
import org.example.Materia;

@Getter
@Setter

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }


    // Inicia la verificacion de las materias correlativas de la Materia
    public boolean aprobada() {
        return verificarCorrelativas(this.materia);
    }

    // Verifica recursivamente para verificar las correlativas de cada materia.
    private boolean verificarCorrelativas(Materia materiaCorrelativa) {
        return materiaCorrelativa.getCorrelativas().stream()
                .allMatch(correlativa ->
                        this.alumno.estaAprobada(correlativa) && verificarCorrelativas(correlativa));
    }
}