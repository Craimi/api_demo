package com.example.demo.controller;

import com.example.demo.domain.Alumnos;
import com.example.demo.dto.DTOAlumnoRegistro;
import com.example.demo.repository.AlumnoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://apidemo-production.up.railway.app")
@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public ResponseEntity<?> getAlumnos(){
        List<Alumnos> alumnos = alumnoRepository.findAll();

        return ResponseEntity.ok(alumnos);
    }

    @PostMapping
    public ResponseEntity<?> postAlumnos(@RequestBody @Valid DTOAlumnoRegistro alumnoRegistro, UriComponentsBuilder uri){
        Alumnos alumnos = alumnoRepository.save(new Alumnos(alumnoRegistro));

        URI url = uri.path("/alumno/{id}").buildAndExpand(alumnos.getMatricula()).toUri();

        return ResponseEntity.created(url).build();
    }
}
