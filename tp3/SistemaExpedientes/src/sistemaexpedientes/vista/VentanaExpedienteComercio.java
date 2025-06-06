/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.modelo.*;
import sistemaexpedientes.persistencia.ExpedienteDAOJson;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
/**
 *
 * @author GL
 */
/**
 * Esta clase es la ventana específica para el sector Comercio.
 * Permite visualizar los datos del expediente y gestionar los checks de requisitos.
 * Hereda de VentanaExpedienteBase. 
 */
public class VentanaExpedienteComercio extends VentanaExpedienteBase {

    protected JPanel contentPanel;
    private JButton btnCargar, btnGuardar, btnCancelar, btnSalir, btnBuscarExpediente;
    private JCheckBox[] checklist;
    

    
    private Sector sector;

    // Constructor que recibe el sector (en este caso se espera que sea Comercio)
    public VentanaExpedienteComercio(Sector sector) {
        this(); // Llama al constructor sin parámetros primero
        this.sector = sector;
    

    }
    
    public VentanaExpedienteComercio() {
    
    }


    // Este método se llama al crearse la ventana y arma toda la interfaz
    @Override
    public void configurarVista() {
        setTitle("Expediente - Comercio");
        contentPanel = new JPanel(null); // Panel que se va a scrollear
        contentPanel.setPreferredSize(new Dimension(580, 1000)); // Se define el tamaño

        // Scroll que va a envolver todo el contentPanel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(0, 0, 600, 700); 

        contentPanel.setLayout(null);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);


        setSize(600, 700);

        int y = 20; // variable para controlar posición vertical

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(20, y, 100, 25);
        contentPanel.add(lblNumero);
        txtNumero = new JTextField();
        txtNumero.setBounds(120, y, 100, 25);
        txtNumero.setEnabled(false);
        contentPanel.add(txtNumero);
        
        JLabel lblLetra = new JLabel("Letra:");
        lblLetra.setBounds(240, y, 50, 25);
        contentPanel.add(lblLetra);
        txtLetra = new JTextField();
        txtLetra.setBounds(290, y, 50, 25);
        txtLetra.setEnabled(false);
        contentPanel.add(txtLetra);

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(360, y, 50, 25);
        contentPanel.add(lblAnio);
        txtAnio = new JTextField();
        txtAnio.setBounds(400, y, 60, 25);
        txtAnio.setEnabled(false);
        contentPanel.add(txtAnio);

        JLabel lblFechaHora = new JLabel("Fecha Hora:");
        lblFechaHora.setBounds(20, y += 40, 100, 25);
        contentPanel.add(lblFechaHora);
        txtFechaHora = new JTextField();
        txtFechaHora.setBounds(120, y, 200, 25);
        txtFechaHora.setEnabled(false);
        contentPanel.add(txtFechaHora);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(330, y, 50, 25);
        contentPanel.add(lblTipo);
        txtTipo = new JTextField();
        txtTipo.setBounds(380, y, 100, 25);
        txtTipo.setEnabled(false);
        contentPanel.add(txtTipo);
        
        JLabel lblTipoTramite = new JLabel("Tipo de Trámite:");
        lblTipoTramite.setBounds(20, y += 40, 120, 25);
        contentPanel.add(lblTipoTramite);
        cmbTipoTramite = new JComboBox<>();
        cmbTipoTramite.setBounds(150, y, 200, 25);
        cmbTipoTramite.setEnabled(false);
        cmbTipoTramite.addItem(new TipoTramite(1, "Nueva habilitación", "", null));
        cmbTipoTramite.addItem(new TipoTramite(2, "Renovación", "", null));
        contentPanel.add(cmbTipoTramite);
        
        JLabel lblRubro = new JLabel("Rubro:");
        lblRubro.setBounds(20, y += 40, 100, 25);
        contentPanel.add(lblRubro);
        cmbRubro = new JComboBox<>();
        cmbRubro.setBounds(120, y, 200, 25);
        cmbRubro.setEnabled(false);
        contentPanel.add(cmbRubro);
        
