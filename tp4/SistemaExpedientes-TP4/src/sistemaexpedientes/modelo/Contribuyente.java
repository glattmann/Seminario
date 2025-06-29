/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

/**
 *
 * @author GL
 */
/**
 * Esta clase representa a un Contribuyente que puede ser una persona física o jurídica.
 * Tiene datos personales y de contacto, y se usa en los expedientes.
 */
public class Contribuyente {
    
    // Datos del contribuyente (todos privados para encapsular)
    private int idContribuyente;
    private String nombre;
    private String apellido;
    private String razonSocial;
    private String tipoContribuyente; // Puede ser "Física" o "Jurídica"
    private String cuit;
    private String dni;
    private String direccion;
    private String correo;
    private String telefono;

    // Constructor completo
    public Contribuyente(int idContribuyente, String nombre, String apellido, String razonSocial,
                         String tipoContribuyente, String cuit,String dni, String direccion,
                         String correo, String telefono) {
        this.idContribuyente = idContribuyente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.razonSocial = razonSocial;
        this.tipoContribuyente = tipoContribuyente;
        this.cuit = cuit;
        this.dni = dni;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Constructor por defecto
    public Contribuyente() {
    }

    // Getters y setters
    public int getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(int idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoContribuyente() {
        return tipoContribuyente;
    }

    public void setTipoContribuyente(String tipoContribuyente) {
        this.tipoContribuyente = tipoContribuyente;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método para obtener nombre completo
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Método para saber si es persona jurídica
    public boolean esJuridico() {
        return tipoContribuyente != null && tipoContribuyente.equalsIgnoreCase("Jurídica");
    }
    
    @Override
    public String toString() {
        if ("Jurídico".equalsIgnoreCase(tipoContribuyente)) {
            return cuit + " - " + razonSocial;
        } else {
            return cuit + " - " + apellido + ", " + nombre;
        }
    }

}


