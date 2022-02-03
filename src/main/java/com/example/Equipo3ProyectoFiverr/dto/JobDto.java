package com.example.Equipo3ProyectoFiverr.dto;

import com.example.Equipo3ProyectoFiverr.Languages;
import com.example.Equipo3ProyectoFiverr.Countries;
import com.example.Equipo3ProyectoFiverr.entities.Category;
import com.example.Equipo3ProyectoFiverr.entities.Employer;

import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class JobDto {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String description;
    private Integer opinions;
    private Double ave;
    private Double price;
    private Set<Category> categories = new HashSet<>();
    private Set<Employer> employers = new HashSet<>();
    private LocalDate date;

    public JobDto() {
    }

    public JobDto(Long id, String name, String image, String description,
                  Set<Category> categories, Set<Employer> employers, LocalDate date,  Double price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.opinions = opinions;
        this.ave = ave;
        this.price = price;
        this.categories = categories;
        this.employers = employers;
        this.date = date;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOpinions() {
        return opinions;
    }

    public void setOpinions(Integer opinions) {
        this.opinions = opinions;
    }

    public Double getAve() {
        return ave;
    }

    public void setAve(Double ave) {
        this.ave = ave;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(Set<Employer> employers) {
        this.employers = employers;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
