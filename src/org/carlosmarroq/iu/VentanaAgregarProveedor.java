
package org.carlosmarroq.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.carlosmarroq.bean.Proveedor;
import org.carlosmarroq.modelos.ModeloDatosProveedores;

public class VentanaAgregarProveedor extends VentanaAgregar implements ActionListener {
    
    JLabel lblNombre;
    JLabel lblPaginaWeb;
    JLabel lblContacto;
    JLabel lblNit;
    
    JTextField txtNombre;
    JTextField txtPaginaWeb;
    JTextField txtContacto;
    JTextField txtNit;
    
    ModeloDatosProveedores mod;

    public VentanaAgregarProveedor(ModeloDatosProveedores mod) {
        super("Agregar Proveedor", 600, 250);
        this.mod = mod;
        this.setLayout(null);
        
        //lblNombre y txt nombre
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(150, 10, 80, 20);
        lblNombre.setVisible(true);
        this.getContentPane().add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(300, 10, 150, 20);
        txtNombre.setVisible(true);
        this.getContentPane().add(txtNombre);
        
        //lblpagWeb y txt pagWeb
        lblPaginaWeb = new JLabel("Pagina Web");
        lblPaginaWeb.setBounds(150, 40, 80, 20);
        lblPaginaWeb.setVisible(true);
        this.getContentPane().add(lblPaginaWeb);
        
        txtPaginaWeb = new JTextField();
        txtPaginaWeb.setBounds(300, 40, 150, 20);
        txtPaginaWeb.setVisible(true);
        this.getContentPane().add(txtPaginaWeb);
        
        //lblcontacto y txtContacto
        lblContacto = new JLabel("Contacto");
        lblContacto.setBounds(150, 70, 80, 20);
        lblContacto.setVisible(true);
        this.getContentPane().add(lblContacto);
        
        txtContacto = new JTextField();
        txtContacto.setBounds(300, 70, 150, 20);
        txtContacto.setVisible(true);
        this.getContentPane().add(txtContacto);
        
        //lblnit y txtNit
        lblNit = new JLabel("Nit");
        lblNit.setBounds(150, 100, 80, 20);
        lblNit.setVisible(true);
        this.getContentPane().add(lblNit);
        
        txtNit = new JTextField();
        txtNit.setBounds(300, 100, 150, 20);
        txtNit.setVisible(true);
        this.getContentPane().add(txtNit);
        
        
        
    }
    
    @Override
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==getBtnCancelar()){
                dispose();               
            } else if(e.getSource()==getBtnGuardar()){
                mod.agregar(new Proveedor(txtNit.getText(), txtNombre.getText(), txtPaginaWeb.getText(), txtContacto.getText()));
                dispose();
            }
        }
    
}
