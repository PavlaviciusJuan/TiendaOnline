package com.tiendaonline.tiendaonlineapp.dto;

public class ProductoPedidoDTO {
    private Long pedidoId;
    private Long productoId;
    private Integer cantidad;

    public ProductoPedidoDTO() {
    }

    public ProductoPedidoDTO(Long pedidoId, Long productoId, Integer cantidad) {
        this.pedidoId = pedidoId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}

