import java.util.List;
import java.util.Scanner;

public class CombateVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarEstado(Jugador j, Enemigo e) {
        System.out.println("\n========================================");
        System.out.println(" JUGADOR: " + j.getNombre() + " (Nivel " + j.getNivel() + ") | HP: " + j.getSalud());
        System.out.println(" Arma Equipada: " + (j.getArmaEquipada() != null ? j.getArmaEquipada().getNombre() : "Ninguna"));
        System.out.println("----------------------------------------");
        System.out.println(" ENEMIGO: " + e.getNombre() + " (" + e.getTipo() + ") | HP: " + e.getSalud());
        System.out.println("========================================");
    }

    public void mostrarMenu() {
        System.out.println("Acciones disponibles:");
        System.out.println("1. Atacar al enemigo");
        System.out.println("2. Ver Inventario / Usar Objeto");
        System.out.print("Selecciona tu jugada: ");
    }

    public String leerOpcion() {
        return scanner.nextLine();
    }

    public void mostrarInventario(List<Item> items) {
        System.out.println("\n--- INVENTARIO ---");
        if (items.isEmpty()) {
            System.out.println("Tu mochila esta vacia.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                System.out.println(i + ". " + item.getNombre() + " x" + item.getCantidad() + " (" + item.getTipo() + ") - " + item.getDescripcion());
            }
            System.out.print("Digita el numero del objeto para usar o equipar (o -1 para regresar): ");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
