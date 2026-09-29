package dao;

import conexion.Conexion;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    // Creamos el método login que recibe el usuario y la contraseña
    public Usuario login(String user, String pass) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario; // <--- ¡Esto era lo que faltaba para devolver el resultado!
    }
}