package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Opinion;
import com.example.Equipo3ProyectoFiverr.repositories.CategoryRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionRepository;
import com.example.Equipo3ProyectoFiverr.repositories.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opinion")
public class OpinionController {

    private final Logger log = LoggerFactory.getLogger(OpinionController.class);

    private OpinionRepository opinionRepository;
    private JobRepository jobRepository;
    private CategoryRepository categoryRepository;

    public OpinionController(OpinionRepository opinionRepository, JobRepository jobRepository, CategoryRepository categoryRepository) {
        this.opinionRepository = opinionRepository;
        this.jobRepository = jobRepository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * Find all opinions in the database
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Opinion>> findAll() {

        return ResponseEntity.ok(opinionRepository.findAll());
    }

    /**
     * Find all opinions for id
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Opinion> findById(@PathVariable Long id) {
        Optional<Opinion> opinionsOpt =opinionRepository.findById(id);
        if (opinionsOpt.isPresent()) {
            return ResponseEntity.ok(opinionsOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Create new opinion in the database
     *
     * @param opinion
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/new")
    public ResponseEntity<Opinion> create(@RequestBody Opinion opinion) {
        if (opinion.getId() != null) {
            log.warn("Intentando crear una opinion con id");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(opinionRepository.save(opinion));
    }

    /**
     *Update an opinion in the database
     * @param opinion
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/update")
    public ResponseEntity<Opinion> update(@RequestBody Opinion opinion) {
        if (opinion.getId() == null) {
            log.warn("Intentando actualizar una opinión sin dar el id");
            return ResponseEntity.badRequest().build();
        }
        if (!opinionRepository.existsById(opinion.getId())) {
            log.warn("Intentando actualizar una opinión con id inexistente");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opinionRepository.save(opinion));
    }

    /**
     * Delete an opinion in the database
     * @param id
     * @return
     */

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Opinion> delete(@PathVariable Long id) {

        if (!opinionRepository.existsById(id)) {
            log.warn("Intentando eliminar una opinión inexistente");
            return ResponseEntity.notFound().build();
        }

        opinionRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Delete all opinions in the database
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/all")
    public ResponseEntity<Opinion> deleteAll() {
        log.info("Petición REST para eliminar todas las opiniones");
        opinionRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
