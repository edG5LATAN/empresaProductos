package com.bodega.bodega.domain.dto.producto;

import com.bodega.bodega.domain.model.Producto;
import jakarta.validation.constraints.NotNull;

public record DtoProductoMostrar(
        Long id,
       String nombre,
       Double precio,
       Long cantidad
) {
    public DtoProductoMostrar(Producto producto){
        this(producto.getIdProducto(), producto.getNombre(), producto.getPrecio(), producto.getCantidadDisponible());
    }
}
