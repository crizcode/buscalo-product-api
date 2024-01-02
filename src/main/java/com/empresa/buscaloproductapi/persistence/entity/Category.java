package com.empresa.buscaloproductapi.persistence.entity;

import com.empresa.buscaloproductapi.util.Estado;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categoria")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}

