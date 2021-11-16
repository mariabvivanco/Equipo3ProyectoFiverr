package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
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

    /**
     * Crear categoria nueva en la bbdd.
     *
     * @param categoria
     * @return
     */
    @CrossOrigin
    @PostMapping("/api/categorias")
    public ResponseEntity<Categorias> create(@RequestBody Categorias categoria) {
        if (categoria.getId() != null) {
            log.warn("Intentando crear una categoría con id");
            return ResponseEntity.badRequest().build();
        }
        List<Categorias> categorias = categoriasRepository.findAll();
        for (Categorias categoriaEnRepo : categorias) {
            if (categoriaEnRepo.getNombre().equals(categoria.getNombre())) {
                log.warn("Intentando crear una categoria ya existente");
                return ResponseEntity.badRequest().build();
            }
        }

       Categorias result = categoriasRepository.save(categoria);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una tecnologia en la bbdd.
     *
     * @param categoria
     * @return
     */
    @CrossOrigin
    @PutMapping("/api/categorias")
    public ResponseEntity<Categorias> update(@RequestBody Categorias categoria) {
        if (categoria.getId() == null) {
            log.warn("Intentando actualizar una categoria sin dar el id");
            return ResponseEntity.badRequest().build();
        }
        if (!categoriasRepository.existsById(categoria.getId())) {
            log.warn("Intentando actualizar una categoria con id inexistente");
            return ResponseEntity.notFound().build();
        }

        Categorias result = categoriasRepository.save(categoria);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar una categoria de la bbdd.
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @DeleteMapping("/api/categorias/{id}")
    public ResponseEntity<Categorias> delete(@PathVariable Long id) {

        if (!categoriasRepository.existsById(id)) {
            log.warn("Intentando eliminar una categoria inexistente");
            return ResponseEntity.notFound().build();
        }

        Optional<Categorias> categoriaOpt = categoriasRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            Categorias categoria = categoriaOpt.get();
            System.out.println(categoria );
            System.out.println(categoria.getTrabajos());
            Set<Trabajos> trabajos = categoria.getTrabajos();
            for (Trabajos trabajo : trabajos) {
                trabajo.removeCategoria(categoria, false);
                trabajosRepository.save(trabajo);
            }
        }

        categoriasRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las categorias de la base de datos
     * @return
     */
    @CrossOrigin
    @DeleteMapping("/api/categorias")
    public ResponseEntity<Categorias> deleteAll() {
        log.info("Petición REST para eliminar todas las categorias");
        List<Categorias> categorias = categoriasRepository.findAll();

        for (Categorias categoria: categorias) {
            Set<Trabajos> trabajos = categoria.getTrabajos();
            for (Trabajos trabajo: trabajos) {
                trabajo.removeCategoria(categoria, false);
                trabajosRepository.save(trabajo);
            }
        }

        categoriasRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}