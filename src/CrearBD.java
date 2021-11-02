
import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian
 */
public class CrearBD {

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
        sentencia.executeUpdate("CREATE TABLE Articulos (\n" +
                                "codArticulo INT PRIMARY KEY,\n" +
                                "nombre VARCHAR(20),\n" +
                                "precio FLOAT (5,2),\n" +
                                "descripcion VARCHAR(150));");
        
        //Paso 6: Liberar los recursos
        sentencia.close();
        conexion.close();
    }   
}
