
package org.carlosmarroq.modelos;
import org.carlosmarroq.manejadores.ManejadorDeCliente;
import javax.swing.table.AbstractTableModel;
import org.carlosmarroq.bean.Cliente;
import java.util.ArrayList;
import org.carlosmarroq.bean.Categoria;


public class ModeloDatosClientes extends AbstractTableModel{
    private String[] encabezados = {"nit", "nombre", "dpi"};
    private ArrayList<Cliente> listaClientes = null;
    private ManejadorDeCliente manejador = new ManejadorDeCliente();
    

    public ModeloDatosClientes() {
        listaClientes = manejador.getLista();
        
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
        return listaClientes.size();
    }
    @Override
    public Object getValueAt(int fila, int columna){//devuelve un object
        String resultado = "";
        Cliente elemento = listaClientes.get(fila);
        switch(columna){
            case 0:
                resultado = elemento.getNit();
                break;
            case 1:
                resultado = elemento.getNombre();
                break;
            case 2:
                resultado = elemento.getDpi();
                break;
        }
        return resultado;
    }
    
    public void refresh(){
        listaClientes.removeAll(listaClientes);
        listaClientes = manejador.getLista();
        fireTableDataChanged();// le informa a la aplicacion que se cambio la info y que se debe refrescar.
    }
    
    public Cliente getElemento(int fila){
        Cliente elemento = listaClientes.get(fila);
        return elemento;
        // o se puede solamente
        //return listaCliente.get(fila);
    }
    
    public void agregar(Cliente cliente){
        manejador.agregar(cliente);//llama al metodo .agregar que esta en el manejador.
        this.refresh();
        
    }
    
    public void eliminar(int fila){
        manejador.eliminar(listaClientes.get(fila));
        this.refresh();
    }
    
    public void modificar(Cliente cliente){
        manejador.modificar(cliente);
        this.refresh();
    }
}
    
