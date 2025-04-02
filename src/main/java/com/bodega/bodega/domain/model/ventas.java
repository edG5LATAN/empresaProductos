package com.bodega.bodega.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity
@Table(name = "ventas")
public class ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    @OneToOne
    private Pulperia pulperia;
    @OneToMany
    private List<Producto> productos;
    @OneToOne
    private Vendedor vendedor;
    private Double total;
    private LocalDate fechaCompra;

}
