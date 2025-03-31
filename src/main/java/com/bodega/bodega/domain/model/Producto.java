package com.bodega.bodega.domain.model;


import com.bodega.bodega.domain.dto.producto.DtoProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombre;
    private Double precio;
    private Long cantidadDisponible;

    public Producto(DtoProducto dtoProducto) {
        this.nombre= dtoProducto.nombre();
        this.precio= dtoProducto.precio();
        this.cantidadDisponible= dtoProducto.cantidad();
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
    }
}
