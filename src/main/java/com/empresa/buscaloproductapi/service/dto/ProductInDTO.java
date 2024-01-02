package com.empresa.buscaloproductapi.service.dto;

import com.empresa.buscaloproductapi.persistence.entity.Category;
import com.empresa.buscaloproductapi.persistence.entity.Supplier;
import lombok.Data;

import javax.persistence.*;

@Data
public class ProductInDTO {
    private String nombre;
    private String descripcion;
    private double precio;
    private  int cantidad;
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category categoria;

    @ManyToOne
    @JoinColumn(name = "prove_id")
    private Supplier proveedor;

}