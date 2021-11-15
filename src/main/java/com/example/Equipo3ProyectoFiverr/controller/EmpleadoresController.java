package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Empleadores;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoresController {

    private final Logger log = LoggerFactory.getLogger(EmpleadoresController.class);

    private EmpleadoresRepository empleadoresRepository;
    private TrabajosRepository trabajosRepository;

    public EmpleadoresController(EmpleadoresRepository empleadoresRepository, TrabajosRepository trabajosRepository) {
        this.empleadoresRepository = empleadoresRepository;
        this.trabajosRepository = trabajosRepository;
    }

    /**
     * Buscar todos los empleadores en Base de Datos
     */
    @CrossOrigin
    @GetMapping("/api/empleadores")
    public List<Empleadores> findAll() {
        return empleadoresRepository.findAll();
    }

    /**
     * Buscar categorías por  id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/empleadores/{id}")
    public ResponseEntity<Empleadores> findById(@PathVariable Long id) {
        Optional<Empleadores> empleadoresOpt = empleadoresRepository.findById(id);
        if (empleadoresOpt.isPresent()) {
            return ResponseEntity.ok(empleadoresOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
