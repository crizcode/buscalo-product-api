package com.empresa.buscaloproductapi.service;

import com.empresa.buscaloproductapi.persistence.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> listarProductos();
    public Product obtenerProducto(Long id);
    public Product registrarProducto(Product producto);
    public Product modificarProducto(Product producto);
    public String eliminarProducto(Long id);
    public List<Product> listarProductosPorNombre(String nombre);
}
