package com.bodega.bodega.controller;

import com.bodega.bodega.domain.dto.pulperia.DtoPulperia;
import com.bodega.bodega.domain.service.ServicePulperia;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pulperia")
public class ControllerPulperia {

    @Autowired
    private ServicePulperia servicePulperia;

    @GetMapping("/mostrar")
    public ResponseEntity mostrar(){
        return servicePulperia.mostrar();
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return servicePulperia.unidad(id);
    }

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid DtoPulperia dtoPulperia){
        return servicePulperia.crear(dtoPulperia);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        return servicePulperia.borrar(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity actualizar(@RequestBody DtoPulperia dtoPulperia, Long id){
        return servicePulperia.actualizar(dtoPulperia,id);
    }

}
