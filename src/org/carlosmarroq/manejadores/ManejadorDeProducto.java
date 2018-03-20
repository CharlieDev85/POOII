package org.carlosmarroq.manejadores;

import java.util.ArrayList;
import org.carlosmarroq.bean.Producto;
import org.carlosmarroq.db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManejadorDeProducto {
    private ArrayList<Producto> lista = new ArrayList<Producto>();
    
    public ArrayList<Producto> getLista() {
        ResultSet datos = Conexion.getInstancia().hacerConsulta("select * from vw_Productos");
        try{
            while (datos.next()){
                lista.add(new Producto(datos.getString("idProducto"), datos.getString("nombre") , datos.getString("descripcion")) );
            }
            } catch(SQLException e){
                e.printStackTrace();
            }
        
        return lista;
    }
}
