package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class InscripcionTest {
    @Test
    @DisplayName("Inscripción Aprobada por cumplimiento de Materias Correlativas")
    public void inscripcionAprobada() {
        Materia algoritmoYestructura = new Materia("Algoritmo y estructura de datos");
        Materia logicaYestructura = new Materia("Logica y estructura de discretas");

        Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programacion");
        paradigmasDeProgramacion.agregarCorrelativas(algoritmoYestructura,logicaYestructura);

        Materia disenioDeSistemas = new Materia("Diseño de Sistemas");
        disenioDeSistemas.agregarCorrelativas(paradigmasDeProgramacion);

        Alumno alumnoJuan = new Alumno( "Juan Cortez", "235332-8");
        alumnoJuan.agregarMateriaAprobada(paradigmasDeProgramacion);
        alumnoJuan.agregarMateriaAprobada(logicaYestructura);
        alumnoJuan.agregarMateriaAprobada(algoritmoYestructura);

        Inscripcion inscrpcionJuan = new Inscripcion(alumnoJuan,disenioDeSistemas);

        Assertions.assertTrue(inscrpcionJuan.aprobada());


    }
    @Test
    @DisplayName("Inscripción Rechazada por incumplimiento de Materias Correlativas")
    public void inscripcionRechazada() {
        Materia algoritmoYestructura = new Materia("Algoritmo y estructura de datos");

        Materia logicaYestructura = new Materia("Logica y estructura de discretas");

        Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programacion");
        paradigmasDeProgramacion.agregarCorrelativas(algoritmoYestructura,logicaYestructura);

        Alumno alumnoMaria = new Alumno( "Maria Gonzalez", "235367-2");
        alumnoMaria.agregarMateriaAprobada(algoritmoYestructura);

        Inscripcion inscrpcionJuan = new Inscripcion(alumnoMaria,paradigmasDeProgramacion);

        Assertions.assertFalse(inscrpcionJuan.aprobada());
    }

}