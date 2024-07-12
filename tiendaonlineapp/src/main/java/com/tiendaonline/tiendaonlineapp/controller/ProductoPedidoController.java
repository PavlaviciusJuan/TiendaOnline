package com.tiendaonline.tiendaonlineapp.controller;

import com.tiendaonline.tiendaonlineapp.dto.ProductoPedidoDTO;
import com.tiendaonline.tiendaonlineapp.service.ProductoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto-pedido")
public class ProductoPedidoController {

    @Autowired
    private ProductoPedidoService productoPedidoService;

    @PostMapping("/")
    public ResponseEntity<ProductoPedidoDTO> createProductoPedido(@RequestBody ProductoPedidoDTO productoPedidoDTO) {
        ProductoPedidoDTO productoPedido = productoPedidoService.save(productoPedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoPedido);
    }

    @PutMapping("/")
    public ResponseEntity<ProductoPedidoDTO> updateProductoPedido(
            @PathVariable Long productoId,
            @PathVariable Long pedidoId,
            @RequestBody ProductoPedidoDTO productoPedidoDTO) {
        ProductoPedidoDTO updatedProductoPedido = productoPedidoService.update(productoId, pedidoId, productoPedidoDTO);
        return ResponseEntity.ok(updatedProductoPedido);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteProductoPedido(@PathVariable Long productoId, @PathVariable Long pedidoId) {
        productoPedidoService.delete(productoId, pedidoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductoPedidoDTO>> getAllProductoPedidos() {
        List<ProductoPedidoDTO> productosPedidos = productoPedidoService.findAll();
        return ResponseEntity.ok(productosPedidos);
    }
}

