/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

/**
 * clase que inserta filas en la tabla empleados
 * @author Cristian
 */
public class InsertarBD {

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
        
        /*sentencia sql que inserta filas y va sumando a la variable filas cada
        * fila insertada exitosamente
        */ 
        int filas = 0;
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleado, nombre, apellidos, "
                                + "puesto, salario) VALUES (1, 'Cristian', 'Ade', "
                                + "'Desarrollador',1750)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleado, nombre, apellidos, "
                                + "puesto, salario) VALUES (2, 'Manuel', 'Martinez', "
                                + "'Contable',1200)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleado, nombre, apellidos, "
                                + "puesto, salario) VALUES (3, 'Silvia', 'Marzo', "
                                + "'Desarrollador',1600)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleado, nombre, apellidos, "
                                + "puesto, salario) VALUES (4, 'Miguel', 'Cerezo', "
                                + "'Analista',1500)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleado, nombre, apellidos, "
                                + "puesto, salario) VALUES (5, 'Sara', 'Toro', "
                                + "'Gerente',1800)"
        );
          
        //Impresion por consola del numero de filas insertadas
        System.out.println("Al realizar la insercion se han insertado "+ filas+ 
                " filas");    
        
        //liberacion de los recursos Statement y Connection
        sentencia.close();
        conexion.close();
        
    }
    
}
