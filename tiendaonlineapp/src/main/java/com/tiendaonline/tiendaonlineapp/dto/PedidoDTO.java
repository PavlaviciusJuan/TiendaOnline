package com.tiendaonline.tiendaonlineapp.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private LocalDateTime fecha;
    private String estado;
    private List<Long> productoIds;
    private Long usuarioId;

    public PedidoDTO() {
    }

    public PedidoDTO(Long id, LocalDateTime fecha, String estado, List<Long> productoIds, Long usuarioId) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.productoIds = productoIds;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Long> getProductoIds() {
        return productoIds;
    }

    public void setProductoIds(List<Long> productoIds) {
        this.productoIds = productoIds;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}

