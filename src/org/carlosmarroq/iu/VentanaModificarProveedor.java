package org.carlosmarroq.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.carlosmarroq.bean.Proveedor;
import org.carlosmarroq.modelos.ModeloDatosProveedores;

public class VentanaModificarProveedor extends VentanaAgregar implements ActionListener {
    
    JLabel lblNit;
    JLabel lblNombre;
    JLabel lblPaginaWeb;
    JLabel lblContacto;
    
    JTextField txtNit;
    JTextField txtNombre;
    JTextField txtPaginaWeb;
    JTextField txtContacto;
    
    ModeloDatosProveedores modelo;
    Proveedor proveedor;
    
    
    public VentanaModificarProveedor(ModeloDatosProveedores modelo, Proveedor proveedor) {
        super("Modifica Proveedor", 600, 250);
        this.modelo = modelo;
        this.proveedor = proveedor;
        this.setLayout(null);
        
        //lblNombre y txt nombre
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(150, 10, 80, 20);
        lblNombre.setVisible(true);
        this.getContentPane().add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(300, 10, 150, 20);
        txtNombre.setVisible(true);
        txtNombre.setText(proveedor.getNombre());
        this.getContentPane().add(txtNombre);
        
        //lblpagWeb y txt pagWeb
        lblPaginaWeb = new JLabel("Pagina Web");
        lblPaginaWeb.setBounds(150, 40, 80, 20);
        lblPaginaWeb.setVisible(true);
        this.getContentPane().add(lblPaginaWeb);
        
        txtPaginaWeb = new JTextField();
        txtPaginaWeb.setBounds(300, 40, 150, 20);
        txtPaginaWeb.setVisible(true);
        txtPaginaWeb.setText(proveedor.getPaginaWeb());
        this.getContentPane().add(txtPaginaWeb);
        
        //lblcontacto y txtContacto
        lblContacto = new JLabel("Contacto");
        lblContacto.setBounds(150, 70, 80, 20);
        lblContacto.setVisible(true);
        this.getContentPane().add(lblContacto);
        
        txtContacto = new JTextField();
        txtContacto.setBounds(300, 70, 150, 20);
        txtContacto.setVisible(true);
        txtContacto.setText(proveedor.getContacto());
        this.getContentPane().add(txtContacto);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==getBtnCancelar()){
            dispose();
        } else if(e.getSource()==getBtnGuardar()){
            System.out.println("btn guardar presionado");
            proveedor.setNombre(txtNombre.getText());
            proveedor.setPaginaWeb(txtPaginaWeb.getText());
            proveedor.setContacto(txtContacto.getText());
            modelo.modificar(proveedor);
            dispose();
        }
    }
    
}
