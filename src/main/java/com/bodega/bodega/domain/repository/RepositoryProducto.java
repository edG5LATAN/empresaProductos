package com.bodega.bodega.domain.repository;

import com.bodega.bodega.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProducto extends JpaRepository<Producto,Long> {
}
