package com.example.demo.repository;

import com.example.demo.domain.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumnos, Long> {
}
