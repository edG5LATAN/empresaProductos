package com.bodega.bodega.domain.model;


import com.bodega.bodega.domain.dto.pulperia.DtoPulperia;
import jakarta.persistence.*;
@Entity
@Table(name = "pulperia")
public class Pulperia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPulperia;
    private String nombre;
    private String direccion;
    private String telefono;

    //constructor
    public Pulperia() {
    }

    public Pulperia(DtoPulperia dtoPulperia) {
        this.nombre= dtoPulperia.nombre();
        this.direccion= dtoPulperia.direccion();
        this.telefono= dtoPulperia.telefono();
    }

    public void actualizar(DtoPulperia dtoPulperia) {
        if(dtoPulperia.nombre()!=null){
            this.nombre= dtoPulperia.nombre();
        }
        if(dtoPulperia.direccion()!=null){
            this.direccion= dtoPulperia.direccion();
        }
        if(dtoPulperia.telefono()!=null){
            this.telefono= dtoPulperia.telefono();
        }
    }

    //getter and setter

    public Long getIdPulperia() {
        return idPulperia;
    }

    public void setIdPulperia(Long idPulperia) {
        this.idPulperia = idPulperia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
