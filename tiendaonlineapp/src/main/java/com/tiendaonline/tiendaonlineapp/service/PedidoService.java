package com.tiendaonline.tiendaonlineapp.service;

import com.tiendaonline.tiendaonlineapp.dto.PedidoDTO;
import com.tiendaonline.tiendaonlineapp.model.Pedido;
import com.tiendaonline.tiendaonlineapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setFecha(pedidoDTO.getFecha());
        pedido.setEstado(pedidoDTO.getEstado());

        Pedido savedPedido = pedidoRepository.save(pedido);
        return convertToDTO(savedPedido);
    }


    public PedidoDTO update(Long id, PedidoDTO pedidoDTO) {
        Optional<Pedido> existingPedidoOpt = pedidoRepository.findById(id);
        if (existingPedidoOpt.isPresent()) {
            Pedido pedido = existingPedidoOpt.get();
            pedido.setFecha(pedidoDTO.getFecha());
            pedido.setEstado(pedidoDTO.getEstado());

            Pedido updatedPedido = pedidoRepository.save(pedido);
            return convertToDTO(updatedPedido);
        } else {
            throw new RuntimeException("Pedido not found");
        }
    }

    public PedidoDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido not found"));
        return convertToDTO(pedido);
    }

    public List<PedidoDTO> findAll() {
        return pedidoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PedidoDTO convertToDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setFecha(pedido.getFecha());
        pedidoDTO.setEstado(pedido.getEstado());
        pedidoDTO.setUsuarioId(pedido.getUsuario().getId());
        pedidoDTO.setProductoIds(pedido.getProductos().stream()
                .map(producto -> producto.getId())
                .collect(Collectors.toList()));
        return pedidoDTO;
    }
}
