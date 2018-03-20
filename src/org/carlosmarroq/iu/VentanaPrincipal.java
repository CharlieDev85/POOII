
package org.carlosmarroq.iu;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JDesktopPane panelVentana;
    private JMenuBar menuPrincipal;
    private JMenu catalogos;
    private JMenuItem cliente;
    private JMenuItem proveedores;
    

    public VentanaPrincipal() {
        
        this.setTitle("Punto de Venta 2015");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        panelVentana = new JDesktopPane(){
            @Override
            public void paintComponent(Graphics g){
            
            }    
            };
        
        this.getContentPane().add(panelVentana, BorderLayout.CENTER);
        this.setJMenuBar(getMenuPrincipal());
        
        
        this.setVisible(true); 
        
                
        
    }



    public JMenuBar getMenuPrincipal() {
        if(menuPrincipal == null){
            menuPrincipal = new JMenuBar();
            menuPrincipal.add(getCatalogos());
        }
        return menuPrincipal;
    }

    public JMenu getCatalogos() {
        if(catalogos == null){
            catalogos = new JMenu("Catalogos");
            catalogos.setMnemonic('C');
            catalogos.setToolTipText("Catalogos");
            catalogos.add(getCliente());
            catalogos.add(getProveedores());
        }        
        return catalogos;
    }

    public JMenuItem getCliente() {
        if(cliente == null){
            cliente = new JMenuItem("Clientes");
            cliente.setMnemonic('a');
            cliente.setToolTipText("Clientes");
            cliente.addActionListener(this);
        }
        
        return cliente;
    }

    public JMenuItem getProveedores() {
        if(proveedores == null){
            proveedores = new JMenuItem("Proveedores");
            proveedores.setMnemonic('P');
            proveedores.setToolTipText("Proveedore");
            proveedores.addActionListener(this);
            
        }
        return proveedores;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        if(e.getSource() == cliente){
            System.out.println("click en clientes");
            new VentanaCatalogoCliente();
        } else if(e.getSource() == proveedores){
            System.out.println("click en proveedores");
            new VentanaCatalogoProveedor();
        }
    }
    
    
    
    
}
