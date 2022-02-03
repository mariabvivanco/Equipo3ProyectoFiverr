package com.example.Equipo3ProyectoFiverr.entities;


import com.example.Equipo3ProyectoFiverr.Countries;
import com.example.Equipo3ProyectoFiverr.CompanyType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated//(EnumType.ORDINAL)
    private CompanyType type;

    @Enumerated//(EnumType.ORDINAL)
    private Countries country;

    private String image;

    @ManyToMany( fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Job> jobs= new HashSet<>();


    public Employer() {
    }

    public Employer(Long id, String name, String description, CompanyType type, Countries country, String image, Set<Job> jobs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.country = country;
        this.image = image;
        this.jobs = jobs;
    }

    public Employer(Long id, String name, String description, CompanyType type, Countries country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}



