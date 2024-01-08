package com.empresa.buscaloproductapi.service.impl;

import com.empresa.buscaloproductapi.persistence.entity.Product;
import com.empresa.buscaloproductapi.persistence.repository.ProductRepository;
import com.empresa.buscaloproductapi.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IProductServiceImpl implements IProductService {

    private ProductRepository productRepo;


    public List<Product> listarProductos(){
        return productRepo.findAll();
    }

    public Product obtenerProducto(Long id){
        return productRepo.findById(id).get();
    }

    @Transactional
    public Product registrarProducto(Product producto){
        return productRepo.save(producto);
    }

    public Product modificarProducto(Product producto){
        return productRepo.save(producto);
    }

    public String eliminarProducto(Long id){
        productRepo.deleteById(id);
        return "Producto eliminado exitosamente";
    }

    public List<Product> listarProductosPorNombre(String nombre) {
        return productRepo.findByNombre(nombre);
    }

}
