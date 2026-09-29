package dao;

import conexion.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacturaDao {

    // Método para registrar una factura completa con sus detalles
    public boolean guardarFactura(String dniCliente, String dniEmpleado, double subtotal, double descuento, double total, DefaultTableModel modeloTabla) {
        String sqlFactura = "INSERT INTO facturas (dni_cliente, dni_empleado, subtotal, descuento, total) VALUES (?, ?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_factura (id_factura, id_producto, cantidad, precio_unitario, total_item) VALUES (?, ?, ?, ?, ?)";

        Connection cn = null;
        try {
            cn = Conexion.conectar();
            cn.setAutoCommit(false); // Iniciamos transacción para asegurar la integridad de los datos

            // 1. Guardar la Factura principal y obtener el ID generado
            PreparedStatement pstFactura = cn.prepareStatement(sqlFactura, Statement.RETURN_GENERATED_KEYS);
            pstFactura.setString(1, dniCliente);
            pstFactura.setString(2, dniEmpleado);
            pstFactura.setDouble(3, subtotal);
            pstFactura.setDouble(4, descuento);
            pstFactura.setDouble(5, total);
            pstFactura.executeUpdate();

            ResultSet rsId = pstFactura.getGeneratedKeys();
            int idFactura = 0;
            if (rsId.next()) {
                idFactura = rsId.getInt(1);
            } else {
                cn.rollback();
                return false;
            }

            // 2. Guardar cada ítem del detalle de la tabla
            PreparedStatement pstDetalle = cn.prepareStatement(sqlDetalle);
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                // Asumiendo el orden de las columnas en tu JTable: [ID Prod, Cantidad, Precio, Total]
                int idProducto = Integer.parseInt(modeloTabla.getValueAt(i, 0).toString());
                int cantidad = Integer.parseInt(modeloTabla.getValueAt(i, 1).toString());
                double precioUnitario = Double.parseDouble(modeloTabla.getValueAt(i, 2).toString());
                double totalItem = Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());

                pstDetalle.setInt(1, idFactura);
                pstDetalle.setInt(2, idProducto);
                pstDetalle.setInt(3, cantidad);
                pstDetalle.setDouble(4, precioUnitario);
                pstDetalle.setDouble(5, totalItem);
                pstDetalle.executeUpdate();
            }

            cn.commit(); // Confirmamos la transacción
            return true;

        } catch (SQLException e) {
            System.out.println("Error al procesar la factura: " + e.getMessage());
            if (cn != null) {
                try {
                    cn.rollback(); // Si algo falla, revertimos los cambios
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}