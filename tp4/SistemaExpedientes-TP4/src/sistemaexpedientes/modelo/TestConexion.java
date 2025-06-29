/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author GL
 */
public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = ConexionBD.obtenerConexion()) {
            System.out.println("✅ Conexión exitosa");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar: " + e.getMessage());
        }
    }
}
