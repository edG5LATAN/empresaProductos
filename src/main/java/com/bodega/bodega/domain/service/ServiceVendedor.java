package com.bodega.bodega.domain.service;

import com.bodega.bodega.domain.dto.vendedor.DtoVendedor;
import com.bodega.bodega.domain.dto.vendedor.DtoVendedorMostrar;
import com.bodega.bodega.domain.model.Vendedor;
import com.bodega.bodega.domain.repository.RepositoryVendedor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ServiceVendedor {

     private final RepositoryVendedor repositoryVendedor;

    public ResponseEntity unidad(Long id) {
        var vendedor= repositoryVendedor.getReferenceById(id);
        if(vendedor!=null){
           return ResponseEntity.ok(new DtoVendedorMostrar(vendedor));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity mostrar() {
        var vendedor= repositoryVendedor.findAll();
        return ResponseEntity.ok(vendedor.stream().map(DtoVendedorMostrar::new).toList());
    }

    public ResponseEntity borrar(Long id) {
        var vendedor= repositoryVendedor.getReferenceById(id);
        if(vendedor!=null){
            repositoryVendedor.delete(vendedor);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity crear(DtoVendedor dtoVendedor, UriComponentsBuilder uriComponentsBuilder) {
        var vendedor=repositoryVendedor.save(new Vendedor(dtoVendedor));
        URI url= uriComponentsBuilder.path("/v1/vendedor/unidad/{id}").buildAndExpand(vendedor.getIdVendedor()).toUri();
        return ResponseEntity.created(url).body(new DtoVendedorMostrar(vendedor));
    }

    public ResponseEntity actualizar(DtoVendedor dtoVendedor, Long id) {
        var vendedor= repositoryVendedor.getReferenceById(id);
        if(vendedor!=null){
            vendedor.actualizar(dtoVendedor);
            return ResponseEntity.ok(new DtoVendedorMostrar(vendedor));
        }
        return ResponseEntity.notFound().build();
    }
}
