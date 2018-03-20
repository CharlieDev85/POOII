package org.carlosmarroq.bean;
//este bean se creo con los datos resultados de la consulta de sql
public class Cliente {
    private String nit;
    private String nombre;
    private String dpi;

    public Cliente() {
    }

    public Cliente(String nit, String nombre, String dpi) {
        this.nit = nit;
        this.nombre = nombre;
        this.dpi = dpi;
    }

    
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    
    
    
    
    
}
