/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GL
 */
/**
 * Acceso a datos para la tabla tipoTramite.
 */
public class TipoTramiteDAOJdbc {

    // Método para obtener todos los tipos de trámite desde la base de datos
    public static List<TipoTramite> obtenerTodos() {
        List<TipoTramite> lista = new ArrayList<>();
        String sql = "SELECT idTipoTramite, nombre, descripcion FROM tipotramite";

        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                TipoTramite tt = new TipoTramite();
                tt.setIdTipoTramite(rs.getInt("idTipoTramite"));
                tt.setNombre(rs.getString("nombre"));
                tt.setDescripcion(rs.getString("descripcion"));
                lista.add(tt);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al obtener tipos de trámite: " + e.getMessage());
        }

        return lista;
    }
}
