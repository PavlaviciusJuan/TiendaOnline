package com.tiendaonline.tiendaonlineapp.service;


import com.tiendaonline.tiendaonlineapp.model.Categoria;
import com.tiendaonline.tiendaonlineapp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Long id, Categoria categoria) {
        Categoria existingCategoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        existingCategoria.setNombre(categoria.getNombre());
        return categoriaRepository.save(existingCategoria);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}