        JLabel lblNombreApellido = new JLabel("Nombre y Apellido:");
        lblNombreApellido.setBounds(20, y += 40, 140, 25);
        contentPanel.add(lblNombreApellido);
        txtNombreApellido = new JTextField();
        txtNombreApellido.setBounds(160, y, 250, 25);
        txtNombreApellido.setEnabled(false);
        contentPanel.add(txtNombreApellido);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(20, y += 40, 100, 25);
        contentPanel.add(lblDni);
        txtDni = new JTextField();
        txtDni.setBounds(120, y, 150, 25);
        txtDni.setEnabled(false);
        contentPanel.add(txtDni);

        JLabel lblCuit = new JLabel("CUIT:");
        lblCuit.setBounds(280, y, 100, 25);
        contentPanel.add(lblCuit);
        txtCuit = new JTextField();
        txtCuit.setBounds(330, y, 150, 25);
        txtCuit.setEnabled(false);
        contentPanel.add(txtCuit);

        JLabel lblRazon = new JLabel("Razón Social:");
        lblRazon.setBounds(20, y += 40, 100, 25);
        contentPanel.add(lblRazon);
        txtRazonSocial = new JTextField();
        txtRazonSocial.setBounds(120, y, 200, 25);
        txtRazonSocial.setEnabled(false);
        contentPanel.add(txtRazonSocial);

        JLabel lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(20, y += 40, 100, 25);
        contentPanel.add(lblDomicilio);
        txtDomicilio = new JTextField();
        txtDomicilio.setBounds(120, y, 200, 25);
        txtDomicilio.setEnabled(false);
        contentPanel.add(txtDomicilio);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(330, y, 100, 25);
        contentPanel.add(lblTelefono);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(410, y, 120, 25);
        txtTelefono.setEnabled(false);
        contentPanel.add(txtTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(20, y += 40, 100, 25);
        contentPanel.add(lblCorreo);
        txtCorreo = new JTextField();
        txtCorreo.setBounds(120, y, 200, 25);
        txtCorreo.setEnabled(false);
        contentPanel.add(txtCorreo);
        
        JLabel lblObs = new JLabel("Observaciones:");
        lblObs.setBounds(20, y += 40, 100, 25);
        contentPanel.add(lblObs);
        txtObservaciones = new JTextArea();
        txtObservaciones.setBounds(120, y, 400, 60);
        txtObservaciones.setEnabled(false);
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        contentPanel.add(txtObservaciones);
        
        


        // Checklist
        String[] requisitos = {
            "Nota solicitud al intendente",
            "Ficha de inscripción",
            "Ficha de edificación y mensura",
            "Fotocopia del DNI",
            "Constancia de CUIT",
            "Inscripción ARCA",
            "Inscripción IIBB",
            "Inscripción Comercio Interior"
        };
        
        y += 80; 

        JLabel lblChecklistTitulo = new JLabel("Control de Requisitos:");
        lblChecklistTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        lblChecklistTitulo.setBounds(20, y, 300, 25);
        contentPanel.add(lblChecklistTitulo);

        y += 30; 

        // Crea los checkboxes
        checklist = new JCheckBox[requisitos.length];
        y += 10;
        for (int i = 0; i < requisitos.length; i++) {
            checklist[i] = new JCheckBox(requisitos[i]);
            checklist[i].setBounds(20, y, 300, 25);
            checklist[i].setEnabled(false);
            contentPanel.add(checklist[i]);
            y += 30;
        }

        // Botones
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, y, 100, 30);
        btnGuardar.setEnabled(false);
        contentPanel.add(btnGuardar);

