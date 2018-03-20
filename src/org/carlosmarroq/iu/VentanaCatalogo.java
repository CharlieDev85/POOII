
package org.carlosmarroq.iu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//interface ActionListener
//Las interfaces tienen metodos definidos, y debe ser descrito en la clase.
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;//sirve para mostrar mensajes

import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.AbstractTableModel;

import org.carlosmarroq.modelos.ModeloDatosClientes;
import org.carlosmarroq.modelos.ModeloDatosProveedores;
import org.carlosmarroq.modelos.ModeloDatosCategorias;
import org.carlosmarroq.modelos.ModeloDatosProductos;

public class VentanaCatalogo extends JFrame implements ActionListener{
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnReporte;
    private JTable tblDatos;
    private JScrollPane scrDatos;

    private AbstractTableModel modelo;
    
    public VentanaCatalogo(String titulo, int ancho, int alto, AbstractTableModel modelo)  {
        this.modelo = modelo;
        this.setTitle(titulo);
        this.setSize(ancho,alto);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//finaliza la instancia
        this.setLayout(null);//al escribir esto java respeta la posicion determinada en setBounds
        this.setLocationRelativeTo(null);
        
        //btn Agregar
        btnAgregar = new JButton("Agregar");
        this.getContentPane().add(btnAgregar);
        btnAgregar.setBounds(10, 20, 120, 50);
        btnAgregar.addActionListener(this);//el escuchador de este boton va a ser la interfaz que estoy implementando en mi clase
        
        
        //boton Modificar
        btnModificar = new JButton("Modificar");
        this.getContentPane().add(btnModificar);
        btnModificar.setBounds(10, 80, 120, 50);
        btnModificar.addActionListener(this);
        
        // btn eliminar
        btnEliminar = new JButton("Eliminar");
        this.getContentPane().add(btnEliminar);
        btnEliminar.setBounds(10, 140, 120, 50);
        btnEliminar.addActionListener(this);
        
        //btn reporte
        btnReporte = new JButton ("Reporte");
        this.getContentPane().add(btnReporte);
        btnReporte.setBounds(10, 200, 120, 50);
        btnReporte.addActionListener(this);
        
        
        //Jtable
        tblDatos = new JTable();
        scrDatos = new JScrollPane();
        scrDatos.setBounds(150, 10, 570, 500);
        scrDatos.setViewportView(tblDatos);//
        this.getContentPane().add(scrDatos);
        
        
        
        tblDatos.setModel(modelo);
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnReporte() {
        return btnReporte;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public JScrollPane getScrDatos() {
        return scrDatos;
    }

    public AbstractTableModel getModelo() {
        return modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
