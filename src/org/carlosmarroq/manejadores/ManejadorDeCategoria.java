package org.carlosmarroq.manejadores;
import java.util.ArrayList;
import org.carlosmarroq.bean.Categoria;
import org.carlosmarroq.db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ManejadorDeCategoria {
    private ArrayList<Categoria> lista = new ArrayList<Categoria>();

    public ManejadorDeCategoria() {
    }

    public ArrayList<Categoria> getLista() {
        ResultSet datos = Conexion.getInstancia().hacerConsulta("select * from vw_Categorias");
        try{
            while (datos.next()){
                lista.add(new Categoria(datos.getString("idCategoria"), datos.getString("descripcion")));
            }
            } catch(SQLException e){
                e.printStackTrace();
            }
        
        return lista;
    }
    
}