        btnCargar = new JButton("Requisitos");
        btnCargar.setBounds(240, y, 100, 30);
        btnCargar.setEnabled(false);
        contentPanel.add(btnCargar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(350, y, 100, 30);
        btnCancelar.setEnabled(false);
        contentPanel.add(btnCancelar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(460, y, 100, 30);
        contentPanel.add(btnSalir);

        y += 50;
        btnBuscarExpediente = new JButton("Buscar Expediente");
        btnBuscarExpediente.setBounds(180, y, 200, 30);
        contentPanel.add(btnBuscarExpediente);

        // Eventos
        
        btnGuardar.addActionListener(e -> {
            if (expedienteSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Primero seleccione un expediente.");
                return;
            }

            // Leer los estados de los checkboxes y almacenarlos
            List<Boolean> estados = new java.util.ArrayList<>();
            for (JCheckBox chk : checklist) {
                estados.add(chk.isSelected());
            }

            expedienteSeleccionado.setRequisitos(estados);

            ExpedienteDAOJson.guardar(listaExpedientes);
            JOptionPane.showMessageDialog(this, "✅ Requisitos guardados correctamente.");

            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            for (JCheckBox chk : checklist) {
                chk.setEnabled(false);
            }
        });

        
        btnSalir.addActionListener(e -> dispose());

        // Buscar expediente y cargar sus datos
        btnBuscarExpediente.addActionListener(e -> {
            if (listaExpedientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay expedientes registrados.");
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
                btnCargar.setEnabled(true);   
                    
            }
        });


        // Cargar (habilita los checkboxes para edición)
        btnCargar.addActionListener(e -> {
            for (JCheckBox chk : checklist) {
                chk.setEnabled(true);
            }
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
        });

        btnCancelar.addActionListener(e -> {
            // Restaurar visualización de los checks del expediente actual
            List<Boolean> requisitosGuardados = expedienteSeleccionado != null ? expedienteSeleccionado.getRequisitos() : null;

            if (requisitosGuardados != null && requisitosGuardados.size() == checklist.length) {
                for (int i = 0; i < checklist.length; i++) {
                    checklist[i].setSelected(requisitosGuardados.get(i));
                    checklist[i].setEnabled(false);
                }
            } else {
                for (JCheckBox chk : checklist) {
                    chk.setSelected(false);
                    chk.setEnabled(false);
                }
            }

            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnCargar.setEnabled(true); // volver a permitir edición si se desea
        });

    }
    
    @Override
    protected void mostrarExpediente(Expediente expediente) {
        super.mostrarExpediente(expediente); // Llama a la base para cargar datos comunes
        
        // Asegura que las opciones estén cargadas antes de mostrar el dato
        if (cmbTipoTramite.getItemCount() == 0) {
            cmbTipoTramite.addItem(new TipoTramite(1, "Nueva habilitación", "", null));
            cmbTipoTramite.addItem(new TipoTramite(2, "Renovación", "", null));
        }

        if (cmbRubro.getItemCount() == 0) {
            cmbRubro.addItem(new Rubro(1, "Kiosko", "001", "", "", null));
            cmbRubro.addItem(new Rubro(2, "Carnicería", "002", "", "", null));
            cmbRubro.addItem(new Rubro(3, "Librería", "003", "", "", null));
        }
        
        // Selecciona en los combos los valores que ya tiene el expediente
        cmbTipoTramite.setSelectedItem(expediente.getTipoTramite());
        cmbRubro.setSelectedItem(expediente.getRubro());


        List<Boolean> requisitosGuardados = expediente.getRequisitos();
        if (requisitosGuardados != null && requisitosGuardados.size() == checklist.length) {
            for (int i = 0; i < checklist.length; i++) {
                checklist[i].setSelected(requisitosGuardados.get(i));
                checklist[i].setEnabled(false);
            }
        } else {
            // Limpia si no hay datos guardados
            for (JCheckBox chk : checklist) {
                chk.setSelected(false);
                chk.setEnabled(false);
            }
        }

        btnCargar.setEnabled(true);
    }

}
