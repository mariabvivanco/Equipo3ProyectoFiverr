package com.example.Equipo3ProyectoFiverr.entities;


import com.example.Equipo3ProyectoFiverr.TipoEmpresa;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Empleadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @Enumerated//(EnumType.ORDINAL)
    private TipoEmpresa tipo;

    @Enumerated//(EnumType.ORDINAL)
    private TipoEmpresa pais;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public Empleadores() {
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

    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    public TipoEmpresa getPais() {
        return pais;
    }

    public void setPais(TipoEmpresa pais) {
        this.pais = pais;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}



