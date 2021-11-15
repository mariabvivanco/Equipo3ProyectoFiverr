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

    /**
     * Crear oferta nueva en la bbdd.
     *
     * @param oferta
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/api/ofertas")
    public ResponseEntity<Oferta> create(@RequestBody Oferta oferta) {
        if(oferta.getId() != null) {
            log.warn("Intentando crear una oferta con id");
            return ResponseEntity.badRequest().build();
        }

        Set<Tecnologia> tecnologias = oferta.getTecnologias();

        for (Tecnologia tecnologia : tecnologias) {
            if(tecnologia.getId() == null) {
                log.info("Creando tecnología inexistente: " + tecnologia.getNombre());
                tecnologiaRepository.save(tecnologia);
            }
        }

        Oferta ofertaAGuardar = new Oferta(
                null,
                oferta.getNombre(),
                oferta.getEmpresa(),
                oferta.getDescripcion(),
                oferta.getNumeroVacantes(),
                oferta.getLocalidad(),
                oferta.getSalarioMinimo(),
                oferta.getSalarioMaximo(),
                oferta.getModalidad(),
                oferta.getAnyosExperiencia(),
                oferta.getTitulacion(),
                oferta.getCategoria(),
                oferta.getTipoContrato(),
                oferta.getFechaPublicacion(),
                oferta.getEstadoProceso(),
                oferta.getUrlImagen()
        );

        for (Tecnologia tecnologia : oferta.getTecnologias()) {
            ofertaAGuardar.addTecnologia(tecnologia);
        }

        Oferta result = ofertaRepository.save(ofertaAGuardar);
        return ResponseEntity.ok(result);
    }


     * Actualizar una oferta en la bbdd.
     *
     * @param oferta
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/api/ofertas")
    public ResponseEntity<Oferta> update(@RequestBody Oferta oferta) {
        if (oferta.getId() == null) {
            log.warn("Intentando actualizar una oferta inexistente");
            return ResponseEntity.badRequest().build();
        }
        if (!ofertaRepository.existsById(oferta.getId())) {
            log.warn("Intentando actualizar una oferta inexistente");
            return ResponseEntity.notFound().build();
        }

        Set<Tecnologia> tecnologias = oferta.getTecnologias();

        for (Tecnologia tecnologia : tecnologias) {
            if(tecnologia.getId() == null) {
                log.info("Creando tecnología inexistente: " + tecnologia.getNombre());
                tecnologiaRepository.save(tecnologia);
            }
        }

        Optional<Oferta> ofertaOpt = ofertaRepository.findById(oferta.getId());
        if (ofertaOpt.isPresent()) {
            Oferta ofertaAntigua = ofertaOpt.get();
            desvincularTecnologias(ofertaAntigua);
        }

        Oferta ofertaAGuardar = new Oferta(
                oferta.getId(),
                oferta.getNombre(),
                oferta.getEmpresa(),
                oferta.getDescripcion(),
                oferta.getNumeroVacantes(),
                oferta.getLocalidad(),
                oferta.getSalarioMinimo(),
                oferta.getSalarioMaximo(),
                oferta.getModalidad(),
                oferta.getAnyosExperiencia(),
                oferta.getTitulacion(),
                oferta.getCategoria(),
                oferta.getTipoContrato(),
                oferta.getFechaPublicacion(),
                oferta.getEstadoProceso(),
                oferta.getUrlImagen()
        );

        for (Tecnologia tecnologia : oferta.getTecnologias()) {
            ofertaAGuardar.addTecnologia(tecnologia);
        }

        Oferta result = ofertaRepository.save(ofertaAGuardar);
        log.info("Actualizando oferta: " + ofertaAGuardar.getId());
        return ResponseEntity.ok(result);
    }


     * Eliminar una oferta de la bbdd.
     * @param id
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/api/ofertas/{id}")
    public ResponseEntity<Oferta> delete(@PathVariable Long id) {

        if (!ofertaRepository.existsById(id)) {
            log.warn("Intentando eliminar una oferta inexistente");
            return ResponseEntity.notFound().build();
        }

        Optional<Oferta> ofertaOpt = ofertaRepository.findById(id);
        if (ofertaOpt.isPresent()) {
            Oferta ofertaAntigua = ofertaOpt.get();
            desvincularTecnologias(ofertaAntigua);
        }

        ofertaRepository.deleteById(id);
        log.info("Eliminando oferta: " + id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las ofertas de la bbdd.
     *
     * @return

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/api/ofertas")
    public ResponseEntity<Oferta> deleteAll() {

        List<Oferta> ofertas = ofertaRepository.findAll();
        for (Oferta oferta : ofertas) {
            desvincularTecnologias(oferta);
        }

        List<Tecnologia> tecnologias = tecnologiaRepository.findAll();

        ofertaRepository.deleteAll();
        log.info("Eliminando todas las ofertas");
        return ResponseEntity.noContent().build();
    }

    /**
     * Método que desvincula cada oferta de las tecnologias que están ligadas a ellas.
     *
     * @param oferta

    private void desvincularTecnologias(Oferta oferta) {
        Set<Tecnologia> tecnologiasABorrar = new HashSet<>(oferta.getTecnologias());
        for (Tecnologia tecnologia : tecnologiasABorrar) {
            oferta.removeTecnologia(tecnologia, true);
        }
    }
    */
}
