import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarInventario(List<Item> items) {
        System.out.println("\n=== INVENTARIO ACTUAL ===");
        if (items.isEmpty()) {
            System.out.println("El inventario está completamente vacío.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                System.out.println((i + 1) + ". " + item.getNombre() + " (Cant: " + item.getCantidad() + ") [" + item.getTipo() + "]");
            }
        }
    }

    public void mostrarDetallesItem(Item item) {
        System.out.println("\n--- DETALLES DEL OBJETO ---");
        System.out.println("Nombre: " + item.getNombre());
        System.out.println("Cantidad: " + item.getCantidad());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Descripción: " + item.getDescripcion());
    }

    public void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN DE INVENTARIOS ---");
        System.out.println("1. Mostrar Inventario Completo");
        System.out.println("2. Agregar Nuevo Objeto (Item)");
        System.out.println("3. Eliminar un Objeto del Inventario");
        System.out.println("4. Buscar Objeto por Nombre y Ver Detalles");
        System.out.println("5. Usar un Objeto del Inventario");
        System.out.println("6. Salir");
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int solicitarEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, introduce un número válido: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); 
        return num;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
