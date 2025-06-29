/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.modelo.*;
import sistemaexpedientes.controlador.ControladorExpediente;
import sistemaexpedientes.controlador.ControladorRubro;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
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
    private JTextField[] camposObservacion; 
    private ControladorExpediente controladorExpediente = new ControladorExpediente();
    private Sector sector;
    private List<ChecklistRequisitoComercio> checklistItems;
    private ControladorRubro controladorRubro = new ControladorRubro();



    // Constructor que recibe el sector (en este caso se espera que sea Comercio)
    public VentanaExpedienteComercio(Sector sector) {
        this(); // Llama al constructor sin parámetros primero
        this.sector = sector;
    

    }
    
    public VentanaExpedienteComercio() {
        configurarVista();
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

        JLabel lblNomenclatura = new JLabel("Nomenclatura:");
        lblNomenclatura.setBounds(20, y, 120, 25);
        contentPanel.add(lblNomenclatura);

        txtNomenclatura = new JTextField();
        txtNomenclatura.setBounds(140, y, 200, 25);
        txtNomenclatura.setEnabled(false);
        contentPanel.add(txtNomenclatura);


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
            "Inscripción Comercio Interior",
            "Contrato Social y Balance de Constitución",  
            "Plan de contingencia"                        
        };
        
        y += 80; 

        JLabel lblChecklistTitulo = new JLabel("Control de Requisitos:");
        lblChecklistTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        lblChecklistTitulo.setBounds(20, y, 300, 25);
        contentPanel.add(lblChecklistTitulo);

        y += 30; 

        // Crea los checkboxes y campos de observación
        checklist = new JCheckBox[requisitos.length];
        camposObservacion = new JTextField[requisitos.length];
        y += 10;

        for (int i = 0; i < requisitos.length; i++) {
            checklist[i] = new JCheckBox(requisitos[i]);
            checklist[i].setBounds(20, y, 300, 25);
            checklist[i].setEnabled(false);

            // Por defecto ocultamos los requisitos especiales
            if (requisitos[i].equalsIgnoreCase("Contrato Social y Balance de Constitución") ||
                requisitos[i].equalsIgnoreCase("Plan de contingencia")) {
                checklist[i].setVisible(false);
            }

            contentPanel.add(checklist[i]);

            camposObservacion[i] = new JTextField();
            camposObservacion[i].setBounds(330, y, 230, 25);
            camposObservacion[i].setEnabled(false);

            if (requisitos[i].equalsIgnoreCase("Contrato Social y Balance de Constitución") ||
                requisitos[i].equalsIgnoreCase("Plan de contingencia")) {
                camposObservacion[i].setVisible(false);
            }

            contentPanel.add(camposObservacion[i]);

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
            
            System.out.println("🔍 checklistItems size: " + (checklistItems != null ? checklistItems.size() : "null"));

            if (expedienteSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Primero seleccione un expediente.");
                return;
            }

            if (checklistItems == null || checklistItems.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se cargaron los requisitos correctamente.");
                return;
            }


            try {
                for (int i = 0; i < checklist.length; i++) {
                    ChecklistRequisitoComercio item = checklistItems.get(i);

                    // Guarda si el requisito está marcado
                    item.setCumplido(checklist[i].isSelected());

                    // Toma el texto escrito como observación para ese requisito
                    String observacion = camposObservacion[i].getText().trim();
                    item.setObservaciones(observacion);
                }

                ChecklistRequisitoDAOJdbc.guardarParaExpediente(expedienteSeleccionado.getIdExpediente(), checklistItems);
                JOptionPane.showMessageDialog(this, "✅ Requisitos guardados correctamente.");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Error al guardar requisitos: " + ex.getMessage());
                ex.printStackTrace();
            }

            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            for (JCheckBox chk : checklist) {
                chk.setEnabled(false);
            }
        });



        
        btnSalir.addActionListener(e -> dispose());

        // Buscar expediente y cargar sus datos desde la base
        btnBuscarExpediente.addActionListener(e -> {
            List<Expediente> expedientes = controladorExpediente.obtenerTodos();

            if (expedientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay expedientes registrados.");
                return;
            }

            Expediente seleccionado = (Expediente) JOptionPane.showInputDialog(
                this,
                "Seleccione un expediente:",
                "Buscar Expediente",
                JOptionPane.PLAIN_MESSAGE,
                null,
                expedientes.toArray(),
                null
            );

            if (seleccionado != null) {
                mostrarExpediente(seleccionado); 
                btnCargar.setEnabled(true);   
            }
        });


        btnCargar.addActionListener(e -> {
            // Habilita cada checkbox de requisitos y su campo de observación correspondiente
            for (int i = 0; i < checklist.length; i++) {
                checklist[i].setEnabled(true);              // Permitir marcar o desmarcar
                camposObservacion[i].setEnabled(true);      // Permitir editar la observación
            }

            // Habilita los botones de acción
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
        });


        btnCancelar.addActionListener(e -> {
            // Restaurar visualización de los requisitos usando los datos actuales en checklistItems
            if (checklistItems != null && checklistItems.size() == checklist.length) {
                for (int i = 0; i < checklist.length; i++) {
                    checklist[i].setSelected(checklistItems.get(i).isCumplido());
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
        super.mostrarExpediente(expediente);

        

        if (cmbTipoTramite.getItemCount() == 0) {
            List<TipoTramite> tipos = controladorExpediente.obtenerTiposTramite();
            for (TipoTramite tt : tipos) {
                cmbTipoTramite.addItem(tt);
            }
        }
        if (cmbRubro.getItemCount() == 0) {
            List<Rubro> rubros = controladorRubro.obtenerTodos();
            for (Rubro r : rubros) {
                cmbRubro.addItem(r);
            }
        }




        // Seleccionar en los combos el trámite y rubro actuales
        cmbTipoTramite.setSelectedItem(expediente.getTipoTramite());
        cmbRubro.setSelectedItem(expediente.getRubro());

        int idExp = expediente.getIdExpediente();
        if (idExp <= 0) {
            JOptionPane.showMessageDialog(this, "⚠️ Este expediente aún no está registrado en la base de datos.");
            checklistItems = new ArrayList<>();
            for (int i = 0; i < checklist.length; i++) {
                checklist[i].setSelected(false);
                checklist[i].setEnabled(false);
                camposObservacion[i].setText("");
                camposObservacion[i].setEnabled(false);
            }
            return;
        }

        
        checklistItems = ChecklistRequisitoDAOJdbc.obtenerPorExpediente(idExp);

        if (checklistItems == null || checklistItems.isEmpty()) {
            System.out.println("🟡 No se encontraron requisitos previos. Generando los requisitos base...");
            List<Requisito> requisitosBase = ChecklistRequisitoDAOJdbc.obtenerRequisitosBase();

            checklistItems = new ArrayList<>();
            for (Requisito r : requisitosBase) {
                ChecklistRequisitoComercio item = new ChecklistRequisitoComercio();
                item.setRequisito(r);
                item.setCumplido(false);
                item.setObservaciones("");
                item.setIdExpediente(idExp);
                checklistItems.add(item);
            }

            
            System.out.println("✅ Requisitos base guardados para expediente ID " + idExp);
        } else {
            System.out.println("✅ Requisitos cargados desde la base para expediente ID " + idExp);
        }
        //Agregar Plan de Contingencia si el rubro es de riesgo alto
        System.out.println("🔎 Rubro actual del expediente: " + expediente.getRubro());
        System.out.println("🔎 Rubro.isEsDeAltoRiesgo(): " + (expediente.getRubro() != null ? expediente.getRubro().isEsDeAltoRiesgo() : "null"));

        boolean requierePlanContingencia = expediente.getRubro() != null && expediente.getRubro().isEsDeAltoRiesgo();

        if (requierePlanContingencia) {
            boolean yaIncluido = checklistItems.stream()
                .anyMatch(item -> "Plan de contingencia".equalsIgnoreCase(item.getRequisito().getDescripcion()));

            if (!yaIncluido) {
                List<Requisito> requisitosBase = ChecklistRequisitoDAOJdbc.obtenerRequisitosBase();
                for (Requisito r : requisitosBase) {
                    if ("Plan de contingencia".equalsIgnoreCase(r.getDescripcion())) {
                        ChecklistRequisitoComercio extra = new ChecklistRequisitoComercio();
                        extra.setRequisito(r);
                        extra.setCumplido(false);
                        extra.setObservaciones("");
                        extra.setIdExpediente(idExp);
                        checklistItems.add(extra);
                        System.out.println("➕ Agregado requisito especial: Plan de contingencia");
                        break;
                    }
                }
            }
        }
        boolean esJuridico = expediente.getContribuyente() != null &&
                     "Jurídico".equalsIgnoreCase(expediente.getContribuyente().getTipoContribuyente());

        if (esJuridico) {
            boolean yaIncluido = checklistItems.stream()
                .anyMatch(item -> "Contrato Social y Balance de Constitución".equalsIgnoreCase(item.getRequisito().getDescripcion()));

            if (!yaIncluido) {
                List<Requisito> requisitosBase = ChecklistRequisitoDAOJdbc.obtenerRequisitosBase();
                for (Requisito r : requisitosBase) {
                    if ("Contrato Social y Balance de Constitución".equalsIgnoreCase(r.getDescripcion())) {
                        ChecklistRequisitoComercio extra = new ChecklistRequisitoComercio();
                        extra.setRequisito(r);
                        extra.setCumplido(false);
                        extra.setObservaciones("");
                        extra.setIdExpediente(idExp);
                        checklistItems.add(extra);
                        System.out.println("➕ Agregado requisito especial: Contrato Social y Balance de Constitución");
                        break;
                    }
                }
            }
        }



        // Mostrar requisitos en los controles
        int limite = Math.min(checklist.length, checklistItems.size());
        for (int i = 0; i < limite; i++) {
            ChecklistRequisitoComercio item = checklistItems.get(i);
            checklist[i].setSelected(item.isCumplido());
            checklist[i].setEnabled(false);

            camposObservacion[i].setText(item.getObservaciones() != null ? item.getObservaciones() : "");
            camposObservacion[i].setEnabled(false);
        }
        // Activar dinámicamente requisitos especiales
        System.out.println("🔎 esDeAltoRiesgo: " + expediente.getRubro().isEsDeAltoRiesgo());
        for (int i = 0; i < checklist.length; i++) {
            String nombre = checklist[i].getText();

            if ("Contrato Social y Balance de Constitución".equalsIgnoreCase(nombre)) {
                checklist[i].setVisible(esJuridico);
                camposObservacion[i].setVisible(esJuridico);
            }

            if ("Plan de contingencia".equalsIgnoreCase(nombre)) {
                boolean requiereContingencia = expediente.getRubro() != null &&
                                               expediente.getRubro().isEsDeAltoRiesgo();
                System.out.println("➡️ Requiere Contingencia: " + requiereContingencia);
                checklist[i].setVisible(requiereContingencia);
                camposObservacion[i].setVisible(requiereContingencia);
            }
        }

        btnCargar.setEnabled(true);
    }
    

}
