/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.modelo.MesaEntrada;
import sistemaexpedientes.modelo.Sector;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author GL
 */
/**
 * Clase de inicio de la aplicación. Posee el método main.
 * Esta clase muestra un menú general con todos los sectores del sistema.
 * Solo algunos botones están habilitados por ahora (Mesa de Entrada y Comercio).
 */
public class MenuSectores extends JFrame {

    public MenuSectores() {
        setTitle("Menú de Sectores");
        setSize(400, 400); // tamaño de la ventana
        setLayout(null); // posiciones absolutas
        setDefaultCloseOperation(EXIT_ON_CLOSE); // cierra toda la app al cerrar esta ventana

        // Botón Mesa de Entrada
        JButton btnMesaEntrada = new JButton("Mesa de Entrada");
        btnMesaEntrada.setBounds(100, 30, 200, 30);
        add(btnMesaEntrada);

        // Botón Comercio 
        JButton btnComercio = new JButton("Comercio");
        btnComercio.setBounds(100, 70, 200, 30);
        btnComercio.setEnabled(true);
        add(btnComercio);

        // Botones de sectores deshabilitados (para etapas futuras)
        JButton btnCatastro = new JButton("Catastro");
        btnCatastro.setBounds(100, 110, 200, 30);
        btnCatastro.setEnabled(false);
        add(btnCatastro);

        JButton btnObrasPrivadas = new JButton("Obras Privadas");
        btnObrasPrivadas.setBounds(100, 150, 200, 30);
        btnObrasPrivadas.setEnabled(false);
        add(btnObrasPrivadas);

        JButton btnMedioambiente = new JButton("Medioambiente");
        btnMedioambiente.setBounds(100, 190, 200, 30);
        btnMedioambiente.setEnabled(false);
        add(btnMedioambiente);

        JButton btnInmueble = new JButton("Inmueble");
        btnInmueble.setBounds(100, 230, 200, 30);
        btnInmueble.setEnabled(false);
        add(btnInmueble);

        JButton btnRentas = new JButton("Dirección de Rentas");
        btnRentas.setBounds(100, 270, 200, 30);
        btnRentas.setEnabled(false);
        add(btnRentas);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 310, 200, 30);
        add(btnSalir);

        // Acción para ir al menú de Mesa de Entrada
        btnMesaEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                MenuMesaE menu = new MenuMesaE(); // abre el menú de Mesa de Entrada
                menu.setVisible(true);
            }
        });
        // Acción para ir al menú de Comercio
        btnComercio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            MenuComercio menu = new MenuComercio(); // abre el menú de Comercio
            menu.setVisible(true);
    }
});

        // Acción para cerrar esta ventana
        btnSalir.addActionListener(e -> dispose());
    }

    // Método main para ejecutar esta ventana directamente
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuSectores().setVisible(true));
    }
} 
