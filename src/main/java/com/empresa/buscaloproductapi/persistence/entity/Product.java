package com.empresa.buscaloproductapi.persistence.entity;

import com.empresa.buscaloproductapi.util.Estado;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "producto")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private long id;

    @NotEmpty(message = "{NotEmpty.producto.nombre}")
    private String nombre;

    @NotEmpty(message = "{NotEmpty.producto.descripcion}")
    private String descripcion;

    @NotNull(message = "{NotNull.producto.precio}")
    private double precio;

    @NotNull(message = "{NotNull.producto.cantidad}")
    @Min(value = 1, message = "{Min.producto.cantidad}")
    private  int cantidad;

    @NotEmpty(message = "{NotEmpty.producto.imgurl}")
    private String imagenUrl;

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "cate_id", nullable = false)
    @NotNull(message = "{NotNull.producto.categoria}")
    private Category categoria;

    @ManyToOne
    @JoinColumn(name = "prove_id", nullable = false)
    @NotNull(message = "{NotNull.producto.proveedor}")
    private Supplier proveedor;

    @Enumerated(EnumType.STRING)
    private Estado estado;

}
