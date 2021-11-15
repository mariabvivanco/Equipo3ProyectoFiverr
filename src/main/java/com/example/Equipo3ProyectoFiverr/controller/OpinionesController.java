package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Opiniones;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionesRepository;
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
public class OpinionesController {

    private final Logger log = LoggerFactory.getLogger(OpinionesController.class);

    private OpinionesRepository opinionesRepository;
    private TrabajosRepository trabajosRepository;
    private CategoriasRepository categoriasRepository;

    public OpinionesController(OpinionesRepository opinionesRepository, TrabajosRepository trabajosRepository,
                               CategoriasRepository categoriasRepository) {
        this.opinionesRepository = opinionesRepository;
        this.trabajosRepository = trabajosRepository;
        this.categoriasRepository = categoriasRepository;
    }

    /**
     * Buscar todas las opiniones en Base de Datos
     */
    @CrossOrigin
    @GetMapping("/api/opiniones")
    public List<Opiniones> findAll() {
        return opinionesRepository.findAll();
    }

    /**
     * Buscar opiniones por  id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/opiniones/{id}")
    public ResponseEntity<Opiniones> findById(@PathVariable Long id) {
        Optional<Opiniones> opinionesOpt =opinionesRepository.findById(id);
        if (opinionesOpt.isPresent()) {
            return ResponseEntity.ok(opinionesOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
