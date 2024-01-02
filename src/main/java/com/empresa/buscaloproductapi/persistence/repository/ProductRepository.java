package com.empresa.buscaloproductapi.persistence.repository;

import com.empresa.buscaloproductapi.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    @Modifying
    @Query("UPDATE Product p SET p.nombre = :nombre, p.descripcion = :descripcion, p.precio = :precio, p.cantidad = :cantidad, " +
            "p.estado = :estado, p.imagenUrl = :imagen_url, " +
            "p.categoria = :cate_id, p.proveedor = :prove_id " +
            "WHERE p.id = :prod_id")
    void updateProductById(@Param("prod_id") Long id,
                           @Param("nombre") String nombre,
                           @Param("descripcion") String descripcion,
                           @Param("precio") Double precio,
                           @Param("cantidad") Integer cantidad,
                           @Param("estado") String estado,
                           @Param("imagen_url") String imagenUrl,
                           @Param("cate_id") Long cate_id,
                           @Param("prove_id") Long prove_id);
}
