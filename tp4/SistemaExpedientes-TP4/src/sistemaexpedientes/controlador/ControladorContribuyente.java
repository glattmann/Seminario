/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.controlador;

import sistemaexpedientes.modelo.Contribuyente;
import sistemaexpedientes.modelo.ContribuyenteDAOJdbc;

import java.util.List;

/**
 * Controlador de lógica de negocio para la gestión de contribuyentes.
 * Este controlador actúa como intermediario entre la vista y el acceso a datos,
 * delegando en el DAO las operaciones sobre la base de datos.
 *
 * Autor: GL
 */
public class ControladorContribuyente {

    public List<Contribuyente> obtenerTodos() {
        return ContribuyenteDAOJdbc.obtenerTodos();
    }

    public void guardar(Contribuyente contribuyente) {
    // Llama al DAO para guardar el contribuyente en la base de datos
    ContribuyenteDAOJdbc.guardar(contribuyente);
    }
    
    public void modificar(Contribuyente contribuyente) {
    // Llama al DAO para modificar el contribuyente en la base de datos
    ContribuyenteDAOJdbc.modificar(contribuyente);
    }


}
