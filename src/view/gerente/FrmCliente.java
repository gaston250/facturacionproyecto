package view.gerente;

import javax.swing.*;

public class FrmCliente extends JFrame {
    private JPanel ClientePanel;
    private JPanel MenuNavegation;
    private JButton menuPrincipalButton;
    private JButton stockButton;
    private JButton provedoresButton;
    private JButton facturacionButton;
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

    public FrmCliente() {
        setTitle("Gestión de Clientes");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(ClientePanel);

        // Lógica básica para el botón Agregar
        agregarButton.addActionListener(e -> {
            String nombre = textField1.getText().trim();
            String apellido = textField2.getText().trim();
            String dni = textField3.getText().trim();

            if (nombre.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete al menos el Nombre y el DNI.");
            } else {
                JOptionPane.showMessageDialog(this, "¡Cliente registrado con éxito!");
            }
        });
    }

    // Getters por si necesitas acceder a los botones de navegación desde otra clase principal
    public JButton getMenuPrincipalButton() {
        return menuPrincipalButton;
    }

    public JButton getStockButton() {
        return stockButton;
    }

    public JButton getProvedoresButton() {
        return provedoresButton;
    }

    public JButton getFacturacionButton() {
        return facturacionButton;
    }
}