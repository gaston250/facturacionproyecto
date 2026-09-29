package view.empleado;

import javax.swing.*;

public class FmrGestionClientes extends JFrame {
    private JPanel MenuclientesPanel;
    private JButton menuPrincipalButton;
    private JButton stockButton;
    private JButton facturacionButton;
    private JPanel MenuNavegation;
    private JTextField textField1; // Nombre
    private JTextField textField2; // Apellido
    private JTextField textField3; // Dni
    private JTextField textField4; // Dirección
    private JTextField textField5; // Mail
    private JTextField textField6; // Teléfono
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JScrollBar scrollBar1;
    private JTable table1;

    public FmrGestionClientes() {
        setTitle("Gestión de Clientes (Empleado)");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(MenuclientesPanel);

        // Lógica básica para el botón Agregar
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String dni = textField3.getText().trim();

            if (nombre.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete al menos el Nombre y el DNI.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Cliente registrado con éxito!");
            }
        });
    }

    // Getters para la navegación entre menús
    public JButton getMenuPrincipalButton() {
        return menuPrincipalButton;
    }

    public JButton getStockButton() {
        return stockButton;
    }

    public JButton getFacturacionButton() {
        return facturacionButton;
    }
}