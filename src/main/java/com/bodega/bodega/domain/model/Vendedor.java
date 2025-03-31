package com.bodega.bodega.domain.model;


import com.bodega.bodega.domain.dto.vendedor.DtoVendedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vendedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendedor;
    private String nombre;
    private String telefono;
    private String direccion;

    public Vendedor(DtoVendedor dtoVendedor) {
        this.nombre= dtoVendedor.nombre();
        this.telefono= dtoVendedor.telefono();
        this.direccion= dtoVendedor.direccion();
    }

    public void actualizar(DtoVendedor dtoVendedor) {
        if(dtoVendedor.nombre()!=null){
            this.nombre= dtoVendedor.nombre();
        }
        if(dtoVendedor.telefono()!=null){
            this.telefono= dtoVendedor.telefono();
        }
        if(dtoVendedor.direccion()!=null){
            this.direccion= dtoVendedor.direccion();
        }

    }
}
