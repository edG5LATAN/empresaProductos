package com.bodega.bodega.domain.dto.producto;

import com.bodega.bodega.domain.Enumerated.Tipo;
import com.bodega.bodega.domain.model.Producto;

public record DtoProductoMostrar(
        Long id,
       String nombre,
       Double precio,
       Long cantidad,
       Tipo tipo
) {
    public DtoProductoMostrar(Producto producto){
        this(producto.getIdProducto(), producto.getNombre(), producto.getPrecio(), producto.getCantidadDisponible(),producto.getTipo());
    }
}
