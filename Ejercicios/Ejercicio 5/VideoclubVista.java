import java.util.List;
import java.util.Scanner;

public class VideoclubVista {
    private Scanner entrada = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== VIDEOCLUB CINEBANK ===");
        System.out.println("1. Agregar pelicula al catalogo");
        System.out.println("2. Mostrar catalogo completo");
        System.out.println("3. Rentar una pelicula");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public String obtenerOpcion() { return entrada.nextLine(); }

    public String pedirTexto(String campo) {
        System.out.print("Ingrese " + campo + ": ");
        return entrada.nextLine();
    }

    public void imprimirCatalogo(List<Pelicula> peliculas) {
        System.out.println("\n--- CATALOGO ---");
        if (peliculas.isEmpty()) {
            System.out.println("No hay titulos disponibles.");
        } else {
            for (int i = 0; i < peliculas.size(); i++) {
                Pelicula p = peliculas.get(i);
                String estado = p.isDisponible() ? "DISPONIBLE" : "RENTADA";
                System.out.println(i + ". (" + estado + ") " + p.getTitulo() + " - Genero: " + p.getGenero());
            }
        }
    }

    public void mostrarMensaje(String msg) { System.out.println(msg); }
}
