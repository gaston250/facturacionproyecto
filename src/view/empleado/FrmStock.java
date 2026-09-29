package view.empleado;

import javax.swing.*;

public class FrmStock extends JFrame {
    private JPanel MenuStockPanel;
    private JPanel MenuNavegation;
    private JButton menuPrincipalButton;
    private JButton facturacionButton;
    private JButton clienteButton;
    private JTextField textField1; // Nombre del producto
    private JTextField textField2; // Proveedor
    private JTextField textField3; // Precio
    private JTextField textField4; // Cantidad
    private JButton agergarButton;
    private JButton modificarButton;
    private JButton eliminarButton;

    public FrmStock() {
        setTitle("Gestión de Stock (Empleado)");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(MenuStockPanel);

        // Lógica básica para el botón Agregar
        agergarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String precio = textField3.getText().trim();

            if (nombre.isEmpty() || precio.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete al menos el Nombre y el Precio.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Producto agregado al stock con éxito!");
            }
        });
    }

    // Getters para la barra de navegación superior
    public JButton getMenuPrincipalButton() {
        return menuPrincipalButton;
    }

    public JButton getFacturacionButton() {
        return facturacionButton;
    }

    public JButton getClienteButton() {
        return clienteButton;
    }
}