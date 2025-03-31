package com.bodega.bodega.controller;


import com.bodega.bodega.domain.dto.vendedor.DtoVendedor;
import com.bodega.bodega.domain.service.ServiceVendedor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/v1/vendedor")
@RequiredArgsConstructor
public class ControllerVendedor {

    private final ServiceVendedor serviceVendedor;

    @GetMapping("/mostrar")
    public ResponseEntity mostrar(){
        return serviceVendedor.mostrar();
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return serviceVendedor.unidad(id);
    }

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid DtoVendedor dtoVendedor, UriComponentsBuilder uriComponentsBuilder){
        return serviceVendedor.crear(dtoVendedor,uriComponentsBuilder);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity actualizar(@RequestBody DtoVendedor dtoVendedor,@RequestParam Long id){
        return serviceVendedor.actualizar(dtoVendedor,id);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrar(@RequestParam Long id){
        return serviceVendedor.borrar(id);
    }


}
