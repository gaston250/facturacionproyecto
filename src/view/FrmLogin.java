package view;

import controller.NavegacionController;
import dao.UsuarioDao;
import model.Usuario;
import view.admin.FrmMenuPrincipal;

import javax.swing.*;

public class FrmLogin extends JFrame {

    private JPanel loginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JButton registrarseButton;

    public FrmLogin() {
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(loginPanel);

        ingresarButton.addActionListener(e -> {
            String usuarioStr = textField1.getText().trim();
            String passwordStr = new String(passwordField1.getPassword()).trim();

            if (usuarioStr.isEmpty() || passwordStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validamos contra la base de datos usando el DAO
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuarioValidado = usuarioDao.login(usuarioStr, passwordStr);

            if (usuarioValidado != null) {
                JOptionPane.showMessageDialog(this, "¡Bienvenido, " + usuarioValidado.getUsuario() + "! Rol: " + usuarioValidado.getRol());

                // Abrimos el menú principal
                FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal();
                NavegacionController.irAMenuPrincipal(this, menuPrincipal);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registrarseButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Acá abrirías la ventana de registro.");
        });
    }
}