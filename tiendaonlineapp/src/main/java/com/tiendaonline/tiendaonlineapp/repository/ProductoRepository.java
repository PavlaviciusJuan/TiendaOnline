package com.tiendaonline.tiendaonlineapp.repository;

import com.tiendaonline.tiendaonlineapp.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {}
