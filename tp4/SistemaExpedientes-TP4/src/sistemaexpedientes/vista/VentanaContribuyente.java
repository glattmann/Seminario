/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.modelo.Contribuyente;
import sistemaexpedientes.controlador.ControladorContribuyente;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta ventana permite registrar y editar los datos de los contribuyentes.
 */
public class VentanaContribuyente extends JFrame {

    private List<Contribuyente> listaContribuyentes = new ArrayList<>();
    private VentanaExpedienteBase ventanaExpediente; // Referencia a la ventana de expediente 
    private Contribuyente contribuyenteActual = null; // El contribuyente que se está editando o viendo en pantalla
    private ControladorContribuyente controlador = new ControladorContribuyente();


    // Campos de texto
    private JTextField txtCuit, txtNombre, txtApellido, txtDni, txtRazonSocial, txtDireccion, txtCorreo, txtTelefono;
    // Combo para tipo de contribuyente (física o jurídica)
    private JComboBox<String> cmbTipo;
    // Botones de la ventan
    private JButton btnNuevo, btnGuardar, btnModificar, btnCancelar, btnSalir, btnCargarAExpediente, btnBuscar;

    public VentanaContribuyente() {
        inicializarComponentes();
    }

    // Este constructor se usa cuando se llama desde la ventana de expediente
    public VentanaContribuyente(VentanaExpedienteBase ventanaExpediente) {
        this();
        this.ventanaExpediente = ventanaExpediente;
        btnCargarAExpediente.setEnabled(true); // Habilita botón si viene desde expediente
    }

    private void inicializarComponentes() {
        
        listaContribuyentes = controlador.obtenerTodos();
        
        setTitle("Gestión de Contribuyentes");
        setSize(480, 580);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        int y = 20;

        // Carga todos los campos con su respectiva posición
        add(new JLabel("CUIT:")).setBounds(20, y, 100, 25);
        txtCuit = new JTextField(); txtCuit.setBounds(130, y, 200, 25); add(txtCuit);

        add(new JLabel("Nombre:")).setBounds(20, y += 40, 100, 25);
        txtNombre = new JTextField(); txtNombre.setBounds(130, y, 200, 25); add(txtNombre);

        add(new JLabel("Apellido:")).setBounds(20, y += 40, 100, 25);
        txtApellido = new JTextField(); txtApellido.setBounds(130, y, 200, 25); add(txtApellido);

        add(new JLabel("DNI:")).setBounds(20, y += 40, 100, 25);
        txtDni = new JTextField(); txtDni.setBounds(130, y, 200, 25); add(txtDni);

        add(new JLabel("Razón Social:")).setBounds(20, y += 40, 100, 25);
        txtRazonSocial = new JTextField(); txtRazonSocial.setBounds(130, y, 200, 25); add(txtRazonSocial);

        add(new JLabel("Tipo:")).setBounds(20, y += 40, 100, 25);
        cmbTipo = new JComboBox<>(new String[]{"Físico", "Jurídico"});
        cmbTipo.setBounds(130, y, 200, 25); add(cmbTipo);

        add(new JLabel("Dirección:")).setBounds(20, y += 40, 100, 25);
        txtDireccion = new JTextField(); txtDireccion.setBounds(130, y, 200, 25); add(txtDireccion);

        add(new JLabel("Correo:")).setBounds(20, y += 40, 100, 25);
        txtCorreo = new JTextField(); txtCorreo.setBounds(130, y, 200, 25); add(txtCorreo);

        add(new JLabel("Teléfono:")).setBounds(20, y += 40, 100, 25);
        txtTelefono = new JTextField(); txtTelefono.setBounds(130, y, 200, 25); add(txtTelefono);

        // Botones
        btnNuevo = new JButton("Nuevo"); btnNuevo.setBounds(20, y += 50, 100, 30); add(btnNuevo);
        btnGuardar = new JButton("Guardar"); btnGuardar.setBounds(130, y, 100, 30); add(btnGuardar);
        btnModificar = new JButton("Modificar"); btnModificar.setBounds(240, y, 100, 30); add(btnModificar);
        btnCancelar = new JButton("Cancelar"); btnCancelar.setBounds(350, y, 100, 30); add(btnCancelar);

        btnSalir = new JButton("Salir"); btnSalir.setBounds(20, y += 40, 100, 30); add(btnSalir);
        btnCargarAExpediente = new JButton("Cargar a Expediente");
        btnCargarAExpediente.setBounds(130, y, 200, 30); add(btnCargarAExpediente);
        btnBuscar = new JButton("Buscar"); btnBuscar.setBounds(340, y, 100, 30); add(btnBuscar);

        // Desactivamos todos los botones al principio
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnCargarAExpediente.setEnabled(false);
        setCamposHabilitados(false);

        // Eventos de botones
        btnNuevo.addActionListener(e -> {
            limpiarCampos();
            setCamposHabilitados(true);
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
            contribuyenteActual = null;
        });

        btnGuardar.addActionListener(e -> guardarContribuyente());
        btnModificar.addActionListener(e -> {
            if (contribuyenteActual != null) {
                setCamposHabilitados(true);
                btnGuardar.setEnabled(true);
            }
        });

        btnCancelar.addActionListener(e -> {
            limpiarCampos();
            setCamposHabilitados(false);
            btnGuardar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnCancelar.setEnabled(false);
        });

        btnSalir.addActionListener(e -> dispose());

        // Carga el contribuyente en el expediente (si se llamó desde ahí)
        btnCargarAExpediente.addActionListener(e -> {
            if (ventanaExpediente != null && contribuyenteActual != null) {
                ventanaExpediente.setContribuyenteSeleccionado(contribuyenteActual); // ✅ conserva el ID
                dispose();
            }
        });

        btnBuscar.addActionListener(e -> mostrarSelector());
    }

