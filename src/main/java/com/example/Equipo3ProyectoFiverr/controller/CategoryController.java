package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.dto.JobDto;
import com.example.Equipo3ProyectoFiverr.entities.Category;
import com.example.Equipo3ProyectoFiverr.entities.Job;
import com.example.Equipo3ProyectoFiverr.repositories.CategoryRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionRepository;
import com.example.Equipo3ProyectoFiverr.repositories.JobRepository;
import com.example.Equipo3ProyectoFiverr.service.ConvertDto;
import com.example.Equipo3ProyectoFiverr.service.ConvertDtoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private final Logger log = LoggerFactory.getLogger(CategoryController.class);

    private CategoryRepository categoryRepository;
    private JobRepository jobRepository;
    private OpinionRepository opinionRepository;

    public CategoryController(CategoryRepository categoryRepository, JobRepository jobRepository,

                              OpinionRepository opinionRepository) {
        this.categoryRepository = categoryRepository;
        this.jobRepository = jobRepository;
        this.opinionRepository = opinionRepository;
    }

    /**
     * Find all the categories in the database
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Category>> findAll() {

        return ResponseEntity.ok(categoryRepository.findAll());
    }

    /**
     * Find category for  id
     * Request
     * Response
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<List<JobDto>> findById(@PathVariable Long id) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            ConvertDto convertDto = new ConvertDtoImpl();
            List<JobDto> jobDtoList = convertDto.convertJobForCategory(opinionRepository.findAll(),categoryOpt.get().getJobs());
            return ResponseEntity.ok(jobDtoList);
        }
        return ResponseEntity.notFound().build();
    }


    /**
     * Create one category in the database
     * @param category
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/new")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        if ((category.getId()!= null)||(categoryRepository.existsByName(category.getName()))) {
            log.warn("Intentando crear una existente ");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    /**
     * Update one category in the database
     * @param category
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        if ((category.getId() == null)||(!categoryRepository.existsById(category.getId()))) {
            log.warn("Intentando actualizar una categoria inexistente");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    /**
     * Delete one category from the database
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {

        if (!categoryRepository.existsById(id)) {
            log.warn("Intentando eliminar una categoria inexistente");
            return ResponseEntity.notFound().build();
        }
        for (Job job :categoryRepository.getById(id).getJobs()) {
            job.removeCategory(categoryRepository.getById(id),false);
            jobRepository.save(job);
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Remove all categories from the database
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/all")
    public ResponseEntity<Category> deleteAll() {
        log.info("Petición REST para eliminar todas las categorías");
        for (Job job: jobRepository.findAll()) {
            job.setCategories(null);
            jobRepository.save(job);
        }
        categoryRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}