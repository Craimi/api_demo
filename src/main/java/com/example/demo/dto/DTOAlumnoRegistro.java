package com.example.demo.dto;
import jakarta.validation.constraints.NotBlank;

public record DTOAlumnoRegistro(
    @NotBlank(message = "Nombre es obligatorio")
    String nombre
) {
}
