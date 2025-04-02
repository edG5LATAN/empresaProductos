package com.bodega.bodega.domain.dto.vendedor;

import com.bodega.bodega.domain.model.Vendedor;
import jakarta.validation.constraints.NotNull;

public record DtoVendedor(
        @NotNull String nombre,
        @NotNull String telefono,
        @NotNull String direccion
) {
}
