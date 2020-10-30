
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 // clase de conexion donde se establece las credenciales de la base de datos y el driver de conexion
public class Conexion {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "ProyectoVentas";
    public static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    public Connection connection;
    
    // Constructor
    public Conexion() {
        try {
            Class.forName(CLASSNAME);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Error de clase: " + e.toString());
        } catch (SQLException e) {
            System.err.println("Error de sql: " + e.toString());
        }
    }

    
}
