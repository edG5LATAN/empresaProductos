package com.bodega.bodega.domain.dto.vendedor;

import com.bodega.bodega.domain.model.Vendedor;

public record DtoVendedorMostrar(
       Long id,
       String nombre,
       String telefono,
       String direccion

) {
    public DtoVendedorMostrar(Vendedor vendedor){
        this(vendedor.getIdVendedor(), vendedor.getNombre(), vendedor.getTelefono(), vendedor.getDireccion());
    }
}
