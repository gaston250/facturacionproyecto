package dao;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    // 1. Registrar un nuevo cliente
    public boolean insertarCliente(String nombre, String apellido, String dni, String direccion, String mail, String telefono) {
        String sql = "INSERT INTO clientes (nombre, apellido, dni, direccion, mail, telefono) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.setString(4, direccion);
            ps.setString(5, mail);
            ps.setString(6, telefono);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    // 2. Obtener la lista de todos los clientes para mostrar en la JTable
    public List<Object[]> listarClientes() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT id_cliente, nombre, apellido, dni, direccion, mail, telefono FROM clientes";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id_cliente");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getString("dni");
                fila[4] = rs.getString("direccion");
                fila[5] = rs.getString("mail");
                fila[6] = rs.getString("telefono");
                lista.add(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    // 3. Modificar un cliente existente por su ID
    public boolean modificarCliente(int idCliente, String nombre, String apellido, String dni, String direccion, String mail, String telefono) {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, dni=?, direccion=?, mail=?, telefono=? WHERE id_cliente=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.setString(4, direccion);
            ps.setString(5, mail);
            ps.setString(6, telefono);
            ps.setInt(7, idCliente);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
            return false;
        }
    }

    // 4. Eliminar un cliente por su ID
    public boolean eliminarCliente(int idCliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente=?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}