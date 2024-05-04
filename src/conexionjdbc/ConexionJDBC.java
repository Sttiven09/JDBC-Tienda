/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionjdbc;

/**
 *
 * @author sttiven
 */

//importamos libreria sql
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     String usuario = "root";
     String password = "";
     //puerto utilizado por xamp
     String url = "jdbc:mysql://localhost:3306/pruebatienda";
     
     Connection conexion;
     Statement statement; //ejecutar sentencias sql
     ResultSet resultado; //referencias a tablas
         
//controlar excepciones 
        try {
            //instanciar driver mysql >> Por nombre
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
                       
            statement.executeUpdate("INSERT INTO USUARIO(id, nombre, correoElectronico,contraseña) VALUES ('1','Pedro Perez','correo@ejemplo.com','1234')"); //insertar datos
            //statement.executeUpdate("DELETE FROM USUARIO WHERE id='4'");//eliminar Datos
            //statement.executeUpdate("UPDATE USUARIO SET nombre='Pedro Pac', descripcion='Telefono2' WHERE id='1'");//Actualizar Datos
            System.out.println("Informacion relacionada con Usuarios");
            resultado = statement.executeQuery("select * from Usuario"); //mostrar datos
            resultado.next();
            
            do{
                System.out.println(resultado.getInt("id")+ ": "+ resultado.getString("nombre") + ": "+ resultado.getString("correoElectronico")+ ": "+ resultado.getString("contraseña"));
            }while(resultado.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            //statement.executeUpdate("INSERT INTO PRODUCTO(id, nombre, descripcion, cantidad, precio) VALUES ('1','Camioneta','Land Rover','1','180000000')"); //insertar datos
            //statement.executeUpdate("DELETE FROM PRODUCTO WHERE id='4'");//eliminar Datos
            //statement.executeUpdate("UPDATE PRODUCTO SET nombre='Camioneta' WHERE id='3'");//Actualizar Datos
            System.out.println("Informacion relacionada con Productos");
            resultado = statement.executeQuery("select * from producto"); //mostrar datos
            resultado.next();
            
           do{
                System.out.println(resultado.getInt("id")+ ": "+ resultado.getString("nombre") + ": "+ resultado.getString("descripcion")+ ": "+ resultado.getInt("cantidad")+ ": "+ resultado.getInt("precio"));
            }while(resultado.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
                       
            //statement.executeUpdate("INSERT INTO CATEGORIA(id, nombre, descripcion) VALUES ('1','Camioneta','Land Rover')"); //insertar datos
            //statement.executeUpdate("DELETE FROM CATEGORIA WHERE id='4'");//eliminar Datos
            //statement.executeUpdate("UPDATE CATEGORIA SET nombre='Tecnologia', descripcion='Telefono2' WHERE id='1'");//Actualizar Datos
            System.out.println("Informacion relacionada con Categoria");
            resultado = statement.executeQuery("select * from Categoria"); //mostrar datos
            resultado.next();
            
            do{
                System.out.println(resultado.getInt("id")+ ": "+ resultado.getString("nombre") + ": "+ resultado.getString("descripcion"));
            }while(resultado.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
