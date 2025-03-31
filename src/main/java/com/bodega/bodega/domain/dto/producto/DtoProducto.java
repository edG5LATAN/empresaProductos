package com.bodega.bodega.domain.dto.producto;

import jakarta.validation.constraints.NotNull;

public record DtoProducto(
        @NotNull String nombre,
        @NotNull Double precio,
        @NotNull Long cantidad
) {
}
