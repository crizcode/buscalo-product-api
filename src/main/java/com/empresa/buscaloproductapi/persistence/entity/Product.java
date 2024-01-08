package com.empresa.buscaloproductapi.persistence.entity;

import com.empresa.buscaloproductapi.util.Estado;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "producto")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private long id;

    @NotBlank(message = "{NotBlank.producto.nombre}")
    @Column(name = "prod_nombre")
    private String nombre;

    @NotBlank(message = "{NotBlank.producto.descripcion}")
    @Length(min = 5, max = 50, message = "{Length.producto.descripcion}")
    @Column(name = "prod_dsc")
    private String descripcion;

    @NotNull(message = "{NotEmpty.producto.precio}")
    @Min(value = 1, message = "{Min.producto.precio}")
    @Column(name = "prod_prec")
    private BigDecimal precio;

    @NotNull(message = "{NotNull.producto.cantidad}")
    @Min(value = 1, message = "{Min.producto.cantidad}")
    @Column(name = "prod_cant")
    private long cantidad;

    @NotEmpty(message = "{NotEmpty.producto.imgurl}")
    @Column(name = "prod_image")
    private String imagenUrl;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @ApiModelProperty(hidden = true)
    private Date fechaCreacion;


    @ManyToOne
    @JoinColumn(name = "cate_id", nullable = false)
    @NotNull(message = "{NotNull.producto.categoria}")
    private Category categoria;

    @ManyToOne
    @JoinColumn(name = "prove_id", nullable = false)
    @NotNull(message = "{NotNull.producto.proveedor}")
    private Supplier proveedor;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'ACTIVO'")
    private Estado estado;

}
