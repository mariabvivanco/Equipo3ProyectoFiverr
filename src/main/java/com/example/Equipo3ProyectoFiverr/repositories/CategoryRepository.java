package com.example.Equipo3ProyectoFiverr.repositories;


import com.example.Equipo3ProyectoFiverr.entities.Category;
import com.example.Equipo3ProyectoFiverr.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CrudRepository<Category,Long> {
    Category findByName(String name);
    boolean existsByName(String name);
}
