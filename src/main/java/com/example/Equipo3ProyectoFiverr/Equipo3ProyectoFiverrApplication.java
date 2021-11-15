package com.example.Equipo3ProyectoFiverr;

import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Empleadores;
import com.example.Equipo3ProyectoFiverr.entities.Opiniones;
import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionesRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Calendar;

@SpringBootApplication
public class Equipo3ProyectoFiverrApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Equipo3ProyectoFiverrApplication.class, args);
		CategoriasRepository categoriasRepository = context.getBean(CategoriasRepository.class);
		EmpleadoresRepository empleadoresReository = context.getBean(EmpleadoresRepository.class);
		OpinionesRepository opinionesRepository = context.getBean(OpinionesRepository.class);
		TrabajosRepository trabajosRepository = context.getBean(TrabajosRepository.class);

		LocalDate fecha1 = LocalDate.of(2020, Calendar.DECEMBER, 23);
		LocalDate fecha2 = LocalDate.of(2021, Calendar.FEBRUARY, 7);
		LocalDate fecha3 = LocalDate.of(2021, Calendar.MARCH, 28);
		LocalDate fecha4 = LocalDate.of(2020, Calendar.JULY, 1);
		LocalDate fecha5 = LocalDate.of(2021, Calendar.OCTOBER, 19);
		LocalDate fecha6 = LocalDate.of(2021, Calendar.AUGUST, 22);



		Categorias categoria1 = new Categorias(null,"Desarrollo Software",
				"Sirve para desarrollar Software" );
		//categoria1.setTrabajos();
		Categorias categoria2 = new Categorias(null,"Diseño Sitios Web",
				"Sirve para diseñar sitios" );
		Categorias categoria3 = new Categorias(null,"Diseño Interiores",
				"Sirve para diseñar hogares" );

		categoriasRepository.save(categoria1);
		categoriasRepository.save(categoria2);
		categoriasRepository.save(categoria3);

		Empleadores empleador1 = new Empleadores(null,"EmpDis","Empresa de Diseño",
				TipoEmpresa.Particular,Paises.España);
		Empleadores empleador2= new Empleadores(null,"EmpSof","Empresa de Software",
				TipoEmpresa.Particular,Paises.España);
		empleadoresReository.save(empleador1);
		empleadoresReository.save(empleador2);

		Trabajos trabajo1 = new Trabajos(null,"Desarrollar API", "",12000,
				15000,Boolean.TRUE,Paises.Cuba,Idiomas.Español);
		trabajo1.setFecha(fecha2);
		Trabajos trabajo2 = new Trabajos(null,"Desarrollar API", "",12000,
				15000,Boolean.TRUE,Paises.EstadosUnidos,Idiomas.Ingles);
		trabajo2.setFecha(fecha3);
		Trabajos trabajo3 = new Trabajos(null,"Diseñar terraza","",15000,
				20000,Boolean.FALSE,Paises.EstadosUnidos,Idiomas.Ingles);
		trabajo3.setFecha(fecha4);


		trabajosRepository.save(trabajo1);
		trabajosRepository.save(trabajo2);
		trabajosRepository.save(trabajo3);



		Opiniones opinion1 = new Opiniones(null,4,"esta mas o menos",trabajo1,empleador2);
		Opiniones opinion2 = new Opiniones(null,5,"esta muy bien",trabajo1,empleador2);
		Opiniones opinion3 = new Opiniones(null,4,"esta por ahi",trabajo1,empleador2);
		Opiniones opinion4 = new Opiniones(null,4,"esta  bien",trabajo1,empleador2);
		Opiniones opinion5 = new Opiniones(null,5,"esta muy bien",trabajo1,empleador2);
		Opiniones opinion6 = new Opiniones(null,4,"esta muy bien",trabajo1,empleador2);
		Opiniones opinion7 = new Opiniones(null,4,"esta  bien",trabajo3,empleador1);
		opinionesRepository.save(opinion1);
		opinionesRepository.save(opinion2);
		opinionesRepository.save(opinion3);
		opinionesRepository.save(opinion4);
		opinionesRepository.save(opinion5);
		opinionesRepository.save(opinion6);
		opinionesRepository.save(opinion7);


	}

}
