package com.tiendaonline.tiendaonlineapp.controller;

import com.tiendaonline.tiendaonlineapp.dto.ProductoDTO;
import com.tiendaonline.tiendaonlineapp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    public ProductoController() {
    }

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/")
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO savedProducto = productoService.save(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO updatedProducto = productoService.update(id, productoDTO);
        return ResponseEntity.ok(updatedProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProducto(@PathVariable Long id) {
        ProductoDTO producto = productoService.findById(id);
        return ResponseEntity.ok(producto);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoService.findAll();
        return ResponseEntity.ok(productos);
    }
}

