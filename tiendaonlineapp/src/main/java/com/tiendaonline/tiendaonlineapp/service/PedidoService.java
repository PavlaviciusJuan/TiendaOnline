package com.tiendaonline.tiendaonlineapp.service;

import com.tiendaonline.tiendaonlineapp.model.Pedido;
import com.tiendaonline.tiendaonlineapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Long id, Pedido pedido) {
        Pedido existingPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        existingPedido.setEstado(pedido.getEstado());
        return pedidoRepository.save(existingPedido);
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
