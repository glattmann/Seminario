/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.modelo.*;
import sistemaexpedientes.persistencia.ExpedienteDAOJson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.BorderLayout;

/**
 *
 * @author GL
 */
/**
 * Clase base que comparten todas las ventanas relacionadas a expedientes.
 * En esta clase se definen los campos, estructuras comunes y comportamientos reutilizables.
 */
public abstract class VentanaExpedienteBase extends JFrame {

    protected Contribuyente contribuyenteSeleccionado; // Contribuyente que se está trabajando actualmente
    protected Expediente expedienteSeleccionado = null; // Si se seleccionó un expediente, se guarda acá
    protected List<Expediente> listaExpedientes = ExpedienteDAOJson.leer(); // Lista que se carga desde el archivo JSON

    // Campos del formulario
    protected JTextField txtNumero, txtLetra, txtAnio, txtFechaHora, txtTipo;
    protected JTextField txtDni, txtCuit, txtNombreApellido, txtRazonSocial;
    protected JTextField txtDomicilio, txtTelefono, txtCorreo;
    protected JTextArea txtObservaciones;
    protected JComboBox<TipoTramite> cmbTipoTramite;
    protected JComboBox<Rubro> cmbRubro;

    public VentanaExpedienteBase() {
        setTitle("Gestión de Expedientes");
        setSize(600, 650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configurarVista();  // Cada clase hija (como Comercio o MesaEntrada) implementa esta parte
    }

    public abstract void configurarVista(); // Cada subclase debe armar su propia vista con este método

    // Cuando se carga un contribuyente (desde la ventana contribuyente),
    // se pasan sus datos a los campos correspondientes
    public void setContribuyenteSeleccionado(Contribuyente c) {
        this.contribuyenteSeleccionado = c;
        txtNombreApellido.setText(c.getNombre() + " " + c.getApellido());
        txtCuit.setText(c.getCuit());
        txtRazonSocial.setText(c.getRazonSocial());
        txtDni.setText(c.getDni());
        txtTipo.setText(c.getTipoContribuyente());
        txtDomicilio.setText(c.getDireccion());
        txtCorreo.setText(c.getCorreo());
        txtTelefono.setText(c.getTelefono());
    }

    // Limpia todos los campos del formulario
    protected void limpiarCampos() {
        txtNumero.setText("");
        txtLetra.setText("");
        txtAnio.setText("");
        txtFechaHora.setText("");
        cmbTipoTramite.setSelectedIndex(0);
        cmbRubro.setSelectedIndex(0);
        txtTipo.setText("");
        txtDni.setText("");
        txtCuit.setText("");
        txtNombreApellido.setText("");
        txtRazonSocial.setText("");
        txtDomicilio.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtObservaciones.setText("");
    }

    // Desactiva campos
    protected void restablecerFormulario() {
        cmbTipoTramite.setEnabled(false);
        cmbRubro.setEnabled(false);
        txtObservaciones.setEnabled(false);
        limpiarCampos();
    }

    // Activa los campos
    protected void activarFormulario() {
        cmbTipoTramite.setEnabled(true);
        cmbRubro.setEnabled(true);
        txtObservaciones.setEnabled(true);
    }

    // Muestra los datos del expediente seleccionado en los campos
    protected void mostrarExpediente(Expediente expediente) {
        this.expedienteSeleccionado = expediente;
        this.contribuyenteSeleccionado = expediente.getContribuyente();

        txtNumero.setText(String.valueOf(expediente.getNumero()));
        txtLetra.setText(expediente.getLetra());
        txtAnio.setText(String.valueOf(expediente.getAnio()));
        txtFechaHora.setText(expediente.getFechaHora().toString());
        txtObservaciones.setText(expediente.getObservaciones());

        cmbTipoTramite.setSelectedItem(expediente.getTipoTramite());
        cmbRubro.setSelectedItem(expediente.getRubro());

        Contribuyente c = expediente.getContribuyente();
        if (c != null) {
            txtTipo.setText(c.getTipoContribuyente());
            txtDni.setText(c.getDni());
            txtCuit.setText(c.getCuit());
            txtNombreApellido.setText(c.getNombre() + " " + c.getApellido());
            txtRazonSocial.setText(c.getRazonSocial());
            txtDomicilio.setText(c.getDireccion());
            txtTelefono.setText(c.getTelefono());
            txtCorreo.setText(c.getCorreo());
        }
    }
}
