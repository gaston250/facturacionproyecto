package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDao {

    // Método para registrar un nuevo producto en el inventario
    public boolean registrarProducto(String codigo, String descripcion, double precioCosto, double precioVenta, int stockActual, int idProveedor) {
        String sql = "INSERT INTO productos (codigo, descripcion, precio_costo, precio_venta, stock_actual, id_proveedor) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, codigo);
            pst.setString(2, descripcion);
            pst.setDouble(3, precioCosto);
            pst.setDouble(4, precioVenta);
            pst.setInt(5, stockActual);
            pst.setInt(6, idProveedor);

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar el producto: " + e.getMessage());
            return false;
        }
    }
}