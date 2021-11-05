/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *clase que consulta filas en la tabla empleados
 * @author Cristian
 */
public class ConsultarBD {

    /**
     * unico metodo de la clase que hace todo el trabajo. Es main.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, 
            SQLException{
        //carga del conector para mysql
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        /*establecimiento de la conexion con la BD. 
        *Se pasa por parametros la URL, usuario y contrasena.
        */
        Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost/gestionempleados2122","root","");
        
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
        
        //consulta de todos los empleados cuyo sueldo sea mayor que 1500
        ResultSet resultado = sentencia.executeQuery(
                "SELECT * FROM empleados WHERE salario > 1500"
        );
      
        //recorrido del resultset e impresion por consola de los resultados
        while(resultado.next()){
            System.out.println(resultado.getString("nombre")+"\t\t"+
                    resultado.getString("apellidos")+"\t\t"+                    
                    resultado.getString("puesto")+"\t\t"+
                     resultado.getFloat("salario")+"\n");
        }
        
        //liberacion de los recursos Statement y Connection
        sentencia.close();
        conexion.close();   
    }
    
}
