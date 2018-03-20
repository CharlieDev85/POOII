package org.carlosmarroq.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

public class VentanaAgregar extends JDialog implements ActionListener {
    private JButton btnGuardar;
    private JButton btnCancelar;
    

    public VentanaAgregar(String titulo, int ancho, int alto) {
        this.setTitle(titulo);
        this.setSize(ancho,alto);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//finaliza la instancia
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        //btn guardar
        btnGuardar = new JButton ("Guardar");
        btnGuardar.setBounds(10, 80, 120, 50);
        btnGuardar.addActionListener(this);        
        btnGuardar.setVisible(true);
        this.getContentPane().add(btnGuardar);
        
        //btn cancelar
        btnCancelar = new JButton ("Cancelar");
        btnCancelar.setBounds(10, 140, 120, 50);
        btnCancelar.addActionListener(this);
        btnCancelar.setVisible(true);
        this.getContentPane().add(btnCancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    
    
    
}
