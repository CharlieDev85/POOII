
package org.carlosmarroq.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.carlosmarroq.bean.Proveedor;
import org.carlosmarroq.modelos.ModeloDatosProveedores;

public class VentanaCatalogoProveedor extends VentanaCatalogo implements ActionListener {
    
    
    public VentanaCatalogoProveedor() {
        super("Ventana Proveedores", 800, 600, new ModeloDatosProveedores());
        
    }
    
    public void eliminarProveedorSeleccionado(){
        if(getTblDatos().getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            ((ModeloDatosProveedores)getModelo()).eliminar(getTblDatos().getSelectedRow());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==getBtnAgregar()){
            System.out.println("agregando proveedor");
            new VentanaAgregarProveedor((ModeloDatosProveedores)getModelo());
        } else if(e.getSource()==getBtnModificar()){
            System.out.println("modificando proveedor");
            if(getTblDatos().getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            } else{
                Proveedor elemento;
                int filaSeleccionada;
                filaSeleccionada = getTblDatos().getSelectedRow();
                elemento = ((ModeloDatosProveedores)getModelo()).getElemento(filaSeleccionada);
                new VentanaModificarProveedor((ModeloDatosProveedores)getModelo(), elemento);//de esta manera se le envia a la VentanaModificarProveedor; el nit que utilizara el procedimiento almacenado
            }
            
        } else if(e.getSource()==getBtnEliminar()){
            System.out.println("Eliminando proveedor");
            eliminarProveedorSeleccionado();
            
        } else if(e.getSource()==getBtnReporte()){
            System.out.println("imprimiendo proveedores");
        }
    }
    
}
