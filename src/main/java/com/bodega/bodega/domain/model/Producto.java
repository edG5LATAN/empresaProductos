package com.bodega.bodega.domain.model;


import com.bodega.bodega.domain.Enumerated.Tipo;
import com.bodega.bodega.domain.dto.producto.DtoProducto;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombre;
    private Double precio;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private Long cantidadDisponible;

    //constructor

    public Producto() {
    }

    public Producto(DtoProducto dtoProducto) {
        this.nombre= dtoProducto.nombre();
        this.precio= dtoProducto.precio();
        this.cantidadDisponible= dtoProducto.cantidad();
        this.tipo=dtoProducto.tipo();
    }

    public void actualizar(DtoProducto dtoProducto) {
        if(dtoProducto.nombre()!=null){
            this.nombre= dtoProducto.nombre();
        }
        if(dtoProducto.precio()!=null){
            this.precio= dtoProducto.precio();
        }
        if(dtoProducto.cantidad()!=null){
            this.cantidadDisponible= dtoProducto.cantidad();
        }
        if(dtoProducto.tipo()!=null){
            this.tipo= dtoProducto.tipo();
        }
    }


    //getter and setter

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Long cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}
