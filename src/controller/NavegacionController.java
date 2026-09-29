package controller;

import javax.swing.*;
import view.admin.*;
import view.empleado.*;
import view.gerente.*;

public class NavegacionController {

    // Método genérico para cambiar de una ventana a otra
    private static void cambiarVentana(JFrame ventanaActual, JFrame nuevaVentana) {
        if (ventanaActual != null) {
            ventanaActual.dispose(); // Cierra la ventana actual
        }
        nuevaVentana.setVisible(true); // Muestra la nueva ventana
    }

    // Métodos generales de navegación
    public static void irAMenuPrincipal(JFrame actual, JFrame nuevoMenu) {
        cambiarVentana(actual, nuevoMenu);
    }
}