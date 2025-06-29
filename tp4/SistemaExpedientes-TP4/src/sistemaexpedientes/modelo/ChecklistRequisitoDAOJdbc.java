/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Clase DAO (Data Access Object) para el acceso a la base de datos
 * relacionado al checklist de requisitos del sector Comercio.
 * 
 * Esta clase permite:
 * - Crear el checklist inicial de requisitos para un expediente.
 * - Guardar o actualizar el estado de los requisitos.
 * - Recuperar el checklist de un expediente desde la base.
 * - Obtener la lista base de requisitos que aplica por defecto.
 * 
 * Tabla afectada: checklistrequisitocomercio
 * 
 * Autor: GL
 */
public class ChecklistRequisitoDAOJdbc {
    
    /**
     * Crea una lista inicial de requisitos (vacíos, no cumplidos)
     * para un expediente específico.
     */

    public static List<ChecklistRequisitoComercio> crearChecklistInicial(int idExpediente) {
        List<ChecklistRequisitoComercio> lista = new ArrayList<>();

        String sql = "SELECT idRequisito, descripcion, obligatorio FROM requisito";

        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Requisito req = new Requisito();
                req.setIdRequisito(rs.getInt("idRequisito"));
                req.setDescripcion(rs.getString("descripcion"));
                req.setObligatorio(rs.getBoolean("obligatorio"));

                ChecklistRequisitoComercio item = new ChecklistRequisitoComercio();
                item.setRequisito(req);
                item.setIdExpediente(idExpediente); 
                item.setCumplido(false);             
                item.setObservaciones("");        

                lista.add(item);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al crear checklist inicial: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
    /**
     * Guarda en la base de datos el checklist completo de un expediente.
     * Primero elimina el checklist existente para evitar duplicados.
     */

    public static void guardarParaExpediente(int idExpediente, List<ChecklistRequisitoComercio> checklist) {
        String eliminarSQL = "DELETE FROM checklistrequisitocomercio WHERE idExpediente = ?";
        String insertarSQL = "INSERT INTO checklistrequisitocomercio (idExpediente, idRequisito, cumplido, observaciones) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion()) {

            
            try (PreparedStatement stmtEliminar = conn.prepareStatement(eliminarSQL)) {
                stmtEliminar.setInt(1, idExpediente);
                stmtEliminar.executeUpdate();
            }

           
            try (PreparedStatement stmtInsertar = conn.prepareStatement(insertarSQL)) {
                for (ChecklistRequisitoComercio item : checklist) {
                    stmtInsertar.setInt(1, idExpediente);
                    stmtInsertar.setInt(2, item.getRequisito().getIdRequisito());
                    stmtInsertar.setBoolean(3, item.isCumplido());
                    stmtInsertar.setString(4, item.getObservaciones());
                    stmtInsertar.addBatch(); 
                }
                stmtInsertar.executeBatch(); 
            }

            System.out.println("✅ Checklist guardado correctamente para el expediente " + idExpediente);

        } catch (Exception e) {
            System.err.println("❌ Error al guardar checklist: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza el estado de cumplimiento y observaciones de un checklist ya existente.
     */
    public static void actualizarChecklist(List<ChecklistRequisitoComercio> checklist) {
        String sql = "UPDATE checklistrequisitocomercio SET cumplido = ?, observaciones = ? WHERE idChecklist = ?";

        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            for (ChecklistRequisitoComercio item : checklist) {
                stmt.setBoolean(1, item.isCumplido());
                stmt.setString(2, item.getObservaciones());
                stmt.setInt(3, item.getId());
                stmt.addBatch(); // Agregamos al lote de actualizaciones
            }

            stmt.executeBatch(); // Ejecutamos todas juntas
            System.out.println("✅ Checklist actualizado correctamente.");

        } catch (Exception e) {
            System.err.println("❌ Error al actualizar checklist: " + e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el checklist de requisitos ya cargados para un expediente.
     * Incluye también la descripción y obligatoriedad de cada requisito.
     * 
     */
    public static List<ChecklistRequisitoComercio> obtenerPorExpediente(int idExpediente) {
        List<ChecklistRequisitoComercio> lista = new ArrayList<>();

        String sql = "SELECT crc.idChecklist, crc.idExpediente, crc.idRequisito, crc.cumplido, crc.observaciones, " +
                     "r.descripcion, r.obligatorio " +
                     "FROM checklistrequisitocomercio crc " +
                     "JOIN requisito r ON crc.idRequisito = r.idRequisito " +
                     "WHERE crc.idExpediente = ?";

        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, idExpediente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Requisito req = new Requisito();
                req.setIdRequisito(rs.getInt("idRequisito"));
                req.setDescripcion(rs.getString("descripcion"));
                req.setObligatorio(rs.getBoolean("obligatorio"));

                ChecklistRequisitoComercio item = new ChecklistRequisitoComercio();
                item.setId(rs.getInt("idChecklist"));
                item.setCumplido(rs.getBoolean("cumplido"));
                item.setObservaciones(rs.getString("observaciones"));
                item.setRequisito(req);

                lista.add(item);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al obtener requisitos: " + e.getMessage());
        }

        return lista;
    }
    /**
     * Devuelve la lista base de todos los requisitos definidos en la tabla 'requisito'.
     */
    public static List<Requisito> obtenerRequisitosBase() {
        List<Requisito> lista = new ArrayList<>();

        String sql = "SELECT idRequisito, nombre, descripcion, obligatorio FROM requisito";

        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Requisito r = new Requisito();
                r.setIdRequisito(rs.getInt("idRequisito"));
                r.setDescripcion(rs.getString("nombre")); 
                r.setObligatorio(rs.getBoolean("obligatorio"));
                lista.add(r);
            }
        } catch (Exception e) {
            System.err.println("❌ Error al obtener requisitos base: " + e.getMessage());
        }

        return lista;
    }



}