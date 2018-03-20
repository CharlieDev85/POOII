package org.carlosmarroq.bean;

public class Proveedor {
    
    private String nitProveedor;
    private String nombre;
    private String paginaWeb;
    private String contacto;

    public Proveedor() {
    }

    public Proveedor(String nitProveedor, String nombre, String paginaWeb, String contacto) {
        this.nitProveedor = nitProveedor;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.contacto = contacto;
    }
    
    public Proveedor(String nombre, String paginaWeb, String contacto) {
        
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.contacto = contacto;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
}
