package com.bodega.bodega.domain.model;


import com.bodega.bodega.domain.dto.pulperia.DtoPulperia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pulperia")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pulperia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPulperia;
    private String nombre;
    private String direccion;
    private String telefono;

    public Pulperia(DtoPulperia dtoPulperia) {
        this.nombre= dtoPulperia.nombre();
        this.direccion= dtoPulperia.direccion();
        this.telefono= dtoPulperia.telefono();
    }

    public void actualizar(DtoPulperia dtoPulperia) {
        if(dtoPulperia.nombre()!=null){
            this.nombre= dtoPulperia.nombre();
        }
        if(dtoPulperia.direccion()!=null){
            this.direccion= dtoPulperia.direccion();
        }
        if(dtoPulperia.telefono()!=null){
            this.telefono= dtoPulperia.telefono();
        }
    }
}
