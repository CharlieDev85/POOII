
package org.carlosmarroq.manejadores;
import java.util.ArrayList;
import org.carlosmarroq.bean.Proveedor;
import org.carlosmarroq.db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
public class ManejadorDeProveedor {
    private ArrayList<Proveedor> lista = new ArrayList<Proveedor>();

    public ManejadorDeProveedor() {
    }

    public ArrayList<Proveedor> getLista() {
        
        ResultSet datos = Conexion.getInstancia().hacerConsulta("select * from Proveedores");
        try{
            while (datos.next()){
                lista.add(new Proveedor(datos.getString("nit"), datos.getString("nombre"), 
                datos.getString("paginaWeb"), datos.getString("contacto")));
            }
            } catch(SQLException e){
                e.printStackTrace();
            }
        return lista;
    }
    
    public void agregar(Proveedor proveedor){
        Map parametros = new HashMap();
        parametros.put("nit", proveedor.getNitProveedor());
        parametros.put("nombre", proveedor.getNombre());
        parametros.put("paginaWeb", proveedor.getPaginaWeb());
        parametros.put("contacto", proveedor.getContacto());
        Conexion.getInstancia().ejecutarProcedimiento("{call sp_Insertar_Proveedor(?,?,?,?)}", parametros, false);
    }
    
    public void modificar(Proveedor proveedor){
        Map parametros = new HashMap();
        parametros.put("nit", proveedor.getNitProveedor());
        parametros.put("nombre", proveedor.getNombre());
        parametros.put("paginaWeb", proveedor.getPaginaWeb());
        parametros.put("contacto", proveedor.getContacto());
        Conexion.getInstancia().ejecutarProcedimiento("{call sp_Modificar_Proveedor(?,?,?,?)}", parametros, false);
    }
    
    public void eliminar (Proveedor proveedor){
        Map parametros = new HashMap();
        parametros.put("nit", proveedor.getNitProveedor());
        Conexion.getInstancia().ejecutarProcedimiento("{call sp_Eliminar_Proveedor(?)}", parametros, false);
    }
    
    
}
