package com.empresa.buscaloproductapi.controller;

import com.empresa.buscaloproductapi.persistence.entity.Product;
import com.empresa.buscaloproductapi.service.ProductService;
import com.empresa.buscaloproductapi.service.dto.ProductInDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
@Api(tags = {"Producto"})
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo producto", notes = "Añade un nuevo producto a la base de datos")
    public Product createProduct(@RequestBody ProductInDTO productInDTO){
        return this.productService.createProduct(productInDTO);
    }
    @GetMapping
    @ApiOperation(value = "Lista todos lo productos creados")
    public List<Product> findAll(){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un producto por su ID")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un producto por su ID")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Modificar un producto por su ID")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id,
                                              @RequestBody ProductInDTO productRequestDTO) {
        productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.noContent().build();
    }


}
