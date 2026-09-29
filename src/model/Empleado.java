package model;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String mail;
    private String telefono;
    private String contrasena;
    private String rol; // Nuevo campo para diferenciar Admin de Empleado

    public Empleado() {}

    public Empleado(int idEmpleado, String nombre, String apellido, String dni, String direccion, String mail, String telefono, String contrasena, String rol) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}