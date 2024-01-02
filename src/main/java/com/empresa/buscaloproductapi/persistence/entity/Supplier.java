package com.empresa.buscaloproductapi.persistence.entity;

import com.empresa.buscaloproductapi.util.Estado;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "proveedor")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prove_id")
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
