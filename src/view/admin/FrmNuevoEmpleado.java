package view.admin;

import javax.swing.*;

public class FrmNuevoEmpleado extends JFrame {
    private JPanel nuevoEmpleadopanel;
    private JButton menuPrincipalButton;
    private JButton facturacionButton;
    private JButton stockButton;

    private JTextField textField1; // Nombre
    private JPasswordField passwordField1; // (O si prefieres usarlo para contraseña o campo adicional)
    private JTextField textField2; // Apellido
    private JTextField textField3; // Dni
    private JTextField textField4; // Dirección
    private JTextField textField5; // Mail / Teléfono

    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton modificarButton;

    private JScrollBar scrollBar1;
    private JTable table1;

    public FrmNuevoEmpleado() {
        setTitle("Gestión de Empleados (Administrador)");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(nuevoEmpleadopanel);

        // Lógica básica para el botón Agregar empleado
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();
            String dni = textField3.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete Nombre, Apellido y DNI.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Empleado registrado con éxito!");
            }
        });
    }

    // Getters para la barra de navegación superior del Administrador
    public JButton getMenuPrincipalButton() {
        return menuPrincipalButton;
    }

    public JButton getFacturacionButton() {
        return facturacionButton;
    }

    public JButton getStockButton() {
        return stockButton;
    }
}