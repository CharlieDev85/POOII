//"el manejador despliga la informacion de todos los campos de las tablas
package org.carlosmarroq.manejadores;
import java.util.ArrayList;//para la coleccion
import org.carlosmarroq.bean.Cliente;//el bean de la clase
import org.carlosmarroq.db.Conexion;//para la conexion a la db
import java.sql.ResultSet;// para hacer la consulta
import java.sql.SQLException;// para controlar la excepcion
import java.util.HashMap;
import java.util.Map;
public class ManejadorDeCliente {
    //se crea la coleccion que tendra datos de tipo Cliente y se llamara lista
    private ArrayList<Cliente> lista = new ArrayList<Cliente>();
    
    //constructor nulo
    public ManejadorDeCliente() {
    
    }

    public ArrayList<Cliente> getLista() {
            //se ejecuta el metodo estatico .getInstancia de la clase conexion
            //de esta instancia se ejecuta el metodo .hacerConsulta
            //y a este metodo se le manda como parámetro el codigo transact de la vista
            ResultSet datos = Conexion.getInstancia().hacerConsulta("select * from clientes");
            
            
            try{
            //por cada uno de los registros de la tabla, se agrega un objeto a la colecion lista
            //la clase ResultSet tiene el metodo .getString, y se debe de colocar el nombre de la columna de la tabla
            while (datos.next()){
                lista.add(new Cliente(datos.getString("nit"), datos.getString("nombre"), datos.getString("dpi")));
            }
            } catch(SQLException e){
                e.printStackTrace();
            }
        return lista;
    }
    
    public void agregar(Cliente cliente){//llama al metodo .agregarCliente que esta en conexion.
//        Conexion.getInstancia().agregarCliente(cliente.getNit(), cliente.getNombre(), cliente.getDpi());
        Map parametros = new HashMap();
        parametros.put ("nit", cliente.getNit());
        parametros.put ("dpi", cliente.getDpi());
        parametros.put ("nombre", cliente.getNombre());
        Conexion.getInstancia().ejecutarProcedimiento("{call sp_Insertar_Cliente(?,?,?)}", parametros, false);
    }
    
    public void eliminar(Cliente cliente){
        Map parametros = new HashMap();
        parametros.put("nit", cliente.getNit());
        Conexion.getInstancia().ejecutarProcedimiento("{call sp_Eliminar_Cliente(?)}", parametros, false);
    }
    
    public void modificar(Cliente cliente){
        Map parametros = new HashMap();
        parametros.put("nit", cliente.getNit());
        parametros.put("nombre", cliente.getNombre());
        parametros.put("dpi", cliente.getDpi());
        Conexion.getInstancia().ejecutarProcedimiento("{call sp_Modificar_NombreDelCliente(?,?,?)}", parametros, false);
    }
    
    
    
}
