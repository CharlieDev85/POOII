/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlosmarroq.modelos;
import org.carlosmarroq.manejadores.ManejadorDeProveedor;
import javax.swing.table.AbstractTableModel;
import org.carlosmarroq.bean.Proveedor;
import java.util.ArrayList;

public class ModeloDatosProveedores extends AbstractTableModel{
    
    private String[] encabezados = {"Nit Proveedor", "Nombre", "Pagina Web", "Tel. Contacto"};
    private ArrayList<Proveedor> listaProveedores = null;
    private ManejadorDeProveedor manejador = new ManejadorDeProveedor();
    
    public ModeloDatosProveedores() {
        listaProveedores = manejador.getLista();
        
    }
    
    @Override
    public String getColumnName (int columna){
        return encabezados[columna];
        
    }
    @Override
    public int getColumnCount(){
        return encabezados.length;
    }
    @Override
    public int getRowCount(){
        return listaProveedores.size();
    }
    @Override
    public Object getValueAt(int fila, int columna){//devuelve un object
        String resultado = "";
        Proveedor elemento = listaProveedores.get(fila);
        switch(columna){
            case 0:
                resultado = elemento.getNitProveedor();
                break;
            case 1:
                resultado = elemento.getNombre();
                break;
            case 2:
                resultado = elemento.getPaginaWeb();
                break;
            case 3:
                resultado = elemento.getContacto();

        }
        return resultado;
    }
    
    public void refresh(){
        listaProveedores.removeAll(listaProveedores);
        listaProveedores = manejador.getLista();
        fireTableDataChanged();
    }
    
    public Proveedor getElemento(int fila){
        Proveedor elemento = listaProveedores.get(fila);
        return elemento;
    }
    
    public void agregar(Proveedor proveedor){
        manejador.agregar(proveedor);
        refresh();
    }
    
    public void modificar(Proveedor proveedor){
        manejador.modificar(proveedor);
        refresh();
    }
    
    public void eliminar (int fila){
        manejador.eliminar(listaProveedores.get(fila));
        refresh();
    }
}
