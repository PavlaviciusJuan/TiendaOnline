package com.tiendaonline.tiendaonlineapp.excepciones;

public class ProductoExcepcion extends TiendaOnlineExcepcion {
    public ProductoExcepcion(Long id) {
        super("Producto con ID; " + id + " no encontrado...");
    }
}
