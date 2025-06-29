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
 * Representa a un usuario del sistema. 
 * Puede ser alguien de un sector (Comercio, Obras, etc.) o un administrador.
 */
public class Usuario {

    private int idUsuario;
    private String nombreCompleto;
    private String nombreUsuario;
    private String contrasena;
    private String rol; // Ej: "Administrador", "Comercio", "Obras Privadas"
    private Sector sector;
    private boolean activo;

    // Constructor por defecto
    public Usuario() {
    }
    // Constructor completo
    public Usuario(int idUsuario, String nombreCompleto, String nombreUsuario, String contrasena,
                   String rol, Sector sector, boolean activo) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.sector = sector;
        this.activo = activo;
    }

    // Getters y setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    // Método para validar permisos 
    public boolean tienePermiso(String accion) {
        
        return true;
    }

    public boolean esAdministrador() {
        return rol != null && rol.equalsIgnoreCase("Administrador");
    }
}

