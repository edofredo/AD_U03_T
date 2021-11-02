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
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","");
        
        //Paso 4: Preparar la sentencia
        Statement sentencia = conexion.createStatement();
        
        //Paso 5: lanzar la sentencia de modificacion de la BD con executeUpdate
        int filas = 0;
        filas = filas + sentencia.executeUpdate("INSERT INTO Articulos (codArticulo, nombre, precio, descripcion) VALUES (1, 'Camiseta', 5, 'Camiseta de diferentes colores')");
        filas = filas + sentencia.executeUpdate("INSERT INTO Articulos (codArticulo, nombre, precio, descripcion) VALUES (2, 'Camisa', 15, 'Camisa de fiesta')");
        filas = filas + sentencia.executeUpdate("INSERT INTO Articulos (codArticulo, nombre, precio, descripcion) VALUES (3, 'Pantalon', 20, 'Jeans')");
        filas = filas + sentencia.executeUpdate("INSERT INTO Articulos (codArticulo, nombre, precio, descripcion) VALUES (4, 'Abrigo', 60, 'Abrigo contra el frio')");
          
        
        //Paso 6: Comprobamos cuantas filas se han insertado
        System.out.println("Al realizar la insercion se han insertado "+ filas+ " filas");    
        
        //Paso 7: Liberar los recursos
        sentencia.close();
        conexion.close();
        
    }
    
}
