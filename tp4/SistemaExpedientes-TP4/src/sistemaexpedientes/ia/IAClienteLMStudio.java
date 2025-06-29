package sistemaexpedientes.ia;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class IAClienteLMStudio {

    private static final String API_URL = "http://localhost:1234/v1/chat/completions";
    private static final String MODEL = "mistral-7b-instruct-v0.3";  

    public static String consultarIA(String pregunta) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{\n" +
                    "  \"model\": \"" + MODEL + "\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + pregunta + "\"}\n" +
                    "  ]\n" +
                    "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            StringBuilder respuesta = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    respuesta.append(responseLine.trim());
                }
            }

            conn.disconnect();

            // Extraer solo el texto de la respuesta JSON (simplificado)
            String fullResponse = respuesta.toString();
            int start = fullResponse.indexOf("\"content\":\"") + 10;
            int end = fullResponse.indexOf("\"", start);
            if (start > 9 && end > start) {
                return fullResponse.substring(start, end).replace("\\n", "\n");
            } else {
                return "⚠️ No se pudo interpretar la respuesta de la IA.";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Error al contactar la IA: " + e.getMessage();
        }
    }
}
