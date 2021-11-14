package com.example.Equipo3ProyectoFiverr.entities;


import com.example.Equipo3ProyectoFiverr.Idiomas;
import com.example.Equipo3ProyectoFiverr.Paises;

import javax.persistence.*;


@Entity
public class Trabajos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Resto de atributos

    private String nombre;
    private String descripcion;


    @ManyToOne(cascade = CascadeType.ALL)
    private Empleadores empleador;

    @ManyToOne(cascade = CascadeType.ALL)
    private Categorias categoria;

    @Column(name = "salario_min")
    private Integer salarioMin;

    @Column(name = "salario_max")
    private Integer salarioMax;

    private Boolean verificado;

    /*@Lob
    @Column(name = "image", columnDefinition="BLOB")
    private byte[] image;*/

    @Enumerated//(EnumType.ORDINAL)
    private Paises pais;

    @Enumerated//(EnumType.ORDINAL)
    private Idiomas idiomas;

    public Trabajos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleadores getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleadores empleador) {
        this.empleador = empleador;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Integer getSalarioMin() {
        return salarioMin;
    }

    public void setSalarioMin(Integer salarioMin) {
        this.salarioMin = salarioMin;
    }

    public Integer getSalarioMax() {
        return salarioMax;
    }

    public void setSalarioMax(Integer salarioMax) {
        this.salarioMax = salarioMax;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public Idiomas getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idiomas idiomas) {
        this.idiomas = idiomas;
    }
}
