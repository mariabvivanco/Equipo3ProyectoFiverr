package com.example.Equipo3ProyectoFiverr;

import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionesRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Equipo3ProyectoFiverrApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Equipo3ProyectoFiverrApplication.class, args);
		CategoriasRepository categoriasRepository = context.getBean(CategoriasRepository.class);
		EmpleadoresRepository empleadoresReository = context.getBean(EmpleadoresRepository.class);
		OpinionesRepository opinionesRepository = context.getBean(OpinionesRepository.class);
		TrabajosRepository trabajosRepository = context.getBean(TrabajosRepository.class);
	}

}
