import java.util.List;
import java.util.Scanner;

public class TiendaVista {
    private Scanner scanner;

    public TiendaVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n--- BIENVENIDO A LA TIENDA ---");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Ver Reseñas Globales");
        System.out.println("4. Salir");
    }

    public void mostrarMenuUsuario(String username) {
        System.out.println("\n--- MENÚ DE USUARIO (" + username + ") ---");
        System.out.println("1. Listar Productos Disponibles");
        System.out.println("2. Agregar Producto al Carrito");
        System.out.println("3. Ver Carrito y Calcular Total");
        System.out.println("4. Eliminar Producto del Carrito");
        System.out.println("5. Realizar Compra y Pagar");
        System.out.println("6. Dejar una Reseña/Calificación");
        System.out.println("7. Ver Historial de Compras");
        System.out.println("8. Cerrar Sesión");
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int solicitarEntero(String mensaje) {
        System.out.print(mensaje);
        int num = scanner.nextInt();
        scanner.nextLine(); 
        return num;
    }

    public void listarProductos(List<Producto> productos) {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre() + " - $" + productos.get(i).getPrecio());
        }
    }

    public void mostrarCarrito(List<Producto> carrito, double total) {
        System.out.println("\n--- TU CARRITO ---");
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            for (int i = 0; i < carrito.size(); i++) {
                System.out.println((i + 1) + ". " + carrito.get(i).getNombre() + " - $" + carrito.get(i).getPrecio());
            }
            System.out.println("Subtotal actual: $" + total);
        }
    }

    public void mostrarReseñas(List<Resena> reseñas) {
        System.out.println("\n--- RESEÑAS DE CLIENTES ---");
        if (reseñas.isEmpty()) {
            System.out.println("No hay reseñas aún.");
        } else {
            for (Resena r : reseñas) {
                System.out.println("[" + r.getUsuario() + "] Calificación: " + r.getCalificacion() + "/5 - " + r.getComentario());
            }
        }
    }

    public void mostrarHistorial(List<String> historial) {
        System.out.println("\n--- HISTORIAL DE COMPRAS ---");
        if (historial.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            for (String h : historial) {
                System.out.println("- " + h);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
