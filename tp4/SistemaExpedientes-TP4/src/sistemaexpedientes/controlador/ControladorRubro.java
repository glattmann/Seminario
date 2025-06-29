/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.controlador;

import sistemaexpedientes.modelo.Rubro;
import sistemaexpedientes.modelo.RubroDAOJdbc;

import java.util.List;

/**
 * Controlador de la lógica de negocio relacionada con los rubros comerciales.
 * Permite obtener la lista de rubros desde la base de datos para ser utilizados
 * en la carga o visualización de expedientes.
 *
 * Autor: GL
 */
public class ControladorRubro {

   /**
     * Obtiene todos los rubros registrados en la base de datos.
     * Estos rubros representan las distintas actividades comerciales
     * habilitables en el sistema de expedientes municipales.
     */
    public List<Rubro> obtenerTodos() {
        return RubroDAOJdbc.obtenerTodos();
    }
}
