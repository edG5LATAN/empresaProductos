package com.bodega.bodega.controller;


import com.bodega.bodega.domain.dto.producto.DtoProducto;
import com.bodega.bodega.domain.service.ServiceProducto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("v1/producto")
@RequiredArgsConstructor
public class ControllerProducto {

    private final ServiceProducto serviceProducto;

    @GetMapping("/mostrar")
    public ResponseEntity mostrarProductos(){
        return serviceProducto.mostrar();
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity unidad(@RequestParam Long id){
        return serviceProducto.unidad(id);
    }

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid DtoProducto dtoProducto, UriComponentsBuilder uriComponentsBuilder){
        return serviceProducto.crear(dtoProducto,uriComponentsBuilder);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrar(@RequestParam Long id){
        return serviceProducto.borrar(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity actualizar(@RequestBody DtoProducto dtoProducto,@RequestParam Long id){
        return serviceProducto.actualizar(dtoProducto,id);
    }

}
