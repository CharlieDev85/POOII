package org.carlosmarroq.bean;

public class Categoria {
    private String codCategoria;
    private String descripcionCategoria;

    public Categoria() {
    }

    public Categoria(String codCategoria, String descripcionCategoria) {
        this.codCategoria = codCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
    
    
   
}
