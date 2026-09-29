package view.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenuPrincipal extends JFrame {
    private JPanel menuprincipalPanel;
    private JPanel panelBotonera;
    private JButton menuPrincipalButton;
    private JButton clientesButton;
    private JButton empleadosButton;
    private JButton stockButton;
    private JButton facturacionButton;
    private JPanel cardPanel;

    private CardLayout cardLayout;

    public FrmMenuPrincipal() {
        setTitle("Sistema de Facturación - Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setContentPane(menuprincipalPanel);

        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Paneles de ejemplo para cada sección (puedes reemplazar después por tus formularios visuales)
        JPanel panelInicio = new JPanel();
        panelInicio.add(new JLabel("Bienvenido al Menú Principal"));

        JPanel panelClientes = new JPanel();
        panelClientes.add(new JLabel("Gestión de Clientes"));

        JPanel panelEmpleados = new JPanel();
        panelEmpleados.add(new JLabel("Gestión de Empleados"));

        JPanel panelStock = new JPanel();
        panelStock.add(new JLabel("Control de Stock"));

        JPanel panelFacturacion = new JPanel();
        panelFacturacion.add(new JLabel("Módulo de Facturación"));

        // Agregamos las vistas al CardPanel con un identificador único
        cardPanel.add(panelInicio, "INICIO");
        cardPanel.add(panelClientes, "CLIENTES");
        cardPanel.add(panelEmpleados, "EMPLEADOS");
        cardPanel.add(panelStock, "STOCK");
        cardPanel.add(panelFacturacion, "FACTURACION");

        // Eventos de los botones de la botonera superior
        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "INICIO");
            }
        });

        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "CLIENTES");
            }
        });

        empleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "EMPLEADOS");
            }
        });

        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "STOCK");
            }
        });

        facturacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "FACTURACION");
            }
        });
    }
}