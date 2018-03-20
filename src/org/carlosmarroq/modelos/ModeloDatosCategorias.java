
package org.carlosmarroq.modelos;

import org.carlosmarroq.manejadores.ManejadorDeCategoria;
import javax.swing.table.AbstractTableModel;
import org.carlosmarroq.bean.Categoria;
import java.util.ArrayList;

public class ModeloDatosCategorias extends AbstractTableModel {
    private String[] encabezados = {"COD CATEGORIA", "DESCRIPCION",};
    private ArrayList<Categoria> listaCategoria = null;
    private ManejadorDeCategoria manejador = new ManejadorDeCategoria();

    public ModeloDatosCategorias() {
        listaCategoria = manejador.getLista();
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
        return listaCategoria.size();
    }
    @Override
    public Object getValueAt(int fila, int columna){//devuelve un object
        String resultado = "";
        Categoria elemento = listaCategoria.get(fila);
        switch(columna){
            case 0:
                resultado = elemento.getCodCategoria();
                break;
            case 1:
                resultado = elemento.getDescripcionCategoria();
                break;
            
        }
        return resultado;
    }
    
}
