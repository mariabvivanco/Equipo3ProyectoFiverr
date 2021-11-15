package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class TrabajosController {

    private final Logger log = LoggerFactory.getLogger(TrabajosController.class);

    private TrabajosRepository trabajosRepository;
    private CategoriasRepository categoriasRepository;
    private EmpleadoresRepository empleadoresRepository;

    public TrabajosController(TrabajosRepository trabajosRepository, CategoriasRepository categoriasRepository,
                              EmpleadoresRepository empleadoresRepository) {
        this.trabajosRepository = trabajosRepository;
        this.categoriasRepository = categoriasRepository;
        this.empleadoresRepository = empleadoresRepository;
    }


    /**
     * Buscar todas los trabajos en base de datos
     */
    @CrossOrigin
    @GetMapping("/api/trabajos")
    public List<Trabajos> findAll() {
        return trabajosRepository.findAll();
    }

    /**
     * Buscar ofertas según id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/trabajos/{id}")
    public ResponseEntity<Trabajos> findById(@PathVariable Long id) {
        Optional<Trabajos> trabajosOpt = trabajosRepository.findById(id);
        if (trabajosOpt.isPresent()) {
            return ResponseEntity.ok(trabajosOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
