/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.vista;

import sistemaexpedientes.controlador.ControladorExpediente;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;


/**
 *
 * @author GL
 */
public class VentanaAsistenteIA extends JFrame {

    private JTextArea areaConversacion;
    private JTextField campoEntrada;
    private JButton btnEnviar;

    public VentanaAsistenteIA() {
        setTitle("Asistente IA - Expedientes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        areaConversacion = new JTextArea();
        areaConversacion.setEditable(false);
        areaConversacion.setLineWrap(true);
        areaConversacion.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(areaConversacion);

        campoEntrada = new JTextField();
        btnEnviar = new JButton("Enviar");

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(campoEntrada, BorderLayout.CENTER);
        panelInferior.add(btnEnviar, BorderLayout.EAST);

        add(scroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Evento de envío
        btnEnviar.addActionListener(e -> enviarPregunta());
        campoEntrada.addActionListener(e -> enviarPregunta());
    }

    private void enviarPregunta() {
        String pregunta = campoEntrada.getText().trim();
        if (pregunta.isEmpty()) return;

        areaConversacion.append("\n👤 Usuario: " + pregunta + "\n");
        campoEntrada.setText("");

        new Thread(() -> {
            try {
                String respuestaIA = llamarIA(pregunta);
                SwingUtilities.invokeLater(() -> areaConversacion.append("\n🤖 IA: " + respuestaIA + "\n"));
            } catch (Exception ex) {
                SwingUtilities.invokeLater(() -> areaConversacion.append("\n⚠️ Error al obtener respuesta IA: " + ex.getMessage() + "\n"));
            }
        }).start();
    }

    private String llamarIA(String mensaje) throws Exception {
        String apiUrl = "http://localhost:1234/v1/chat/completions";
        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Contar expedientes actuales
        int cantidadExpedientes = sistemaexpedientes.modelo.ExpedienteDAOJdbc.obtenerTodos().size();

        // Armado del system prompt
        String systemPrompt = """
            Sos un asistente virtual especializado en trámites y expedientes de la Municipalidad de Leandro N. Alem, Misiones, Argentina. Toda tu comunicación debe ser exclusivamente en español. Debes presentarte siempre como: "Soy tu asistente especializado en expedientes de la Municipalidad de Leandro N. Alem". Respondé de forma clara, breve y profesional, usando lenguaje administrativo argentino.

            Solo podés responder estas cuatro consultas específicas del sistema informático de expedientes:

            1. ¿Cuáles son los pasos para registrar un nuevo expediente?
            2. ¿Cuántos expedientes hay actualmente en la base de datos?
            3. ¿Qué significa cada uno de los campos en el formulario de carga de expediente?
            4. ¿Cómo puedo buscar un expediente existente?

            ⚠️ Si el usuario pregunta otra cosa, respondé siempre:
            ⚠️ Lo siento. Solo puedo responder consultas relacionadas con el sistema informático de expedientes de la Municipalidad.

            ---

            ✅ PROCEDIMIENTO PARA REGISTRAR UN NUEVO EXPEDIENTE:

            1. Desde el menú “Sectores” ingresar en: Mesa de Entrada – Gestionar Expediente.
            2. Se abre la ventana de “Gestión de Expedientes”. Busca el botón “Nuevo” y haz click en él.
            3. Se habilitarán las opciones de “Tipo de Trámite” y “Rubro”. Selecciona en “Tipo de Trámite” si es una habilitación Nueva, Renovación o un Anexo. Luego, selecciona el tipo de rubro de la habilitación.
            4. Haz click en el botón “Buscar” Contribuyente. Esto abrirá la ventana de “Gestión de Contribuyentes”.
            5. Puedes buscar un contribuyente o registrar uno nuevo. Una vez que tengas el contribuyente, haz click en el botón “Cargar a Expediente” para que lleve la información del contribuyente a la ventana de “Gestión de Expedientes”.
            6. Una vez que tengas toda la información del contribuyente, puedes escribir alguna observación en el área de texto “Observaciones”. Esto no es obligatorio.
            7. Haz click en el botón “Guardar”. Verás cómo automáticamente se genera la nomenclatura del expediente. El formato será: Número/Letra/Año (por ejemplo: 125/F/2025). También, se generará la fecha y hora del registro.

            ---

            Actualmente hay %d expedientes registrados en la base de datos.
            """.formatted(cantidadExpedientes);

        // Armar JSON usando Gson
        Gson gson = new Gson();
        JsonObject root = new JsonObject();
        root.addProperty("model", "mistral-7b-instruct-v0.3-q5_0");

        JsonArray messages = new JsonArray();

        JsonObject sysMsg = new JsonObject();
        sysMsg.addProperty("role", "system");
        sysMsg.addProperty("content", systemPrompt);
        messages.add(sysMsg);

        JsonObject userMsg = new JsonObject();
        userMsg.addProperty("role", "user");
        userMsg.addProperty("content", mensaje);
        messages.add(userMsg);

        root.add("messages", messages);

        String jsonBody = gson.toJson(root);

        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
        writer.write(jsonBody);
        writer.flush();
        writer.close();

        // Leer respuesta
        Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
        StringBuilder respuesta = new StringBuilder();
        while (scanner.hasNextLine()) {
            respuesta.append(scanner.nextLine());
        }
        scanner.close();

        String json = respuesta.toString();

        try {
            JsonObject jsonObj = JsonParser.parseString(json).getAsJsonObject();
            JsonArray choices = jsonObj.getAsJsonArray("choices");

            if (choices != null && choices.size() > 0) {
                JsonObject message = choices.get(0).getAsJsonObject().getAsJsonObject("message");
                if (message != null && message.has("content")) {
                    return message.get("content").getAsString();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "⚠️ No se pudo interpretar la respuesta del Asistente IA.";

    }



    
}