/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import sistemaexpedientes.modelo.Contribuyente;
import sistemaexpedientes.modelo.Expediente;
import sistemaexpedientes.modelo.TipoTramite;
import sistemaexpedientes.modelo.Rubro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) para la entidad Expediente.
 * Permite acceder y manipular los expedientes almacenados en la base de datos MySQL.
 * Incluye operaciones para consultar, guardar y contar expedientes.
 * 
 * Autor: GL
 */
public class ExpedienteDAOJdbc {

    /**
     * Devuelve todos los expedientes de la base de datos
     */
    public static List<Expediente> obtenerTodos() {
        List<Expediente> lista = new ArrayList<>();

        String sql = "SELECT e.idExpediente, e.numero, e.letra, e.anio, e.fechaHoraIngreso, e.estado,e.observaciones, " +
                     "t.idTipoTramite, t.nombre AS nombreTramite, " +
                     "r.idRubro, r.nombre AS nombreRubro, r.esDeAltoRiesgo," +
                     "c.cuit, c.nombre, c.apellido, c.tipoContribuyente, c.dni, c.razonSocial, c.domicilio, c.telefono, c.correoElectronico " +
                     "FROM expediente e " +
                     "JOIN tipotramite t ON e.idTipoTramite = t.idTipoTramite " +
                     "JOIN rubro r ON e.idRubro = r.idRubro " +
                     "JOIN contribuyente c ON e.idContribuyente = c.idContribuyente";

        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                // Armar objeto contribuyente
                Contribuyente c = new Contribuyente();
                c.setCuit(rs.getString("cuit"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setTipoContribuyente(rs.getString("tipoContribuyente"));
                c.setDni(rs.getString("dni"));
                c.setRazonSocial(rs.getString("razonSocial"));
                c.setDireccion(rs.getString("domicilio"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correoElectronico"));

                // Tipo de trámite
                TipoTramite tipo = new TipoTramite();
                tipo.setIdTipoTramite(rs.getInt("idTipoTramite"));
                tipo.setNombre(rs.getString("nombreTramite"));

                // Rubro
                Rubro rubro = new Rubro();
                rubro.setIdRubro(rs.getInt("idRubro"));
                rubro.setNombre(rs.getString("nombreRubro"));
                rubro.setEsDeAltoRiesgo(rs.getBoolean("esDeAltoRiesgo"));


                // Crear expediente
                Expediente e = new Expediente();
                e.setIdExpediente(rs.getInt("idExpediente"));
                e.setNumero(rs.getInt("numero"));
                e.setLetra(rs.getString("letra"));
                e.setAnio(rs.getInt("anio"));
                e.setFechaHora(rs.getTimestamp("fechaHoraIngreso"));
                e.setEstado(rs.getString("estado"));
                e.setObservaciones(rs.getString("observaciones"));
                e.setTipoTramite(tipo);
                e.setRubro(rubro);
                e.setContribuyente(c);

                lista.add(e);
            }

        } catch (Exception ex) {
            System.err.println("❌ Error al obtener expedientes: " + ex.getMessage());
        }

        return lista;
    }
    public static void guardar(Expediente e) {
        String sql = "INSERT INTO expediente (numero, letra, anio, fechaHoraIngreso, estado, idTipoTramite, idRubro, idContribuyente) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, e.getNumero());
            stmt.setString(2, e.getLetra());
            stmt.setInt(3, e.getAnio());
            stmt.setTimestamp(4, new java.sql.Timestamp(e.getFechaHora().getTime()));
            stmt.setString(5, e.getEstado());
            stmt.setInt(6, e.getTipoTramite().getIdTipoTramite());
            stmt.setInt(7, e.getRubro().getIdRubro());
            stmt.setInt(8, e.getContribuyente().getIdContribuyente());

            stmt.executeUpdate();
            System.out.println("✅ Expediente guardado correctamente en la base de datos.");

        } catch (Exception ex) {
            System.err.println("❌ Error al guardar expediente: " + ex.getMessage());
        }
    }
    public static int contarTotal() {
        String sql = "SELECT COUNT(*) FROM expediente";
        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            System.err.println("❌ Error al contar expedientes: " + ex.getMessage());
        }
        return 0; // Si hubo error, devolver 0 como valor seguro
    }


}
