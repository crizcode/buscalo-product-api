package com.empresa.buscaloproductapi.service;

import com.empresa.buscaloproductapi.mapper.ProductInDTOToProduct;
import com.empresa.buscaloproductapi.mapper.ProductUpdateDTOToProduct;
import com.empresa.buscaloproductapi.persistence.entity.Product;
import com.empresa.buscaloproductapi.persistence.repository.ProductRepository;
import com.empresa.buscaloproductapi.service.dto.ProductInDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductInDTOToProduct mapper;
    private final ProductUpdateDTOToProduct mapperupdate;

    public ProductService(ProductRepository repository, ProductInDTOToProduct mapper, ProductUpdateDTOToProduct mapperupdate){
        this.repository = repository;
        this.mapper = mapper;
        this.mapperupdate = mapperupdate;
    }

    public Product createProduct(ProductInDTO productinDTO) {
        Product product = mapper.map(productinDTO);
        return this.repository.save(product);
    }
    public List<Product> findAll(){
        return this.repository.findAll();
    }

    public Optional<Product> findById(Long id){
        return this.repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Transactional
    public void updateProduct(Long id, ProductInDTO productRequestDTO) {
        Product productToUpdate = repository.findById(id)
                .orElse(null);

        if (productToUpdate != null) {
            // Utilizar el mapper para mapear los campos del DTO al Producto
            Product mappedProduct = mapperupdate.map(productRequestDTO);

            // Actualizar los campos del producto con los valores mapeados
            productToUpdate.setNombre(mappedProduct.getNombre());
            productToUpdate.setDescripcion(mappedProduct.getDescripcion());
            productToUpdate.setPrecio(mappedProduct.getPrecio());
            productToUpdate.setEstado(mappedProduct.getEstado());
            productToUpdate.setImagenUrl(mappedProduct.getImagenUrl());
            productToUpdate.setCategoria(mappedProduct.getCategoria());
            productToUpdate.setProveedor(mappedProduct.getProveedor());

            // Guardar el producto actualizado en la base de datos
            repository.save(productToUpdate);
        }
    }
}
