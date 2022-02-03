package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Employer;
import com.example.Equipo3ProyectoFiverr.entities.Job;
import com.example.Equipo3ProyectoFiverr.repositories.EmployerRepository;
import com.example.Equipo3ProyectoFiverr.repositories.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private final Logger log = LoggerFactory.getLogger(EmployerController.class);

    private EmployerRepository employerRepository;
    private JobRepository jobRepository;

    public EmployerController(EmployerRepository employerRepository, JobRepository jobRepository) {
        this.employerRepository = employerRepository;
        this.jobRepository = jobRepository;
    }

    /**
     * Find all employers in the database
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Employer>> findAll() {

        return ResponseEntity.ok(employerRepository.findAll());
    }

    /**
     * Find employer for id  id
     * Request
     * Response
     */

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Employer> findById(@PathVariable Long id) {
        Optional<Employer> employerOpt = employerRepository.findById(id);
        if (employerOpt.isPresent()) {
            return ResponseEntity.ok(employerOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Create one employer in the database
     * @param employer
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<Employer> create(@RequestBody Employer employer) {
        if (employer.getId() != null) {
            log.warn("Intentando crear un empleado con id");
            return ResponseEntity.badRequest().build();
        }
        if (employerRepository.existsByName(employer.getName())) {
                log.warn("Intentando crear un empleador ya existente");
                return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(employerRepository.save(employer));
    }

    /**
     * Update one  employer in the database
     * @param employer
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Employer> update(@RequestBody Employer employer) {
        if ((employer.getId() == null)||(!employerRepository.existsById(employer.getId())) ){
            log.warn("Intentando actualizar un empleador sin dar el id");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(employerRepository.save(employer));
    }

    /**
     * Delete one employer in the database
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Employer> delete(@PathVariable Long id) {

        if (!employerRepository.existsById(id)) {
            log.warn("Intentando eliminar un empleador inexistente");
            return ResponseEntity.notFound().build();
        }
        for (Job job : jobRepository.findAll()) {
                job.removeEmployer(employerRepository.findById(id).get(), false);
                jobRepository.save(job);
        }
        employerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Delete all employers in the database
     * @return
     */

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/all")
    public ResponseEntity<Employer> deleteAll() {
        log.info("Petición REST para eliminar todos los empleadores");

            for (Job job: jobRepository.findAll()) {
                job.setEmployers(null);
                jobRepository.save(job);
            }

        jobRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
