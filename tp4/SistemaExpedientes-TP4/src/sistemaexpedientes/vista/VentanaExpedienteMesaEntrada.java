/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.modelo.*;
import sistemaexpedientes.controlador.ControladorExpediente;
import sistemaexpedientes.controlador.ControladorRubro;
import sistemaexpedientes.ia.IAClienteLMStudio;




import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author GL
 */
/**
 * Esta clase representa la pantalla que se usa en Mesa de Entrada
 * para cargar o modificar un expediente con sus datos básicos.
 */
public class VentanaExpedienteMesaEntrada extends VentanaExpedienteBase {
    
    private ControladorExpediente controlador = new ControladorExpediente();
    private ControladorRubro controladorRubro = new ControladorRubro();


    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnSalir;
    private JButton btnBuscarExpediente;
    private JButton btnModificar;
    private JButton btnBuscarContribuyente;
    
    public VentanaExpedienteMesaEntrada() {
    super(); // Llama al constructor de VentanaExpedienteBase
    configurarVista(); // Llamamos después de inicializar los controladores
}


    @Override
    public void configurarVista() {
        setLayout(null);
        int y = 20;

        // Campos de encabezado del expediente (número, letra, año, etc.)
        // Todos están deshabilitados porque los llena automáticamente el sistema
        JLabel lblNomenclatura = new JLabel("Nomenclatura:");
        lblNomenclatura.setBounds(20, y, 120, 25);
        add(lblNomenclatura);

        txtNomenclatura = new JTextField();
        txtNomenclatura.setBounds(140, y, 200, 25);
        txtNomenclatura.setEnabled(false);
        add(txtNomenclatura);


        JLabel lblFechaHora = new JLabel("Fecha Hora:");
        lblFechaHora.setBounds(20, y += 40, 100, 25);
        add(lblFechaHora);
        txtFechaHora = new JTextField();
        txtFechaHora.setBounds(120, y, 200, 25);
        txtFechaHora.setEnabled(false);
        add(txtFechaHora);

        // Se agregan combos predefinidos con ejemplos
        JLabel lblTipoTramite = new JLabel("Tipo de Trámite:");
        lblTipoTramite.setBounds(20, y += 40, 120, 25);
        add(lblTipoTramite);
        cmbTipoTramite = new JComboBox<>();
        cmbTipoTramite.setBounds(150, y, 200, 25);
        cmbTipoTramite.setEnabled(false);
        for (TipoTramite tt : controladorTipoTramite.obtenerTodos()) {
            cmbTipoTramite.addItem(tt);
        }
        add(cmbTipoTramite);


        // Se agregan combos predefinidos con ejemplos
        JLabel lblRubro = new JLabel("Rubro:");
        lblRubro.setBounds(20, y += 40, 100, 25);
        add(lblRubro);
        cmbRubro = new JComboBox<>();
        cmbRubro.setBounds(150, y, 200, 25);
        cmbRubro.setEnabled(false);
        for (Rubro r : controladorRubro.obtenerTodos()) {
            cmbRubro.addItem(r);
        }

        add(cmbRubro);

        JLabel lblContribuyente = new JLabel("Contribuyente:");
        lblContribuyente.setBounds(20, y += 40, 120, 25);
        add(lblContribuyente);
        btnBuscarContribuyente = new JButton("Buscar");
        btnBuscarContribuyente.setBounds(150, y, 100, 25);
        btnBuscarContribuyente.setEnabled(false);
        add(btnBuscarContribuyente);
        
        JButton btnAsistenteIA = new JButton("Asistente IA");
        btnAsistenteIA.setBounds(20, y += 40, 150, 30);
        getContentPane().add(btnAsistenteIA);

        btnBuscarContribuyente.addActionListener(e -> {
            VentanaContribuyente ventana = new VentanaContribuyente(VentanaExpedienteMesaEntrada.this);
            ventana.setVisible(true);
        });

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(270, y, 50, 25);
        add(lblTipo);
        txtTipo = new JTextField();
        txtTipo.setBounds(320, y, 80, 25);
        txtTipo.setEnabled(false);
        add(txtTipo);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(410, y, 40, 25);
        add(lblDni);
        txtDni = new JTextField();
        txtDni.setBounds(450, y, 100, 25);
        txtDni.setEnabled(false);
        add(txtDni);

        JLabel lblCuit = new JLabel("CUIT:");
        lblCuit.setBounds(20, y += 40, 100, 25);
        add(lblCuit);
        txtCuit = new JTextField();
        txtCuit.setBounds(120, y, 100, 25);
        txtCuit.setEnabled(false);
        add(txtCuit);

        JLabel lblNombreApellido = new JLabel("Nombre y Apellido:");
        lblNombreApellido.setBounds(230, y, 120, 25);
        add(lblNombreApellido);
        txtNombreApellido = new JTextField();
        txtNombreApellido.setBounds(350, y, 200, 25);
        txtNombreApellido.setEnabled(false);
        add(txtNombreApellido);

        JLabel lblRazonSocial = new JLabel("Razón Social:");
        lblRazonSocial.setBounds(20, y += 40, 100, 25);
        add(lblRazonSocial);
        txtRazonSocial = new JTextField();
        txtRazonSocial.setBounds(120, y, 200, 25);
        txtRazonSocial.setEnabled(false);
        add(txtRazonSocial);

        JLabel lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(20, y += 40, 100, 25);
        add(lblDomicilio);
        txtDomicilio = new JTextField();
        txtDomicilio.setBounds(120, y, 200, 25);
        txtDomicilio.setEnabled(false);
        add(txtDomicilio);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(330, y, 100, 25);
        add(lblTelefono);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(410, y, 120, 25);
        txtTelefono.setEnabled(false);
        add(txtTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(20, y += 40, 100, 25);
        add(lblCorreo);
        txtCorreo = new JTextField();
        txtCorreo.setBounds(120, y, 200, 25);
        txtCorreo.setEnabled(false);
        add(txtCorreo);

        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setBounds(20, y += 70, 100, 25);
        add(lblObservaciones);
        txtObservaciones = new JTextArea();
        txtObservaciones.setBounds(120, y, 400, 60);
        txtObservaciones.setEnabled(false);
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        add(txtObservaciones);

        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(20, y += 100, 100, 30);
        add(btnNuevo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, y, 100, 30);
        btnGuardar.setEnabled(false);
        add(btnGuardar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(240, y, 100, 30);
        btnModificar.setEnabled(false);
        add(btnModificar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(350, y, 100, 30);
        btnCancelar.setEnabled(false);
        add(btnCancelar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(460, y, 100, 30);
        add(btnSalir);

        btnBuscarExpediente = new JButton("Buscar Expediente");
        btnBuscarExpediente.setBounds(180, y += 40, 200, 30);
        add(btnBuscarExpediente);

      
        btnNuevo.addActionListener(e -> activarFormulario());

        btnGuardar.addActionListener(e -> {
            guardarExpediente();
        });

        btnBuscarExpediente.addActionListener(e -> {
            if (listaExpedientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "⚠️ No hay expedientes registrados.");
                return;
            }

            Expediente seleccionado = (Expediente) JOptionPane.showInputDialog(
                this,
                "Seleccione un expediente:",
                "Buscar Expediente",
                JOptionPane.PLAIN_MESSAGE,
                null,
                listaExpedientes.toArray(),
                null
            );

            if (seleccionado != null) {
                mostrarExpediente(seleccionado);
                btnModificar.setEnabled(true);
            }
        });

        btnCancelar.addActionListener(e -> restablecerFormulario());
        btnSalir.addActionListener(e -> dispose());

        btnModificar.addActionListener(e -> {
            if (expedienteSeleccionado != null) {
                cmbTipoTramite.setEnabled(true);
                cmbRubro.setEnabled(true);
                btnBuscarContribuyente.setEnabled(true);
                txtObservaciones.setEnabled(true);
                btnGuardar.setEnabled(true);
                btnCancelar.setEnabled(true);
            }
            
        });
        
        btnAsistenteIA.addActionListener(e -> {
            VentanaAsistenteIA ventanaIA = new VentanaAsistenteIA();
            ventanaIA.setVisible(true);
        });



        
    }
    @Override
    protected void activarFormulario() {
        cmbTipoTramite.setEnabled(true);
        cmbRubro.setEnabled(true);
        txtObservaciones.setEnabled(true);

        btnBuscarContribuyente.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }


    // Método para guardar o actualizar un expediente
    private void guardarExpediente() {
        Expediente expediente;
        boolean esNuevo = false;

        // Si es un expediente nuevo, se crea uno nuevo
        if (expedienteSeleccionado == null) {
            expediente = new Expediente();
            expediente.setFechaHora(new Date());
            expediente.setEstado("En proceso");

            // Validación del contribuyente antes de generar la nomenclatura
            if (contribuyenteSeleccionado != null) {
                expediente.setContribuyente(contribuyenteSeleccionado); // primero se asigna
                controladorExpediente.generarNomenclatura(expediente);  // luego se genera
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Debe seleccionar un contribuyente antes de guardar.");
                return; // cancelamos el guardado
            }

            esNuevo = true;
        } else {
            expediente = expedienteSeleccionado;
        }

        // Asignación de campos comunes
        expediente.setTipoTramite((TipoTramite) cmbTipoTramite.getSelectedItem());
        expediente.setRubro((Rubro) cmbRubro.getSelectedItem());
        expediente.setObservaciones(txtObservaciones.getText());

        // Guardar en base de datos solo si es nuevo
        if (esNuevo) {
            controladorExpediente.guardar(expediente); // Guardar en base
            listaExpedientes = controladorExpediente.obtenerTodos(); // Recargar
        }

        // Mostrar datos en campos
        txtNomenclatura.setText(expediente.getNomenclatura());
        txtFechaHora.setText(expediente.getFechaHora().toString());

        String mensaje = esNuevo ? "✅ Expediente guardado correctamente." : "✏️ Expediente modificado correctamente.";
        JOptionPane.showMessageDialog(this, mensaje);
        restablecerFormulario();
    }

     
}
