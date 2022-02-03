package com.example.Equipo3ProyectoFiverr.repositories;


import com.example.Equipo3ProyectoFiverr.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
