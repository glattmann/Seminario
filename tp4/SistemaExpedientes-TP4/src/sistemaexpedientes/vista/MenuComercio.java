/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.modelo.Comercio;
import sistemaexpedientes.modelo.Sector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author GL
 */
/**
 * Esta clase es una ventana simple que representa el menú para el sector Comercio.
 * Tiene un solo botón que abre la ventana de checklist de requisitos.
 */
public class MenuComercio extends JFrame {

    private JButton btnRequisitos; // botón para abrir el checklist

    public MenuComercio() {
        setTitle("Comercio - Menú");
        setSize(300, 200); // tamaño básico de la ventana
        setLayout(null); // Layout absoluto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // solo cierra esta ventana, no toda la app

        // Botón que abre la ventana para gestionar el checklist de requisitos
        btnRequisitos = new JButton("Checklist Requisitos");
        btnRequisitos.setBounds(50, 50, 200, 40); // Ubicación en la ventana
        add(btnRequisitos);

        // Acción cuando se hace click en el botón
        btnRequisitos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instanciando comercio
                Sector comercio = new Comercio();
                VentanaExpedienteComercio ventana = new VentanaExpedienteComercio(comercio);
                ventana.setVisible(true);
            }
        });
    }
    
}
