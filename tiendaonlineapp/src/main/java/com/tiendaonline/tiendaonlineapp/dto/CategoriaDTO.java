package com.tiendaonline.tiendaonlineapp.dto;

import java.util.List;

public class CategoriaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private List<Long> productoIds;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String nombre, String descripcion, List<Long> productoIds) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productoIds = productoIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Long> getProductoIds() {
        return productoIds;
    }

    public void setProductoIds(List<Long> productoIds) {
        this.productoIds = productoIds;
    }
}

