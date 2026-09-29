package view.gerente;

import javax.swing.*;

public class FrmProveedor extends JFrame {
    private JPanel ProveedorPanel;
    private JPanel MenuNavegation;
    private JButton menuPrincipalButton;
    private JButton facturacionButton;
    private JButton stockButton;
    private JButton clienteButton;
    private JTextField textField1; // Nombre
    private JTextField textField2; // Apellido
    private JTextField textField3; // Dni
    private JTextField textField4; // Dirección
    private JTextField textField5; // Mail
    private JTextField textField6; // Teléfono
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton agregarButton;
    private JScrollBar scrollBar1;
    private JTable table1;

    public FrmProveedor() {
        setTitle("Gestión de Proveedores");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(ProveedorPanel);

        // Lógica inicial para los botones de acción
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();
            String dni = textField3.getText().trim();
            String direccion = textField4.getText().trim();
            String mail = textField5.getText().trim();
            String telefono = textField6.getText().trim();

            if (nombre.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete al menos el Nombre y el DNI.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Proveedor registrado correctamente!");
            }
        });
    }
}