package org.carlosmarroq.db;
//se importan estas clases para crear la conexion
import java.sql.CallableStatement;
import java.sql.ResultSet;//el metodo hacerConsulta devuelve un objeto de este tipo
import java.sql.Connection;// se instancio con la variable conexion
import java.sql.SQLException;// se utilizo para la exception
import java.sql.DriverManager;// se le utiliza el metodo .getConnection para escribir la conexion a sql
import java.sql.Statement;//para dictar sentencias, se instancio con la variable sentencia
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
                        


// se importa para poder jalar el nombre de la clase con todo su paquete

public class Conexion {
    private Connection conexion;//esta sera la cadena de conexion
    // al crear esta variable, ya pueden utilizar los metodos de la clase connection
    
    private Statement sentencia;
    //de esta forma se puede utilizar el metodo .executeQuery de la clase Statement
    //este metodo solicita un parametro(en este caso) String llamado consulta
    
    // singleton
    public static Conexion instancia;//se debe crear una variable static del mismo tipo de la clase
    public static Conexion getInstancia(){//lugo crear el metodo tambien static
        if (instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    //singleton
    
    //constructor para la clase Conexion
    public Conexion(){
        try{
            // se crea una instancia de la clase SQLServerDrieve en tiempo de ejecucion
            //para esto se utiliza el metodo forName
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conexion = DriverManager.getConnection("jdbc:sqlserver://CHARLIE:0;"
                    + "instanceName=SQLEXPRESS;dataBaseName=Inventario2015;user=charlie;"
                    + "password=charlie;");
            sentencia = conexion.createStatement();//aca se le dice al programa que ya esta listo para ejecutar cualquier sentencia de sql
        } catch (ClassNotFoundException e){// si no existiera la clase SQLServerDriver; esto crearia un error en tiempo de ejecucion
            e.printStackTrace();
        } catch (InstantiationException e){//si la clase no se pudiera instanciar; esto crearia error en tiempo de ejecucion
            e.printStackTrace();
        } catch (IllegalAccessException e) {//si no tuviera permisos para instanciar la clase SQLServerDriver;
            e.printStackTrace();            //esto crearia un error en tiempo de ejecucion
        } catch (SQLException e){// y si no fuera alguna de las anteriores, se controlaria con esta excepcion
        }
    }
    
    
    public ResultSet hacerConsulta (String consulta){//luego se podra utilizar este metodo en la instancia
                                                    //ej: instancia.hacerConsulta("select * from Clientes")
        ResultSet resultado = null;//ResultSet: conjunto de registros de la base de datos.
        try{              //sentencia es un objeto de tipo Statement
            resultado = sentencia.executeQuery(consulta);//el metodo executeQuery solicita un parametro
        } catch (SQLException e){                       //de tipo String y devuelve un ResultSet
            e.printStackTrace();
        }
        return resultado;
    
    }
    // este metodo ya no se utiliza ya que se creo el metodo generico
//    public void agregarCliente (String nit, String nombre, String dpi){//agrega el cliente a la base de datos.
//        try{
//            CallableStatement procedimiento = conexion.prepareCall("{call sp_Insertar_Cliente(?,?,?)}");
//            procedimiento.setString("nit", nit);            
//            procedimiento.setString("dpi", dpi);
//            procedimiento.setString("nombre", nombre);
//            procedimiento.execute();
//        } catch (SQLException e){
//        
//        }
//    }
    
    //metodo generico para hacer consultas
    public ResultSet ejecutarProcedimiento(String nombreProcedimiento, Map parametros, boolean respuesta){
        ResultSet resultado = null;
        try{
            CallableStatement procedimiento = conexion.prepareCall(nombreProcedimiento);
            Iterator iterador = parametros.entrySet().iterator();
                while(iterador.hasNext()){
                    Map.Entry e = (Map.Entry)iterador.next();
                    String clase = e.getValue().getClass().toString();
                    int longitud = clase.length();
                    String tipoDato = clase.substring(clase.lastIndexOf(".")+1, longitud);
                    System.out.println("tipoDato = " + tipoDato);
                        if(tipoDato.equals("String")){
                            procedimiento.setString(e.getKey().toString(), e.getValue().toString());
                        } else if(tipoDato.equals("Integer")){
                            procedimiento.setInt(e.getKey().toString(), Integer.parseInt(e.getValue().toString()));
                        } else if(tipoDato.equals("Double")){
                            procedimiento.setDouble(e.getKey().toString(), Double.parseDouble(e.getValue().toString()));
                        } else if (tipoDato.equals("Boolean")){
                            procedimiento.setBoolean(e.getKey().toString(), Boolean.parseBoolean(e.getValue().toString()));
                        }
                }
                
                if(respuesta == true){
                    resultado = procedimiento.executeQuery();
                } else {
                    procedimiento.execute();
                }
            
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al procesar solicitud");
        }
        
        
        return resultado;
    }
}

/*("jdbc:sqlserver://[servidor]:[no.puerto];instanceName=[nombreDeLaInstancia];dataBaseName=[nombreDeLaBaseDeDatos];user=[usuario];password=[password];")*/
