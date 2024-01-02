package com.empresa.buscaloproductapi.mapper;

import com.empresa.buscaloproductapi.persistence.entity.Product;
import com.empresa.buscaloproductapi.service.dto.ProductInDTO;
import com.empresa.buscaloproductapi.util.Estado;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ProductInDTOToProduct implements IMapper<ProductInDTO, Product> {
    @Override
    public Product map(ProductInDTO in) {
        Product product = new Product();
        product.setNombre(in.getNombre());
        product.setDescripcion(in.getDescripcion());
        product.setPrecio(in.getPrecio());
        product.setCantidad(in.getCantidad());
        product.setImagenUrl(in.getImagenUrl());
        product.setFechaCreacion(LocalDateTime.now());
        product.setCategoria(in.getCategoria());
        product.setProveedor(in.getProveedor());
        product.setEstado(Estado.Activo);
        return product;
    }
}
