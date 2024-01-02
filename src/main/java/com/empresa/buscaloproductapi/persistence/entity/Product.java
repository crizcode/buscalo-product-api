package com.empresa.buscaloproductapi.persistence.entity;

import com.empresa.buscaloproductapi.util.Estado;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private  int cantidad;
    private String imagenUrl;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category categoria;

    @ManyToOne
    @JoinColumn(name = "prove_id")
    private Supplier proveedor;

    @Enumerated(EnumType.STRING)
    private Estado estado;

}
