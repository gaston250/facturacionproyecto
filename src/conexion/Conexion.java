package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_facturacion?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    // Método principal que realiza la conexión real
    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("¡Conexión exitosa a la base de datos!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el Driver de MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión a la Base de Datos: " + e.getMessage());
        }
        return conexion;
    }

    // Método alternativo para que funcione si tu DAO llama a getConnection()
    public static Connection getConnection() {
        return conectar();
    }
}