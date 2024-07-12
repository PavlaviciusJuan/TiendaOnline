package com.tiendaonline.tiendaonlineapp.repository;

import com.tiendaonline.tiendaonlineapp.model.ProductoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Long> {
    Optional<ProductoPedido> findByPedidoIdAndProductoId(Long pedidoId, Long productoId);
}

