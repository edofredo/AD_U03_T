
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * clase que crea la tabla empleados en la BD gestionempleados2122
 * @author Cristian
 */
public class CrearBD {

    /**
     * unico metodo de la clase que hace todo el trabajo. Es main.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, 
            SQLException {
        //carga del conector para mysql
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        /*establecimiento de la conexion con la BD. 
        *Se pasa por parametros la URL, usuario y contrasena.
        */
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost"
                + "/gestionempleados2122","root","");
        
        //comprobacion de que las transacciones se encuentran en modo autocommit
        boolean autoCommit = conexion.getAutoCommit();
        System.out.println(autoCommit);
        //en caso de que no este en autocommit, se establece a autocommit
        if(!autoCommit){
            conexion.setAutoCommit(true);
        }
                
        /*creacion de un objeto Statement sobre la conexion. Este objeto permitira
        * la creacion y ejecucion de las sentencias sql
        */
        Statement sentencia = conexion.createStatement();
        
        //sentencia sql de creacion de tabla      
        sentencia.executeUpdate("CREATE TABLE empleados (\n" +
                                "codEmpleado INT PRIMARY KEY,\n" +
                                "nombre VARCHAR(60),\n" +
                                "apellidos VARCHAR(120),\n" +
                                "puesto VARCHAR(50),\n" +
                                "salario FLOAT (6,2));");
        
        
        //liberacion de los recursos Statement y Connection
        sentencia.close();
        conexion.close();
    }   
}
