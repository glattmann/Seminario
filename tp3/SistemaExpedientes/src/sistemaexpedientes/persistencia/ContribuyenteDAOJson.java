/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.persistencia;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sistemaexpedientes.modelo.Contribuyente;


/**
 *
 * @author GL
 */
/**
 * Esta clase se encarga de guardar y leer la lista de contribuyentes desde un archivo JSON.
 * Sirve como "puente" entre el modelo y el archivo.
 */

// Nombre del archivo donde se guardan los datos
public class ContribuyenteDAOJson {

    private static final String ARCHIVO = "contribuyentes.json";

    /**
     * Guarda toda la lista de contribuyentes en el archivo.
     */
    public static void guardar(List<Contribuyente> lista) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer); // convierte la lista a JSON y la escribe
        } catch (IOException e) {
            e.printStackTrace(); // muestra error si algo falla
        }
    }
    
    /**
     * Lee la lista de contribuyentes desde el archivo. 
     * Si no existe o hay error, devuelve una lista vacía.
     */
    public static List<Contribuyente> leer() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ARCHIVO)) {
            Type tipoLista = new TypeToken<List<Contribuyente>>(){}.getType(); // indica que es una lista de contribuyentes
            return gson.fromJson(reader, tipoLista); // convierte JSON a lista
        } catch (IOException e) {
            return new ArrayList<>(); // si no existe o falla, devuelve lista vacía
        }
    }
}
