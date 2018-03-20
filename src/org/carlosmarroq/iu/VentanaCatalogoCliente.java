
package org.carlosmarroq.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.carlosmarroq.bean.Cliente;
import org.carlosmarroq.modelos.ModeloDatosClientes;


public class VentanaCatalogoCliente extends VentanaCatalogo implements ActionListener {
    

    public VentanaCatalogoCliente() {
        super("Ventana Clientes", 800, 600, new ModeloDatosClientes());
    }
    
    public void abrirVentModificarConDatos(){
        Cliente elemento;
        int filaSeleccionada;
        filaSeleccionada = getTblDatos().getSelectedRow();
        elemento  = ((ModeloDatosClientes)getModelo()).getElemento(filaSeleccionada);
        new VentanaModificarCliente((ModeloDatosClientes)getModelo(), elemento);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == getBtnAgregar()){
            System.out.println("agregando");
            new VentanaAgregarCliente((ModeloDatosClientes)getModelo());//repasar esta parte del codigo
        } else if (e.getSource() == getBtnModificar()){
            System.out.println("modificando");
            if(getTblDatos().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            } else {
                abrirVentModificarConDatos();
            }
            
        }else if (e.getSource() == getBtnEliminar()){
            System.out.println("eliminando");
            if(getTblDatos().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            } else {
                ((ModeloDatosClientes)getModelo()).eliminar(getTblDatos().getSelectedRow());
                }
             
        } else if (e.getSource() == getBtnReporte()){
            System.out.println("generando reporte");
        }
    }
}
