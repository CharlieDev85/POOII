package org.carlosmarroq.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.carlosmarroq.modelos.ModeloDatosClientes;
import org.carlosmarroq.bean.Cliente;



public class VentanaAgregarCliente extends VentanaAgregar implements ActionListener{
    JLabel lblNit;
    JLabel lblNombre;
    JLabel lblDpi;
    JTextField txtNit;
    JTextField txtNombre;
    JTextField txtDpi;
    ModeloDatosClientes modelo;
    
    
    public VentanaAgregarCliente(ModeloDatosClientes modelo) {
        super("Agregar cliente", 600, 250);
        this.modelo = modelo;
        this.setLayout(null);
        //a esta clase se le necesita asignar un modelo del tipo ModeloDatosClientes
        //con el objetivo de poder utilizar el metodo .agregar que tiene esta clase
        
        //lblNit y txt Nit
        lblNit = new JLabel("Nit");
        lblNit.setBounds(200, 10, 50, 20);
        lblNit.setVisible(true);
        this.getContentPane().add(lblNit);
        
        txtNit = new JTextField();
        txtNit.setBounds(260, 10, 150, 20);
        txtNit.setVisible(true);
        this.getContentPane().add(txtNit);
        
        
        //lblNombre y txtNombre
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(200, 40, 50, 20);
        lblNombre.setVisible(true);
        this.getContentPane().add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(260, 40, 150, 20);
        txtNombre.setVisible(true);
        this.getContentPane().add(txtNombre);
        
        //lblDpi y txtDpi
        lblDpi = new JLabel("DPI");
        lblDpi.setBounds(200, 70, 50, 20);
        lblDpi.setVisible(true);
        this.getContentPane().add(lblDpi);
        
        txtDpi = new JTextField();
        txtDpi.setBounds(260, 70, 150, 20);
        txtDpi.setVisible(true);
        this.getContentPane().add(txtDpi);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == getBtnGuardar()){
            modelo.agregar(new Cliente(txtNit.getText(), txtNombre.getText(), txtDpi.getText()));
            dispose();
        } else if(e.getSource() == getBtnCancelar()){
            dispose();
        }
    }
    
}
