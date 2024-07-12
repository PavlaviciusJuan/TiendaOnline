package com.tiendaonline.tiendaonlineapp.service;

import com.tiendaonline.tiendaonlineapp.dto.CategoriaDTO;
import com.tiendaonline.tiendaonlineapp.dto.ProductoDTO;
import com.tiendaonline.tiendaonlineapp.excepciones.ProductoExcepcion;
import com.tiendaonline.tiendaonlineapp.model.Categoria;
import com.tiendaonline.tiendaonlineapp.model.Producto;
import com.tiendaonline.tiendaonlineapp.repository.CategoriaRepository;
import com.tiendaonline.tiendaonlineapp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());

        Optional<Categoria> categoriaOpt = categoriaRepository.findById(productoDTO.getCategoria().getId());
        if (categoriaOpt.isPresent()) {
            producto.setCategoria(categoriaOpt.get());
        } else {
            throw new ProductoExcepcion(productoDTO.getCategoria().getId());
        }

        Producto savedProducto = productoRepository.save(producto);
        return convertToDTO(savedProducto);
    }

    public ProductoDTO update(Long id, ProductoDTO productoDTO) {
        Optional<Producto> existingProductoOpt = productoRepository.findById(id);
        if (existingProductoOpt.isPresent()) {
            Producto producto = existingProductoOpt.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setStock(productoDTO.getStock());

            Optional<Categoria> categoriaOpt = categoriaRepository.findById(productoDTO.getCategoria().getId());
            if (categoriaOpt.isPresent()) {
                producto.setCategoria(categoriaOpt.get());
            } else {
                throw new ProductoExcepcion(productoDTO.getCategoria().getId());
            }

            Producto updatedProducto = productoRepository.save(producto);
            return convertToDTO(updatedProducto);
        } else {
            throw new ProductoExcepcion(id);
        }
    }

    public void delete(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new ProductoExcepcion(id);
        }
    }

    public ProductoDTO findById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoExcepcion(id));
        return convertToDTO(producto);
    }

    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductoDTO convertToDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setStock(producto.getStock());
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(producto.getCategoria().getId());
        categoriaDTO.setNombre(producto.getCategoria().getNombre());
        categoriaDTO.setDescripcion(producto.getCategoria().getDescripcion());
        productoDTO.setCategoria(categoriaDTO);
        return productoDTO;
    }
}

