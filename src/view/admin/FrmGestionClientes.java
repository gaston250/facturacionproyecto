package view.admin;

import javax.swing.*;

public class FrmGestionClientes extends JFrame {
    private JPanel GestionclientesPanel;
    private JPanel menunavegation;
    private JButton menuPrincipalButton;
    private JButton facturacionButton;
    private JButton stockButton;
    private JButton provedorButton;
    private JButton empleadosButton;

    private JTextField textField1; // Nombre
    private JTextField textField2; // Apellido
    private JTextField textField3; // DNI
    private JTextField textField4; // Dirección
    private JTextField textField5; // Mail
    private JTextField textField6; // Teléfono

    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;

    private JScrollBar scrollBar1;
    private JTable table1;

    public FrmGestionClientes() {
        setTitle("Gestión de Clientes (Administrador)");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(GestionclientesPanel);

        // Lógica básica para el botón Agregar cliente
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();
            String dni = textField3.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete Nombre, Apellido y DNI.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Cliente registrado con éxito!");
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

    public JButton getProvedorButton() {
        return provedorButton;
    }

    public JButton getEmpleadosButton() {
        return empleadosButton;
    }
}