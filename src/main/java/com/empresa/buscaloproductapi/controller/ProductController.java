package com.empresa.buscaloproductapi.controller;

import com.empresa.buscaloproductapi.persistence.entity.Product;
import com.empresa.buscaloproductapi.service.IProductService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/products")
@Api(tags = {"Producto"})
@ApiModel(description = "Detalles del producto")
public class ProductController {

    private final IProductService productService;


    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo producto", notes = "Añade un nuevo producto a la base de datos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Producto creado exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta, verifique los datos enviados"),
            @ApiResponse(code = 401, message = "No autorizado, se requiere autenticación"),
            @ApiResponse(code = 403, message = "Prohibido, el usuario no tiene los permisos necesarios"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product producto) {
        Product newProduct = this.productService.registrarProducto(producto);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @GetMapping //que utiliza un get
    @ApiOperation(value = "Listar los productos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Productos encontrados", response = Product.class),
            @ApiResponse(code = 401, message = "No autorizado, se requiere autenticación"),
            @ApiResponse(code = 403, message = "Prohibido, el usuario no tiene los permisos necesarios"),
            @ApiResponse(code = 404, message = "No existen productos"),
            @ApiResponse(code = 500, message = "Error del interno del servidor")
    })
    public ResponseEntity<?> listarProductos(){
        List<Product> productos = productService.listarProductos();
        return new ResponseEntity<>(productos, !productos.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un producto por su ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Producto encontrado", response = Product.class),
            @ApiResponse(code = 401, message = "No autorizado, se requiere autenticación"),
            @ApiResponse(code = 403, message = "Prohibido, el usuario no tiene los permisos necesarios"),
            @ApiResponse(code = 404, message = "Producto no encontrado"),
            @ApiResponse(code = 500, message = "Error del interno del servidor")
    })
    public ResponseEntity<?> obtenerProducto(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.obtenerProducto(id), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "Modificar un producto por su ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Producto modificaco exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta, verifique los datos enviados"),
            @ApiResponse(code = 401, message = "No autorizado, se requiere autenticación"),
            @ApiResponse(code = 403, message = "Prohibido, el usuario no tiene los permisos necesarios"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> modificarProducto(@Valid @RequestBody Product producto){
        Product newProducto = productService.modificarProducto(producto);
        return new ResponseEntity<>(newProducto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Eliminar un producto por su ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Producto eliminado exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta, verifique los datos enviados"),
            @ApiResponse(code = 401, message = "No autorizado, se requiere autenticación"),
            @ApiResponse(code = 403, message = "Prohibido, el usuario no tiene los permisos necesarios"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.eliminarProducto(id), HttpStatus.OK);
    }

    @GetMapping("/{nombre}/listado")
    @ApiOperation(value = "Listar productos por su nombre")
    @ApiParam(name = "nombre", value = "Nombre del producto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Productos encontrados exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta, verifique los datos enviados"),
            @ApiResponse(code = 401, message = "No autorizado, se requiere autenticación"),
            @ApiResponse(code = 403, message = "Prohibido, el usuario no tiene los permisos necesarios"),
            @ApiResponse(code = 404, message = "No se encontraron productos con el nombre especificado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<?> listarProductosPorNombre(@PathVariable String nombre) {
        List<Product> productos = productService.listarProductosPorNombre(nombre);
        return new ResponseEntity<>(productos, !productos.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
