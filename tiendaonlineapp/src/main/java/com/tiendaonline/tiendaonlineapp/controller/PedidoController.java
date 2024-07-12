package com.tiendaonline.tiendaonlineapp.controller;

import com.tiendaonline.tiendaonlineapp.dto.PedidoDTO;
import com.tiendaonline.tiendaonlineapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    public PedidoController() {
    }

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/")
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedido = pedidoService.save(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedido = pedidoService.update(id, pedidoDTO);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedido(@PathVariable Long id) {
        PedidoDTO pedido = pedidoService.findById(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

}

