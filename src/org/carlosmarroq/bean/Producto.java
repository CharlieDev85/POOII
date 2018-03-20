package org.carlosmarroq.bean;

public class Producto {
    private String codProducto;
    private String categoria;
    private String descripcionProducto;

    public Producto() {
    }

    public Producto(String codProducto, String descripcionProducto, String categoria) {
        this.codProducto = codProducto;
        this.categoria = categoria;
        this.descripcionProducto = descripcionProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
                
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    
}
