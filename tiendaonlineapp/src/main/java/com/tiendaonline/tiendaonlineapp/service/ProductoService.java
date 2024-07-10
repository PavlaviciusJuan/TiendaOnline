package com.tiendaonline.tiendaonlineapp.service;

import com.tiendaonline.tiendaonlineapp.model.Producto;
import com.tiendaonline.tiendaonlineapp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(Long id, Producto producto) {
        Producto existingProducto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setPrecio(producto.getPrecio());
        existingProducto.setStock(producto.getStock());
        return productoRepository.save(existingProducto);
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }
}
