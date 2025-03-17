package com.example.demo.domain;

import com.example.demo.dto.DTOAlumnoRegistro;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity(name = "alumnos")
@Table(name = "alumnos")
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    @Column(name = "nombre_alumno")
    private String nombre;

    public Alumnos() {
    }

    public Alumnos(String nombre) {
        this.nombre = nombre;
    }

    public Alumnos(@Valid DTOAlumnoRegistro alumnoRegistro){
        this(alumnoRegistro.nombre());
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
