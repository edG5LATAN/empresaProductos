package com.bodega.bodega.domain.repository;

import com.bodega.bodega.domain.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVendedor extends JpaRepository<Vendedor,Long> {
}
