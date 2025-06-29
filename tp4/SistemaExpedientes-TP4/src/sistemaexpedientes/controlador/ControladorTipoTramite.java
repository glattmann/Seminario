/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.controlador;

import sistemaexpedientes.modelo.TipoTramite;
import sistemaexpedientes.modelo.TipoTramiteDAOJdbc;

import java.util.List;

/**
 * Controlador encargado de gestionar la lógica de negocio relacionada con los tipos de trámite.
 * Facilita el acceso a los tipos de trámite disponibles en el sistema de expedientes municipales.
 *
 * Autor: GL
 */
public class ControladorTipoTramite {

    /**
     * Obtiene la lista de todos los tipos de trámite registrados en la base de datos.
     * Estos tipos son utilizados al momento de cargar o gestionar expedientes.
     */
    public List<TipoTramite> obtenerTodos() {
        return TipoTramiteDAOJdbc.obtenerTodos();
    }
}

