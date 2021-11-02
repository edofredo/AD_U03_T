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
public class ConsultarBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        //Paso 2: Cargar el driver para las versiones modernas de MYSQL Y Java
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Paso 3: Establecer la conexion con la BD : URL, USUARIO y CONTRASEÑA
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","");
        
        //Paso 4: Preparar la sentencia
        Statement sentencia = conexion.createStatement();
        
        //Paso 5: Lanzar una consulta SQL con ExecuteQuery
        ResultSet resultado = sentencia.executeQuery("SELECT * FROM articulos");
      
        //Paso 6: recorremos la colección para visualizar cada fila
        //Hacemos un bucle mientras que haya registros y sacamos los datos por posicion de columna
        /*while(resultado.next()){
            System.out.println(resultado.getInt(1)+"\t\t"+
                    resultado.getString(2)+"\t\t"+
                    resultado.getFloat(3)+"\t\t"+                    
                    resultado.getString(4)+"\n");
            
        }*/
        //Hacemos un bucle mientras que haya registros y sacamos los datos por nombre de columna
        while(resultado.next()){
            System.out.println(resultado.getInt("CodArticulo")+"\t\t"+
                    resultado.getString("nombre")+"\t\t"+
                    resultado.getFloat("precio")+"\t\t"+                    
                    resultado.getString("descripcion")+"\n");
        }
        
        //Paso 7: Liberar los recursos
        sentencia.close();
        conexion.close();   
    }
    
}
