package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CategoriasController {

    private final Logger log = LoggerFactory.getLogger(CategoriasController.class);

    private CategoriasRepository categoriasRepository;
    private TrabajosRepository trabajosRepository;

    public CategoriasController(CategoriasRepository categoriasRepository, TrabajosRepository trabajosRepository) {
        this.categoriasRepository = categoriasRepository;
        this.trabajosRepository = trabajosRepository;
    }


    /**
     * Buscar todas las categorías en Base de Datos
     */
    @CrossOrigin
    @GetMapping("/api/categorias")
    public List<Categorias> findAll() {
        return categoriasRepository.findAll();
    }

    /**
     * Buscar categorías por  id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/categorias/{id}")
    public ResponseEntity<Categorias> findById(@PathVariable Long id) {
        Optional<Categorias> categoriaOpt = categoriasRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            return ResponseEntity.ok(categoriaOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
