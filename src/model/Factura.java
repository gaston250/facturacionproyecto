package model;

import java.util.Date;

public class Factura {
    private int id;
    private String dniCliente;
    private String dniEmpleado;
    private Date fecha;
    private double subtotal;
    private double descuento;
    private double total;

    // Constructor vacío
    public Factura() {
    }

    // Constructor completo (con ID y fecha)
    public Factura(int id, String dniCliente, String dniEmpleado, Date fecha, double subtotal, double descuento, double total) {
        this.id = id;
        this.dniCliente = dniCliente;
        this.dniEmpleado = dniEmpleado;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
    }

    // Constructor sin ID (para nuevas inserciones donde la BDD genera la fecha y el ID automáticamente)
    public Factura(String dniCliente, String dniEmpleado, double subtotal, double descuento, double total) {
        this.dniCliente = dniCliente;
        this.dniEmpleado = dniEmpleado;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}