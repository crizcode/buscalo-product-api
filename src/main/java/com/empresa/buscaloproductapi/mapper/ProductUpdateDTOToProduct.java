package com.empresa.buscaloproductapi.mapper;

import com.empresa.buscaloproductapi.persistence.entity.Product;
import com.empresa.buscaloproductapi.service.dto.ProductInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductUpdateDTOToProduct implements IMapper<ProductInDTO, Product> {
    @Override
    public Product map(ProductInDTO in) {
        Product product = new Product();
        product.setNombre(in.getNombre());
        product.setDescripcion(in.getDescripcion());
        product.setPrecio(in.getPrecio());
        product.setCantidad(in.getCantidad());
        product.setImagenUrl(in.getImagenUrl());
        product.setCategoria(in.getCategoria());
        product.setProveedor(in.getProveedor());
        product.setEstado(in.getCategoria().getEstado());
        return product;
    }
}
