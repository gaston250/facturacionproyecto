package model;

public class DetalleFactura {
    private int id;
    private int idFactura;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;
    private double totalItem;

    // Constructor vacío
    public DetalleFactura() {
    }

    // Constructor con todos los campos
    public DetalleFactura(int id, int idFactura, int idProducto, int cantidad, double precioUnitario, double totalItem) {
        this.id = id;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalItem = totalItem;
    }

    // Constructor sin ID (útil para cuando vas a insertar un nuevo detalle)
    public DetalleFactura(int idFactura, int idProducto, int cantidad, double precioUnitario, double totalItem) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalItem = totalItem;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
    }
}