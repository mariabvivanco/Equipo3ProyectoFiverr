package com.example.Equipo3ProyectoFiverr.entities;


import com.example.Equipo3ProyectoFiverr.Languages;
import com.example.Equipo3ProyectoFiverr.Countries;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Employer> employers = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Category> categories = new HashSet<>();

    private Double price;
    private Boolean verified;
    private LocalDate date;

    @Enumerated//(EnumType.ORDINAL)
    private Countries country;

    @Enumerated//(EnumType.ORDINAL)
    private Languages language;



    public Job() {
    }

    public Job(Long id, String name, String description, String image, Set<Employer> employers, Set<Category> categories,
               Double price, Boolean verified, LocalDate date, Countries country, Languages language) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.employers = employers;
        this.categories = categories;
        this.price = price;
        this.verified = verified;
        this.date = date;
        this.country = country;
        this.language = language;
    }

    public Job(Long id, String name, String description, Double price, Boolean verified, Countries country, Languages language) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.country = country;
        this.language = language;
        this.verified = verified;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(Set<Employer> employers) {
        this.employers = employers;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.getJobs().add(this);
    }

    public void removeCategory(Category category, boolean categoryExists){
        categories.remove(category);
        if (categoryExists) {
            category.getJobs().remove(this);
        }
    }

    public void addEmployer(Employer employer){
        employers.add(employer);
        employer.getJobs().add(this);
    }

    public void removeEmployer(Employer employer, boolean employerExists){
        employers.remove(employer);
        if (employerExists) {
            employer.getJobs().remove(this);
        }
    }
}
