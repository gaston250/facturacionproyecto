package model;

public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String apellido;
    private String dniCuit;
    private String direccion;
    private String mail;
    private String telefono;

    public Proveedor() {}

    public Proveedor(int idProveedor, String nombre, String apellido, String dniCuit, String direccion, String mail, String telefono) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniCuit = dniCuit;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDniCuit() { return dniCuit; }
    public void setDniCuit(String dniCuit) { this.dniCuit = dniCuit; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}