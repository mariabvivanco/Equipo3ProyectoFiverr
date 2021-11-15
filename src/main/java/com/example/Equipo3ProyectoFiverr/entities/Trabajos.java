package com.example.Equipo3ProyectoFiverr.entities;


import com.example.Equipo3ProyectoFiverr.Idiomas;
import com.example.Equipo3ProyectoFiverr.Paises;
import javassist.bytecode.ByteArray;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "trabajos")
public class Trabajos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Resto de atributos

    private String nombre;
    private String descripcion;
    private String image;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="trabajos_empleadores",
            joinColumns={
                    @JoinColumn(name="id_trabajo", referencedColumnName = "id")
            },
            inverseJoinColumns= {
                    @JoinColumn(name = "id_empleador", referencedColumnName = "id") })
    //@JsonManagedReference
    private Set<Empleadores> empleadores = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="trabajos_categorias",
            joinColumns={
                    @JoinColumn(name="id_trabajo", referencedColumnName = "id")
            },
            inverseJoinColumns= {
                    @JoinColumn(name = "id_categoria", referencedColumnName = "id") })
    //@JsonManagedReference
    private Set<Categorias> categorias = new HashSet<>();


    @Column(name = "salario_min")
    private Integer salarioMin;

    @Column(name = "salario_max")
    private Integer salarioMax;

    private Boolean verificado;

    private LocalDate fecha;

    /*@Lob
    @Column
    ByteArray image = new ByteArray();*/

    /*@Lob
    @Column(name = "image")
    private byte[] image;*/

    @Enumerated//(EnumType.ORDINAL)
    private Paises pais;

    @Enumerated//(EnumType.ORDINAL)
    private Idiomas idiomas;




    public Trabajos() {
    }

    public Trabajos(Long id, String nombre, String descripcion, Integer salarioMin, Integer salarioMax, Boolean verificado,
                    Paises pais, Idiomas idiomas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
                this.salarioMin = salarioMin;
        this.salarioMax = salarioMax;
        this.verificado = verificado;
        this.pais = pais;
        this.idiomas = idiomas;

    }

    public Trabajos(Long id, String nombre, String descripcion, Set<Empleadores> empleadores,
                    Set<Categorias> categorias, Integer salarioMin, Integer salarioMax, Boolean verificado,
                    LocalDate fecha, Paises pais, Idiomas idiomas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.empleadores = empleadores;
        this.categorias = categorias;
        this.salarioMin = salarioMin;
        this.salarioMax = salarioMax;
        this.verificado = verificado;
        this.fecha = fecha;
        this.pais = pais;
        this.idiomas = idiomas;
    }

    public Trabajos(Long id, String nombre, String descripcion, String image, Set<Empleadores> empleadores,
                    Set<Categorias> categorias, Integer salarioMin, Integer salarioMax, Boolean verificado,
                    LocalDate fecha, Paises pais, Idiomas idiomas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.image = image;
        this.empleadores = empleadores;
        this.categorias = categorias;
        this.salarioMin = salarioMin;
        this.salarioMax = salarioMax;
        this.verificado = verificado;
        this.fecha = fecha;
        this.pais = pais;
        this.idiomas = idiomas;
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


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Empleadores> getEmpleadores() {
        return empleadores;
    }

    public void setEmpleadores(Set<Empleadores> empleadores) {
        this.empleadores = empleadores;
    }

    public Set<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categorias> categorias) {
        this.categorias = categorias;
    }
}
