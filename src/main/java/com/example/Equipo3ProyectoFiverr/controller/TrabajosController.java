package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.dto.TrabajosDto;
import com.example.Equipo3ProyectoFiverr.entities.Opiniones;
import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionesRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TrabajosController {

    private final Logger log = LoggerFactory.getLogger(TrabajosController.class);

    private TrabajosRepository trabajosRepository;
    private CategoriasRepository categoriasRepository;
    private EmpleadoresRepository empleadoresRepository;
    private OpinionesRepository opinionesRepository;

    public TrabajosController(TrabajosRepository trabajosRepository, CategoriasRepository categoriasRepository,
                              EmpleadoresRepository empleadoresRepository, OpinionesRepository opinionesRepository) {
        this.trabajosRepository = trabajosRepository;
        this.categoriasRepository = categoriasRepository;
        this.empleadoresRepository = empleadoresRepository;
        this.opinionesRepository = opinionesRepository;
    }

    /**
     * Buscar todas los trabajos en base de datos
     */
    @CrossOrigin
    @GetMapping("/api/trabajostodos")
    public List<Trabajos> findAll() {
        return trabajosRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/trabajos")
    public List<TrabajosDto> findAllT() {

        List<Trabajos> trabajos = trabajosRepository.findAll();
        List<Opiniones> opiniones = opinionesRepository.findAll();
        List<TrabajosDto> trabajosDto =new ArrayList<TrabajosDto>();
        TrabajosDto trabajoDto = new TrabajosDto();

        for(int i=0; i<trabajos.size();i++){
            trabajoDto = new TrabajosDto(trabajos.get(i).getId(),trabajos.get(i).getNombre(),trabajos.get(i).getImage(),
                    trabajos.get(i).getDescripcion(), trabajos.get(i).getCategorias(),trabajos.get(i).getEmpleadores(),
                    trabajos.get(i).getFecha(),trabajos.get(i).getPais(),trabajos.get(i).getIdiomas());

            int sumaOpiniones=0, cantOpiniones=0;
            double promedio=0;
            for (int j=0;j<opiniones.size();j++){
                if ((opiniones.get(j).getTrabajo())==(trabajos.get(i))){
                    cantOpiniones++;
                    sumaOpiniones=sumaOpiniones+opiniones.get(j).getCalificacion();
                }
            }
            if (cantOpiniones>0){
                trabajoDto.setOpiniones(cantOpiniones);
                promedio = sumaOpiniones/cantOpiniones;
                trabajoDto.setPromedio(promedio);
            }
            trabajosDto.add(trabajoDto);

        }


        return trabajosDto;
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
