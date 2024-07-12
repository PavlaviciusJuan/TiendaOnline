package com.tiendaonline.tiendaonlineapp.service;

import com.tiendaonline.tiendaonlineapp.dto.ProductoPedidoDTO;
import com.tiendaonline.tiendaonlineapp.model.Pedido;
import com.tiendaonline.tiendaonlineapp.model.Producto;
import com.tiendaonline.tiendaonlineapp.model.ProductoPedido;
import com.tiendaonline.tiendaonlineapp.repository.PedidoRepository;
import com.tiendaonline.tiendaonlineapp.repository.ProductoRepository;
import com.tiendaonline.tiendaonlineapp.repository.ProductoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoPedidoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    public ProductoPedidoDTO save(ProductoPedidoDTO productoPedidoDTO) {
        Producto producto = productoRepository.findById(productoPedidoDTO.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto not found"));
        Pedido pedido = pedidoRepository.findById(productoPedidoDTO.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido not found"));

        ProductoPedido productoPedido = new ProductoPedido();
        productoPedido.setProducto(producto);
        productoPedido.setPedido(pedido);
        productoPedido.setCantidad(productoPedidoDTO.getCantidad());

        ProductoPedido savedProductoPedido = productoPedidoRepository.save(productoPedido);
        return convertToDTO(savedProductoPedido);
    }

    public ProductoPedidoDTO update(Long productoId, Long pedidoId, ProductoPedidoDTO productoPedidoDTO) {
        ProductoPedido productoPedido = productoPedidoRepository.findByPedidoIdAndProductoId(pedidoId, productoId)
                .orElseThrow(() -> new RuntimeException("ProductoPedido not found"));

        productoPedido.setCantidad(productoPedidoDTO.getCantidad());

        ProductoPedido updatedProductoPedido = productoPedidoRepository.save(productoPedido);
        return convertToDTO(updatedProductoPedido);
    }

    public void delete(Long productoId, Long pedidoId) {
        ProductoPedido productoPedido = productoPedidoRepository.findByPedidoIdAndProductoId(pedidoId, productoId)
                .orElseThrow(() -> new RuntimeException("ProductoPedido not found"));

        productoPedidoRepository.delete(productoPedido);
    }

    public List<ProductoPedidoDTO> findAll() {
        return productoPedidoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductoPedidoDTO convertToDTO(ProductoPedido productoPedido) {
        ProductoPedidoDTO productoPedidoDTO = new ProductoPedidoDTO();
        productoPedidoDTO.setPedidoId(productoPedido.getPedido().getId());
        productoPedidoDTO.setProductoId(productoPedido.getProducto().getId());
        productoPedidoDTO.setCantidad(productoPedido.getCantidad());
        return productoPedidoDTO;
    }
}

