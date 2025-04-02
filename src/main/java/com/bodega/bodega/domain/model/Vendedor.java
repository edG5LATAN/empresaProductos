package com.bodega.bodega.domain.model;


import com.bodega.bodega.domain.dto.vendedor.DtoVendedor;
import jakarta.persistence.*;

@Entity
@Table(name = "vendedor")
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

    public Vendedor() {
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
    //getter and setter
    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
