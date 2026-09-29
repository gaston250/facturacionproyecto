package view.admin;

import javax.swing.*;

public class Fmrstock extends JFrame {
    private JPanel MenuStockPanel;
    private JPanel MenuNavegation;
    private JButton menuPrincipalButton;
    private JButton facturacionButton;
    private JButton proveedoresButton;
    private JButton clientesButton;
    private JButton empleadosButton;

    private JTextField textField1; // Nombre
    private JTextField textField2; // Proveedor
    private JTextField textField3; // Precio
    private JTextField textField4; // Cantidad

    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;

    public Fmrstock() {
        setTitle("Gestión de Stock (Administrador)");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(MenuStockPanel);

        // Lógica básica para el botón Agregar
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String precio = textField3.getText().trim();

            if (nombre.isEmpty() || precio.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete al menos el Nombre y el Precio.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Producto de stock registrado con éxito!");
            }
        });
    }

    // Getters para conectar la navegación superior del Administrador
    public JButton getMenuPrincipalButton() {
        return menuPrincipalButton;
    }

    public JButton getFacturacionButton() {
        return facturacionButton;
    }

    public JButton getProveedoresButton() {
        return proveedoresButton;
    }

    public JButton getClientesButton() {
        return clientesButton;
    }

    public JButton getEmpleadosButton() {
        return empleadosButton;
    }
}