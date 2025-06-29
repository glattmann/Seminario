package sistemaexpedientes.modelo;

import java.util.List;

public class TestContribuyenteDAO {
    public static void main(String[] args) {
        List<Contribuyente> contribuyentes = ContribuyenteDAOJdbc.obtenerTodos();

        if (contribuyentes.isEmpty()) {
            System.out.println("⚠️ No se encontraron contribuyentes en la base de datos.");
        } else {
            System.out.println("✅ Lista de contribuyentes:");
            for (Contribuyente c : contribuyentes) {
                System.out.println(c);
            }
        }
    }
}
