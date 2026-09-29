import view.FrmLogin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Asegura que la interfaz gráfica corra en el hilo seguro de Swing
        SwingUtilities.invokeLater(() -> {
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
        });
    }
}