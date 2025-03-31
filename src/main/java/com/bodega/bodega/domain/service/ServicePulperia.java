package com.bodega.bodega.domain.service;


import com.bodega.bodega.domain.dto.pulperia.DtoPulperia;
import com.bodega.bodega.domain.dto.pulperia.DtoPulperiaMostrar;
import com.bodega.bodega.domain.model.Pulperia;
import com.bodega.bodega.domain.repository.RepositoryPulperia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicePulperia {

    private final RepositoryPulperia repositoryPulperia;
    public ResponseEntity mostrar() {
        var pulperias= repositoryPulperia.findAll();
        return ResponseEntity.ok(pulperias.stream().map(DtoPulperiaMostrar::new).toList());
    }

    public ResponseEntity crear(DtoPulperia dtoPulperia) {
        var pulperia= repositoryPulperia.save(new Pulperia(dtoPulperia));
        return ResponseEntity.ok(new DtoPulperiaMostrar(pulperia));
    }

    public ResponseEntity borrar(Long id) {
        var pulperia= repositoryPulperia.getReferenceById(id);
        if(pulperia!=null){
            repositoryPulperia.delete(pulperia);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity unidad(Long id) {
        var pulperia= repositoryPulperia.getReferenceById(id);
        if(pulperia!=null){
            return ResponseEntity.ok(new DtoPulperiaMostrar(pulperia));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity actualizar(DtoPulperia dtoPulperia, Long id) {
       var pulperia= repositoryPulperia.getReferenceById(id);
       if(pulperia!=null){
           pulperia.actualizar(dtoPulperia);
           return ResponseEntity.ok(new DtoPulperiaMostrar(pulperia));
       }
       return ResponseEntity.notFound().build();
    }
}
