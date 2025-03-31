package com.bodega.bodega.domain.dto.pulperia;

import com.bodega.bodega.domain.model.Pulperia;

public record DtoPulperiaMostrar (
        Long id,
        String nombre,
        String direccion,
        String telefono
){
    public DtoPulperiaMostrar(Pulperia pulperia){
        this(pulperia.getIdPulperia(), pulperia.getNombre(), pulperia.getDireccion(), pulperia.getTelefono());
    }
}
