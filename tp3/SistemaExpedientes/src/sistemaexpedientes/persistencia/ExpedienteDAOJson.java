/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.persistencia;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sistemaexpedientes.modelo.Expediente;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GL
 */
/**
 * Esta clase sirve para guardar y leer los expedientes desde un archivo JSON.
 * Básicamente hace de "DAO" pero usando Gson.
 */
public class ExpedienteDAOJson {
    
    // Archivo donde se guarda todo
    private static final String ARCHIVO = "expedientes.json";

    /**
     * Guarda una lista de expedientes en el archivo JSON.
     */
    public static void guardar(List<Expediente> lista) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee el archivo JSON y devuelve la lista de expedientes.
     * Si hay algún problema, devuelve una lista vacía.
     */
    public static List<Expediente> leer() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ARCHIVO)) {
            Type tipoLista = new TypeToken<List<Expediente>>(){}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>(); // si no existe o falla, devuelve lista vacía
        }
    }
    /**
     * Este método busca cuál es el último número usado de expediente
     * y devuelve el siguiente disponible.
     */
    public static int obtenerProximoNumero(List<Expediente> lista) {
        return lista.stream()
                .mapToInt(Expediente::getNumero) // Toma los números de expediente
                .max() // busca el más alto
                .orElse(0) + 1; // si no hay ninguno, empieza en 1
    }

}

    

