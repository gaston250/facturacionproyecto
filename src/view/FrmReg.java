package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmReg extends JFrame {
    private JPanel RegisterPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton registrarmeButton;

    public FrmReg() {
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setContentPane(RegisterPanel);

        registrarmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textField1.getText().trim();
                String password = new String(passwordField1.getPassword()).trim();

                if (usuario.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(FrmReg.this, "Completá todos los campos.");
                    return;
                }

                // Acá después conectamos con tu base de datos para guardar el usuario
                JOptionPane.showMessageDialog(FrmReg.this, "Usuario registrado con éxito!");
                dispose();
            }
        });
    }
}
