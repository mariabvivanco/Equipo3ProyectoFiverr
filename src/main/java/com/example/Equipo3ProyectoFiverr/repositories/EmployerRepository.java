package com.example.Equipo3ProyectoFiverr.repositories;



import com.example.Equipo3ProyectoFiverr.entities.Employer;
import com.example.Equipo3ProyectoFiverr.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long>, CrudRepository<Employer,Long> {
    Employer findByName(String name);
    boolean existsByName(String name);

}
