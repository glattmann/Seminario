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
 * Esta clase es el menú principal que ve el usuario de Mesa de Entrada.
 * Tiene dos botones: uno para registrar contribuyentes y otro para registrar expedientes.
 */
public class MenuMesaE extends JFrame {

    //Botones
    private JButton btnContribuyente;
    private JButton btnExpediente;

    public MenuMesaE() {
        setTitle("Mesa de Entrada");
        setSize(300, 200); // tamaño de la ventana
        setLayout(null); // posiciones absolutas
        setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar toda la app al cerrar esta ventana

        // Botón para abrir la ventana de contribuyentes
        btnContribuyente = new JButton("Gestionar Contribuyente");
        btnContribuyente.setBounds(50, 30, 200, 30);
        add(btnContribuyente);

        // Botón para abrir la ventana de expedientes
        btnExpediente = new JButton("Gestionar Expediente");
        btnExpediente.setBounds(50, 80, 200, 30);
        add(btnExpediente);

        // Acción del botón de contribuyente
        btnContribuyente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaContribuyente ventana = new VentanaContribuyente();
                ventana.setVisible(true);
            }
        });

        // Acción del botón de expediente
        btnExpediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sector mesa = new MesaEntrada(); // se crea el sector Mesa de Entrada
                VentanaExpedienteMesaEntrada ventana = new VentanaExpedienteMesaEntrada(); // se abre la ventana de expedientes
                ventana.setVisible(true);
            }
        });
    }

}
