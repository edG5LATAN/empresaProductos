package com.bodega.bodega.domain.dto.producto;

import com.bodega.bodega.domain.Enumerated.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoProducto(
        @NotNull String nombre,
        @NotNull Double precio,
        @NotNull Long cantidad,
        @NotNull Tipo tipo
) {
}
