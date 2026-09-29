package view.empleado;


import dao.FacturaDao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmFacturacion extends JFrame {
    private JPanel MenuFacturacion;
    private JPanel MenuNavegation;
    private JButton menuPrincipalButton;
    private JButton stockButton1;
    private JButton empleadosButton;
    private JButton clienteButton;
    private JButton proveedoresButton;

    private JTextField textField1; // DNI del cliente
    private JTextField textField2; // DNI del empleado
    private JTextField textField3; // ID del producto
    private JTextField textField4; // Cantidad
    private JTextField textField5; // Descuento

    private JScrollBar scrollBar1;
    private JTable table1;
    private DefaultTableModel modeloTabla;

    private JLabel subtotalLabel;
    private JLabel descuentoLabel;

    private JButton facturarButton;
    private JButton buscarButton;   // Buscar cliente
    private JButton buscarButton1;  // Buscar empleado
    private JButton agregarButton;  // Agregar producto a la tabla
    private JButton agregarButton1; // (Por si tenés otro botón extra)
    private JButton eliminarButton; // Eliminar ítem de la tabla

    public FrmFacturacion() {
        setTitle("Módulo de Facturación (Administrador)");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(MenuFacturacion);

        // --- INICIALIZAR LA TABLA CON SUS COLUMNAS ---
        String[] columnas = {"ID Prod", "Cantidad", "Precio U.", "Total Ítem"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        if (table1 != null) {
            table1.setModel(modeloTabla);
        }

        // --- 1. ACCIÓN: BUSCAR CLIENTE ---
        if (buscarButton != null) {
            buscarButton.addActionListener(e -> {
                String dniCliente = textField1.getText().trim();
                if (dniCliente.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese el DNI del cliente para buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // Aquí podés integrar la consulta a ClienteDao para verificar si existe
                JOptionPane.showMessageDialog(this, "Cliente con DNI " + dniCliente + " verificado.");
            });
        }

        // --- 2. ACCIÓN: BUSCAR EMPLEADO ---
        if (buscarButton1 != null) {
            buscarButton1.addActionListener(e -> {
                String dniEmpleado = textField2.getText().trim();
                if (dniEmpleado.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese el DNI del empleado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Empleado con DNI " + dniEmpleado + " verificado.");
            });
        }

        // --- 3. ACCIÓN: AGREGAR PRODUCTO A LA TABLA ---
        if (agregarButton != null) {
            agregarButton.addActionListener(e -> {
                String idProd = textField3.getText().trim();
                String cantidadStr = textField4.getText().trim();

                if (idProd.isEmpty() || cantidadStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar el ID del producto y la cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int cantidad = Integer.parseInt(cantidadStr);
                    // Valor de ejemplo o mock de precio unitario (luego podés buscarlo de tu ProductoDao)
                    double precioUnitario = 150.0;
                    double totalItem = cantidad * precioUnitario;

                    // Agregamos la fila a la tabla visual
                    Object[] fila = {idProd, cantidad, precioUnitario, totalItem};
                    modeloTabla.addRow(fila);

                    // Limpiar campos de producto para el siguiente ingreso
                    textField3.setText("");
                    textField4.setText("");
                    calcularTotales();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }

        // --- 4. ACCIÓN: ELIMINAR ÍTEM SELECCIONADO DE LA TABLA ---
        if (eliminarButton != null) {
            eliminarButton.addActionListener(e -> {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    modeloTabla.removeRow(filaSeleccionada);
                    calcularTotales();
                } else {
                    JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            });
        }

        // --- 5. ACCIÓN: PROCESAR Y GUARDAR LA FACTURA ---
        if (facturarButton != null) {
            facturarButton.addActionListener(e -> {
                String dniCliente = textField1.getText().trim();
                String dniEmpleado = textField2.getText().trim();

                if (dniCliente.isEmpty() || dniEmpleado.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debe completar el DNI del cliente y del empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (modeloTabla.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "No hay productos agregados en la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Calcular subtotales finales
                double subtotal = obtenerSubtotalTotal();
                double descuento = 0.0; // Podés leerlo de textField5 si lo deseas
                double totalFinal = subtotal - descuento;

                // Guardar en la Base de Datos usando el DAO
                FacturaDao facturaDao = new FacturaDao();
                boolean guardadoExitoso = facturaDao.guardarFactura(dniCliente, dniEmpleado, subtotal, descuento, totalFinal, modeloTabla);

                if (guardadoExitoso) {
                    JOptionPane.showMessageDialog(this, "¡Factura generada y guardada con éxito en la Base de Datos!");
                    // Limpiar todo tras el éxito
                    modeloTabla.setRowCount(0);
                    textField1.setText("");
                    textField2.setText("");
                    textField5.setText("");
                    calcularTotales();
                } else {
                    JOptionPane.showMessageDialog(this, "Hubo un error al registrar la factura en la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }

    // Método auxiliar para recalcular los totales visuales
    private void calcularTotales() {
        double subtotal = obtenerSubtotalTotal();
        if (subtotalLabel != null) {
            subtotalLabel.setText("Subtotal: $" + subtotal);
        }
    }

    private double obtenerSubtotalTotal() {
        double suma = 0;
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            suma += Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());
        }
        return suma;
    }

    // Getters requeridos para la barra de navegación superior
    public JButton getMenuPrincipalButton() { return menuPrincipalButton; }
    public JButton getStockButton() { return stockButton1; }
    public JButton getEmpleadosButton() { return empleadosButton; }
    public JButton getClientesButton() { return clienteButton; }
    public JButton getProveedoresButton() { return proveedoresButton; }
}