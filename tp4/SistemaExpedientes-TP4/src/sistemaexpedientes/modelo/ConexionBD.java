/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase encargada de proporcionar la conexión a la base de datos MySQL
 * para el sistema de gestión de expedientes municipales.
 * 
 * Esta clase centraliza los datos de conexión (URL, usuario, contraseña)
 * para facilitar futuros cambios de configuración.
 * 
 * Base de datos: sistema_expedientes
 * Usuario MySQL: root
 * Contraseña: Seminario2025
 * 
 * Autor: GL
 */
public class ConexionBD {
    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_expedientes";
    private static final String USUARIO = "root"; 
    private static final String CONTRASENA = "Seminario2025"; 

    /**
     * Obtiene una conexión activa a la base de datos.
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}