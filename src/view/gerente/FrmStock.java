package view.gerente;

import javax.swing.*;

public class FrmStock extends JFrame {
    private JPanel MenuStockPanel;
    private JPanel MenuNavegation;
    private JButton menuPrincipalButton;
    private JButton facturacionButton;
    private JButton clienteButton;
    private JButton proveedorButton;
    private JTextField textField1; // Nombre
    private JTextField textField2; // Proveedor
    private JTextField textField3; // Precio
    private JTextField textField4; // Cantidad
    private JButton eliminarButton;
    private JButton agregarButton;
    private JButton modificarButton;

    public FrmStock() {
        setTitle("Gestión de Stock");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(MenuStockPanel);

        // Ejemplo básico de acción para el botón Agregar
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String proveedor = textField2.getText().trim();
            String precio = textField3.getText().trim();
            String cantidad = textField4.getText().trim();

            if (nombre.isEmpty() || proveedor.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Producto agregado con éxito!");
            }
        });
    }
}