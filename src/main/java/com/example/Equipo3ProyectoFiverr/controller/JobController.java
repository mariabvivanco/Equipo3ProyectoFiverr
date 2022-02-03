package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.dto.JobDto;
import com.example.Equipo3ProyectoFiverr.entities.Category;
import com.example.Equipo3ProyectoFiverr.entities.Employer;
import com.example.Equipo3ProyectoFiverr.entities.Opinion;
import com.example.Equipo3ProyectoFiverr.entities.Job;
import com.example.Equipo3ProyectoFiverr.repositories.CategoryRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmployerRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionRepository;
import com.example.Equipo3ProyectoFiverr.repositories.JobRepository;
import com.example.Equipo3ProyectoFiverr.service.ConvertDto;
import com.example.Equipo3ProyectoFiverr.service.ConvertDtoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/job")
public class JobController {

    private final Logger log = LoggerFactory.getLogger(JobController.class);

    private JobRepository jobRepository;
    private CategoryRepository categoryRepository;
    private EmployerRepository employerRepository;
    private OpinionRepository opinionRepository;

    public JobController(JobRepository jobRepository, CategoryRepository categoryRepository,
                         EmployerRepository employerRepository, OpinionRepository opinionRepository) {
        this.jobRepository = jobRepository;
        this.categoryRepository = categoryRepository;
        this.employerRepository = employerRepository;
        this.opinionRepository = opinionRepository;
    }

    /**
     * Search all jobs in the database
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/alldata")
    public ResponseEntity<List<Job>> findAllData() {

       return  ResponseEntity.ok(jobRepository.findAll());
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all")
    public ResponseEntity<List<JobDto>> findAll() {

        ConvertDto convertDto = new ConvertDtoImpl();
        List<JobDto> jobDtoList = convertDto.convertAllJob(opinionRepository.findAll(),jobRepository.findAll());
        return ResponseEntity.ok(jobDtoList);

    }
    /**
     * Search job for id
     * Request
     * Response
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<JobDto> findById(@PathVariable Long id) {

        if (jobRepository.findById(id).isPresent()){
            ConvertDto convertDto = new ConvertDtoImpl();
            List<Job> jobs = new ArrayList<>();
            jobs.add(jobRepository.findById(id).get());
            List<JobDto> jobDtoList = convertDto.convertAllJob(opinionRepository.findAll(),jobs);
            return ResponseEntity.ok(jobDtoList.get(0));
        }
            return ResponseEntity.notFound().build();

    }



    /**
     * Create a new job in the database
     * @param job
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/api/trabajos")
    public ResponseEntity<Job> create(@RequestBody Job job) {
        if(job.getId() != null) {
            log.warn("Intentando crear un trabajo con id");
            return ResponseEntity.badRequest().build();
        }

        for (Category category: job.getCategories()) {
            if((category.getId()== null)||!categoryRepository.existsByName(category.getName())){
                log.info("Creando categoria inexistente: " + category.getName());
                categoryRepository.save(category);
            }
        }

        for (Employer employer: job.getEmployers()) {
            if((employer.getId()== null)||!categoryRepository.existsByName(employer.getName())){
                log.info("Creando empleador inexistente: " + employer.getName());
                employerRepository.save(employer);
            }
        }

        return ResponseEntity.ok(jobRepository.save(job));
    }

    /**
     * Update a  job in the database
     *
     * @param job
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/api/trabajos")
    public ResponseEntity<Job> update(@RequestBody Job job) {
        if ((job.getId() == null)|| (!jobRepository.existsById(job.getId()))) {
            log.warn("Intentando actualizar un trabajo inexistente");
            return ResponseEntity.badRequest().build();
        }
        for (Category category: job.getCategories()) {
            if((category.getId()== null)||!categoryRepository.existsByName(category.getName())){
                log.info("Creando categoria inexistente: " + category.getName());
                categoryRepository.save(category);
            }
        }

        for (Employer employer: job.getEmployers()) {
            if((employer.getId()== null)||!categoryRepository.existsByName(employer.getName())){
                log.info("Creando empleador inexistente: " + employer.getName());
                employerRepository.save(employer);
            }
        }

        return ResponseEntity.ok(jobRepository.save(job));
    }

    /**
     * Deleting a job in the database
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN'")
    @DeleteMapping("/api/trabajos/{id}")
    public ResponseEntity<Job> delete(@PathVariable Long id) {

        if (!jobRepository.existsById(id)) {
            log.warn("Intentando eliminar un trabajo inexistente");
            return ResponseEntity.notFound().build();
        }

        Job job = jobRepository.findById(id).get();
        job.setEmployers(null);
        job.setCategories(null);
        jobRepository.save(job);
        jobRepository.deleteById(id);
        log.info("Eliminando trabajo: " + id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Remove all jobs from the database
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/all")
    public ResponseEntity<Job> deleteAll() {

        for (Job job : jobRepository.findAll()) {
            job.setEmployers(null);
            job.setCategories(null);
            jobRepository.save(job);
        }
        jobRepository.deleteAll();
        log.info("Eliminando todos los trabajos");
        return ResponseEntity.noContent().build();
    }




}
