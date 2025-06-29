package sistemaexpedientes.controlador;

import sistemaexpedientes.modelo.Contribuyente;

import java.util.List;

public class TestControlador {
    public static void main(String[] args) {
        ControladorContribuyente ctrl = new ControladorContribuyente();
        List<Contribuyente> lista = ctrl.obtenerTodos();

        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay contribuyentes.");
        } else {
            System.out.println("✅ Desde controlador:");
            lista.forEach(System.out::println);
        }
    }
}
