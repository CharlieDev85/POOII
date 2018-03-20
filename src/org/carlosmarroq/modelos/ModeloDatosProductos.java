package org.carlosmarroq.modelos;

import org.carlosmarroq.manejadores.ManejadorDeCategoria;
import javax.swing.table.AbstractTableModel;
import org.carlosmarroq.bean.Producto;
import java.util.ArrayList;
import org.carlosmarroq.bean.Categoria;
import org.carlosmarroq.manejadores.ManejadorDeProducto;

public class ModeloDatosProductos extends AbstractTableModel {
    
    private String[] encabezados = {"COD PRODUCTO", "DESCRIPCION", "CATEGORIA",};
    private ArrayList<Producto> listaProducto = null;
    private ManejadorDeProducto manejador = new ManejadorDeProducto();

    public ModeloDatosProductos() {
        listaProducto = manejador.getLista();
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
        return listaProducto.size();
    }
    @Override
    public Object getValueAt(int fila, int columna){//devuelve un object
        String resultado = "";
        Producto elemento = listaProducto.get(fila);
        switch(columna){
            case 0:
                resultado = elemento.getCodProducto();
                break;
            case 1:
                resultado = elemento.getDescripcionProducto();
                break;
            case 2:
                resultado = elemento.getCategoria();
                break;
            
        }
        return resultado;
    }
    
    
}
