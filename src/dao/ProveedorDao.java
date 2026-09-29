package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProveedorDao {

    // Método para registrar un nuevo proveedor
    public boolean registrarProveedor(String nombre, String apellido, String dniCuit, String direccion, String mail, String telefono) {
        String sql = "INSERT INTO proveedores (nombre, apellido, dni_cuit, direccion, mail, telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, dniCuit);
            pst.setString(4, direccion);
            pst.setString(5, mail);
            pst.setString(6, telefono);

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar proveedor: " + e.getMessage());
            return false;
        }
    }
}