package com.bodega.bodega.domain.service;

import com.bodega.bodega.domain.dto.producto.DtoProducto;
import com.bodega.bodega.domain.dto.producto.DtoProductoMostrar;
import com.bodega.bodega.domain.model.Producto;
import com.bodega.bodega.domain.repository.RepositoryProducto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ServiceProducto {

    @Autowired
    private RepositoryProducto repositoryProducto;

    public ResponseEntity crear(DtoProducto dtoProducto, UriComponentsBuilder uriComponentsBuilder) {
        var producto=repositoryProducto.save(new Producto(dtoProducto));
        URI url= uriComponentsBuilder.path("/v1/producto/unidad/{id}").buildAndExpand(producto.getIdProducto()).toUri();
        return ResponseEntity.created(url).body(new DtoProductoMostrar(producto));
    }


    public ResponseEntity mostrar() {
        var productos= repositoryProducto.findAll();
        return ResponseEntity.ok(productos.stream().map(DtoProductoMostrar::new).toList());
    }

    public ResponseEntity borrar(Long id) {
        var producto=repositoryProducto.getReferenceById(id);
        if(producto!=null){
            repositoryProducto.delete(producto);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity actualizar(DtoProducto dtoProducto, Long id) {
        var producto = repositoryProducto.getReferenceById(id);
        if(producto!=null){
            producto.actualizar(dtoProducto);
            return ResponseEntity.ok(new DtoProductoMostrar(producto));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity unidad(Long id) {
        var producto= repositoryProducto.getReferenceById(id);
        if(producto!=null){
            return ResponseEntity.ok(new DtoProductoMostrar(producto));
        }
        return ResponseEntity.notFound().build();

    }
}
