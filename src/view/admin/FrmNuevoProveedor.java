package view.admin;

import javax.swing.*;

public class FrmNuevoProveedor extends JFrame {
    private JPanel Gestionproovedorpanel;
    private JButton menuPrincipalButton;
    private JButton facturacionButton;
    private JButton stockButton;
    private JButton empleadosButton;
    private JButton clientesButton;
    private JPanel menunavegation;

    private JTextField textField1; // Nombre
    private JTextField textField2; // Apellido / Razón social
    private JTextField textField3; // Dni / CUIT
    private JTextField textField4; // Dirección
    private JTextField textField5; // Mail
    private JTextField textField6; // Teléfono

    private JScrollBar scrollBar1;
    private JTable table1;

    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;

    public FrmNuevoProveedor() {
        setTitle("Gestión de Proveedores (Administrador)");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(Gestionproovedorpanel);

        // Lógica básica para el botón Agregar proveedor
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String dniCuit = textField3.getText().trim();

            if (nombre.isEmpty() || dniCuit.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete al menos el Nombre y el DNI/CUIT.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Proveedor registrado con éxito!");
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

    public JButton getEmpleadosButton() {
        return empleadosButton;
    }

    public JButton getClientesButton() {
        return clientesButton;
    }
}