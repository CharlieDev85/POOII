package org.carlosmarroq.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.carlosmarroq.bean.Cliente;
import org.carlosmarroq.modelos.ModeloDatosClientes;



public class VentanaModificarCliente extends VentanaAgregar implements ActionListener {
    
    JLabel lblNombre;
    JLabel lblDpi;
    JTextField txtNombre;
    JTextField txtDpi;
    ModeloDatosClientes modelo; // se instancia ModeloDatosClientes para poder usar su metodo .modificar
    Cliente cliente;

    public VentanaModificarCliente(ModeloDatosClientes modelo, Cliente cliente) {
        super("Modificar Cliente", 600, 250);
        this.setLayout(null);
        this.modelo = modelo;
        this.cliente = cliente;
        
        //lblNombre y txtNombre
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(200, 40, 50, 20);
        lblNombre.setVisible(true);
        this.getContentPane().add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setText(cliente.getNombre());
        txtNombre.setBounds(260, 40, 150, 20);
        txtNombre.setVisible(true);
        this.getContentPane().add(txtNombre);
        
        //lblDpi y txtDpi
        lblDpi = new JLabel("DPI");
        lblDpi.setBounds(200, 70, 50, 20);
        lblDpi.setVisible(true);
        this.getContentPane().add(lblDpi);
        
        txtDpi = new JTextField();
        txtDpi.setText(cliente.getDpi());
        txtDpi.setBounds(260, 70, 150, 20);
        txtDpi.setVisible(true);
        this.getContentPane().add(txtDpi);
        
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==getBtnCancelar()){
            dispose();
        } else if(e.getSource()==getBtnGuardar()){
            cliente.setNombre(txtNombre.getText());
            cliente.setDpi(txtDpi.getText());
            modelo.modificar(cliente);
            dispose();
        }
    }
    
}