    // Muestra una lista para elegir un contribuyente ya guardado
    private void mostrarSelector() {
        if (listaContribuyentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay contribuyentes cargados.");
            return;
        }
        Contribuyente seleccionado = (Contribuyente) JOptionPane.showInputDialog(
                this,
                "Seleccione un contribuyente:",
                "Buscar Contribuyente",
                JOptionPane.PLAIN_MESSAGE,
                null,
                listaContribuyentes.toArray(),
                null
        );

        if (seleccionado != null) {
            setCamposDesdeContribuyente(seleccionado);
            contribuyenteActual = seleccionado;
            btnModificar.setEnabled(true);
            btnCancelar.setEnabled(true);
        }
    }

    // Rellena los campos con los datos del contribuyente
    private void setCamposDesdeContribuyente(Contribuyente c) {
        txtCuit.setText(c.getCuit());
        txtNombre.setText(c.getNombre());
        txtApellido.setText(c.getApellido());
        txtDni.setText(c.getDni());
        txtRazonSocial.setText(c.getRazonSocial());
        cmbTipo.setSelectedItem(c.getTipoContribuyente());
        txtDireccion.setText(c.getDireccion());
        txtCorreo.setText(c.getCorreo());
        txtTelefono.setText(c.getTelefono());
    }

    // Habilita o deshabilita todos los campos de entrada
    private void setCamposHabilitados(boolean estado) {
        txtCuit.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtApellido.setEnabled(estado);
        txtDni.setEnabled(estado);
        txtRazonSocial.setEnabled(estado);
        cmbTipo.setEnabled(estado);
        txtDireccion.setEnabled(estado);
        txtCorreo.setEnabled(estado);
        txtTelefono.setEnabled(estado);
    }

    // Guarda el contribuyente nuevo o actualizado 
    private void guardarContribuyente() {
        // Crear el contribuyente desde los campos actuales
        Contribuyente c = obtenerContribuyenteDesdeCampos();

        if (contribuyenteActual == null) {
            // Alta de nuevo contribuyente
            controlador.guardar(c);
            JOptionPane.showMessageDialog(this, "✅ Contribuyente guardado correctamente.");
        } else {
            // Modificación de existente
            controlador.modificar(c);
            JOptionPane.showMessageDialog(this, "✏️ Contribuyente modificado correctamente.");
        }

        // Recargar la lista desde base de datos
        listaContribuyentes = controlador.obtenerTodos();

        // Restablecer el formulario
        limpiarCampos();
        setCamposHabilitados(false);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
    

    // Crea un objeto Contribuyente con los datos cargados en los campos
    private Contribuyente obtenerContribuyenteDesdeCampos() {
        Contribuyente c = new Contribuyente();
        c.setCuit(txtCuit.getText());
        c.setNombre(txtNombre.getText());
        c.setApellido(txtApellido.getText());
        c.setDni(txtDni.getText());
        c.setRazonSocial(txtRazonSocial.getText());
        c.setTipoContribuyente((String) cmbTipo.getSelectedItem());
        c.setDireccion(txtDireccion.getText());
        c.setCorreo(txtCorreo.getText());
        c.setTelefono(txtTelefono.getText());
        return c;
    }

    // Limpia todos los campos del formulario
    private void limpiarCampos() {
        txtCuit.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtRazonSocial.setText("");
        cmbTipo.setSelectedIndex(0);
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
    }

    
}
