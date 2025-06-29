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
 * Clase de acceso a datos (DAO) para la entidad Rubro.
 * Permite recuperar información de la tabla "rubro" de la base de datos.
 *
 * Autor: GL
 */
public class RubroDAOJdbc {

    /**
     * Obtiene todos los rubros existentes desde la base de datos.
     * Recupera también los atributos especiales como si requiere bromatología
     * o si corresponde a rubros de alto riesgo.
     */
    public static List<Rubro> obtenerTodos() {
        List<Rubro> lista = new ArrayList<>();

        String sql = "SELECT idRubro, nombre, descripcion, actividad, esRubroEspecial, requiereBromatologia, esDeAltoRiesgo FROM rubro";


        try (
            Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Rubro r = new Rubro();
                r.setIdRubro(rs.getInt("idRubro"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setActividad(rs.getString("actividad"));
                r.setEsRubroEspecial(rs.getBoolean("esRubroEspecial"));
                r.setRequiereBromatologia(rs.getBoolean("requiereBromatologia"));
                r.setEsDeAltoRiesgo(rs.getBoolean("esDeAltoRiesgo"));
                
                System.out.println("🔍 Rubro: " + r.getNombre() + " | Riesgo alto: " + r.isEsDeAltoRiesgo());


                lista.add(r);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al obtener rubros: " + e.getMessage());
        }

        return lista;
    }
}
