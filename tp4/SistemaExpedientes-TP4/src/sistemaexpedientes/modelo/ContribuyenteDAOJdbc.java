/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) para operaciones relacionadas con la tabla "contribuyente".
 * Permite realizar operaciones CRUD: Obtener, Guardar y Modificar contribuyentes
 * en la base de datos MySQL del sistema de expedientes.
 * 
 * Autor: GL
 */
public class ContribuyenteDAOJdbc {
    
    /**
     * Obtiene todos los contribuyentes almacenados en la base de datos.
     */

    public static List<Contribuyente> obtenerTodos() {
        List<Contribuyente> lista = new ArrayList<>();

        String sql = "SELECT * FROM contribuyente";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contribuyente c = new Contribuyente();
                c.setIdContribuyente(rs.getInt("idContribuyente"));
                c.setTipoContribuyente(rs.getString("tipoContribuyente"));
                c.setDni(rs.getString("dni"));
                c.setCuit(rs.getString("cuit"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setRazonSocial(rs.getString("razonSocial"));
                c.setDireccion(rs.getString("domicilio"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correoElectronico"));

                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    public static void guardar(Contribuyente c) {
        // Consulta SQL para insertar un nuevo contribuyente
        String sql = "INSERT INTO contribuyente (tipoContribuyente, dni, cuit, nombre, apellido, razonSocial, domicilio, telefono, correoElectronico) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            // Establecer conexión con la base de datos
            Connection conn = ConexionBD.obtenerConexion();

            // Preparar la sentencia SQL para evitar inyecciones y permitir valores dinámicos
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Asignar valores desde el objeto Contribuyente a cada parámetro del SQL
            stmt.setString(1, c.getTipoContribuyente());
            stmt.setString(2, c.getDni());
            stmt.setString(3, c.getCuit());
            stmt.setString(4, c.getNombre());
            stmt.setString(5, c.getApellido());
            stmt.setString(6, c.getRazonSocial());
            stmt.setString(7, c.getDireccion());
            stmt.setString(8, c.getTelefono());
            stmt.setString(9, c.getCorreo());

            // Ejecutar la sentencia de inserción
            stmt.executeUpdate();
            System.out.println("✅ Contribuyente guardado en la base de datos.");

        } catch (Exception e) {
            // Mostrar error si ocurre algún problema al insertar
            System.err.println("❌ Error al guardar contribuyente: " + e.getMessage());
        }
    }
    public static void modificar(Contribuyente c) {
        // Consulta SQL para modificar los datos de un contribuyente identificado por CUIT
        String sql = "UPDATE contribuyente SET tipoContribuyente = ?, dni = ?, nombre = ?, apellido = ?, " +
                     "razonSocial = ?, domicilio = ?, telefono = ?, correoElectronico = ? WHERE cuit = ?";

        try (
            // Establecer conexión con la base de datos
            Connection conn = ConexionBD.obtenerConexion();

            // Preparar la sentencia SQL con parámetros seguros
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Cargar los valores a modificar
            stmt.setString(1, c.getTipoContribuyente());
            stmt.setString(2, c.getDni());
            stmt.setString(3, c.getNombre());
            stmt.setString(4, c.getApellido());
            stmt.setString(5, c.getRazonSocial());
            stmt.setString(6, c.getDireccion());
            stmt.setString(7, c.getTelefono());
            stmt.setString(8, c.getCorreo());
            stmt.setString(9, c.getCuit()); 

            // Ejecutar la modificación
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("✏️ Contribuyente modificado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el contribuyente para modificar.");
            }

        } catch (Exception e) {
            System.err.println("❌ Error al modificar contribuyente: " + e.getMessage());
        }
    }


}
