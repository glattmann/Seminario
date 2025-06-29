/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.controlador;

import sistemaexpedientes.modelo.Expediente;
import sistemaexpedientes.modelo.TipoTramite;
import sistemaexpedientes.modelo.ExpedienteDAOJdbc;
import sistemaexpedientes.modelo.TipoTramiteDAOJdbc;


import java.util.List;
/**
 * Controlador de lógica de negocio para la gestión de expedientes.
 * Se encarga de interactuar entre la vista (interfaz gráfica) y los DAOs de acceso a la base de datos.
 *
 * Autor: GL
 */
public class ControladorExpediente {

    /**
     * Devuelve la lista de todos los expedientes desde la base de datos
     */
    public List<Expediente> obtenerTodos() {
        return ExpedienteDAOJdbc.obtenerTodos();
    }
    public void guardar(Expediente expediente) {
        // Delegamos la responsabilidad de guardar al DAO
        ExpedienteDAOJdbc.guardar(expediente);
    }
    /**
     * Genera la nomenclatura automática para un nuevo expediente.
     * La nomenclatura tiene el formato: Número / Letra / Año.
     * La letra se determina según el tipo de contribuyente.
     */
    public void generarNomenclatura(Expediente expediente) {
        // Obtener número siguiente (último + 1)
        List<Expediente> existentes = ExpedienteDAOJdbc.obtenerTodos();
        int proximoNumero = existentes.stream()
                                      .mapToInt(Expediente::getNumero)
                                      .max()
                                      .orElse(0) + 1;
        expediente.setNumero(proximoNumero);

        // Año actual
        expediente.setAnio(java.time.LocalDate.now().getYear());

        // Letra: depende del tipo de contribuyente
        String letra = "X"; // Por defecto

        if (expediente.getContribuyente() != null) {
            var c = expediente.getContribuyente();
            String tipo = c.getTipoContribuyente();

            if ("Jurídico".equalsIgnoreCase(tipo) && c.getRazonSocial() != null && !c.getRazonSocial().isEmpty()) {
                letra = c.getRazonSocial().substring(0, 1).toUpperCase();
            } else if ("Físico".equalsIgnoreCase(tipo) && c.getApellido() != null && !c.getApellido().isEmpty()) {
                letra = c.getApellido().substring(0, 1).toUpperCase();
            }
        }

        expediente.setLetra(letra);
    }

    public List<TipoTramite> obtenerTiposTramite() {
        return TipoTramiteDAOJdbc.obtenerTodos();
    }
    public static int contarExpedientes() {
        return ExpedienteDAOJdbc.contarTotal();
    }


}
