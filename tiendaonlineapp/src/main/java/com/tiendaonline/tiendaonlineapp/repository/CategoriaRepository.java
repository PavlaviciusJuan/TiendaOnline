package com.tiendaonline.tiendaonlineapp.repository;

import com.tiendaonline.tiendaonlineapp.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}

