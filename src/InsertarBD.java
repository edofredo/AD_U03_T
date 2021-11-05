/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

/**
 *
 * @author Cristian
 */
public class InsertarBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         //Paso 2: Cargar el driver para las versiones modernas de MYSQL Y Java
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Paso 3: Establecer la conexion con la BD : URL, USUARIO y CONTRASEÑA
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestionempleados2122","root","");
        
        boolean autoCommit = conexion.getAutoCommit();
        System.out.println(autoCommit);
        if(!autoCommit){
            conexion.setAutoCommit(true);
        }
        
        //Paso 4: Preparar la sentencia
        Statement sentencia = conexion.createStatement();
        
        //Paso 5: lanzar la sentencia de modificacion de la BD con executeUpdate
        int filas = 0;
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleados, nombre, apellidos, puesto, salario) " +
                        "VALUES (1, 'Cristian', 'Ade', 'Desarrollador',1750)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleados, nombre, apellidos, puesto, salario) " +
                        "VALUES (2, 'Manuel', 'Martinez', 'Contable',1200)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleados, nombre, apellidos, puesto, salario) " +
                        "VALUES (3, 'Silvia', 'Marzo', 'Desarrollador',1600)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleados, nombre, apellidos, puesto, salario) " +
                        "VALUES (4, 'Miguel', 'Cerezo', 'Analista',1500)"
        );
        filas = filas + sentencia.executeUpdate(
                        "INSERT INTO empleados (codEmpleados, nombre, apellidos, puesto, salario) " +
                        "VALUES (5, 'Sara, 'Toro', 'Gerente',1800)"
        );
          
        
        //Paso 6: Comprobamos cuantas filas se han insertado
        System.out.println("Al realizar la insercion se han insertado "+ filas+ " filas");    
        
        //Paso 7: Liberar los recursos
        sentencia.close();
        conexion.close();
        
    }
    
}
