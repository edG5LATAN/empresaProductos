package com.bodega.bodega.domain.dto.pulperia;

import jakarta.validation.constraints.NotNull;

public record DtoPulperia(
        @NotNull String nombre,
        @NotNull String direccion,
        @NotNull String telefono
) {
}
