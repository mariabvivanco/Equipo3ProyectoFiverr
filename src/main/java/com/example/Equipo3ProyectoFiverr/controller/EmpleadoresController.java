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


    /**
     * Crear tecnologia nueva en la bbdd.
     *
     * @param tecnologia
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/api/tecnologias")
    public ResponseEntity<Tecnologia> create(@RequestBody Tecnologia tecnologia) {
        if (tecnologia.getId() != null) {
            log.warn("Intentando crear una tecnologia con id");
            return ResponseEntity.badRequest().build();
        }
        List<Tecnologia> tecnologias = tecnologiaRepository.findAll();
        for (Tecnologia tecnologiaEnRepo : tecnologias) {
            if (tecnologiaEnRepo.equals(tecnologia)) {
                log.warn("Intentando crear una tecnologia ya existente");
                return ResponseEntity.badRequest().build();
            }
        }


        Tecnologia result = tecnologiaRepository.save(tecnologia);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una tecnologia en la bbdd.
     *
     * @param tecnologia
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/api/tecnologias")
    public ResponseEntity<Tecnologia> update(@RequestBody Tecnologia tecnologia) {
        if (tecnologia.getId() == null) {
            log.warn("Intentando actualizar una tecnología inexistente");
            return ResponseEntity.badRequest().build();
        }
        if (!tecnologiaRepository.existsById(tecnologia.getId())) {
            log.warn("Intentando actualizar una tecnología inexistente");
            return ResponseEntity.notFound().build();
        }

        Tecnologia result = tecnologiaRepository.save(tecnologia);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar una tecnologia de la bbdd.
     *
     * @param id
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/api/tecnologias/{id}")
    public ResponseEntity<Tecnologia> delete(@PathVariable Long id) {

        if (!tecnologiaRepository.existsById(id)) {
            log.warn("Intentando eliminar una tecnologia inexistente");
            return ResponseEntity.notFound().build();
        }

        Optional<Tecnologia> tecnologiaOpt = tecnologiaRepository.findById(id);
        if (tecnologiaOpt.isPresent()) {
            Tecnologia tecnologia = tecnologiaOpt.get();
            System.out.println(tecnologia );
            System.out.println(tecnologia.getOfertas());
            Set<Oferta> ofertas = tecnologia.getOfertas();
            for (Oferta oferta : ofertas) {
                oferta.removeTecnologia(tecnologia, false);
                ofertaRepository.save(oferta);
            }
        }

        tecnologiaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las tecnologias de la bbdd.
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/api/tecnologias")
    public ResponseEntity<Tecnologia> deleteAll() {
        log.info("Petición REST para eliminar todas las tecnologias");
        List<Tecnologia> tecnologias = tecnologiaRepository.findAll();

        for (Tecnologia tecnologia : tecnologias) {
            Set<Oferta> ofertas = tecnologia.getOfertas();
            for (Oferta oferta : ofertas) {
                oferta.removeTecnologia(tecnologia, false);
                ofertaRepository.save(oferta);
            }
        }

        tecnologiaRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
    */
}
