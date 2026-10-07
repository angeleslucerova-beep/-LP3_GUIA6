import java.util.List;
import java.util.Scanner;

public class PedidoVista {

    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {

        System.out.print("Introduce el nombre del plato: ");

        return scanner.nextLine();
    }

    public String solicitarTipo() {

        System.out.print("Introduce el tipo de plato: ");

        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {

        if (pedidos.isEmpty()) {

            System.out.println("\nNo hay pedidos en la lista.");

        } else {

            System.out.println("\n===== LISTA DE PEDIDOS =====");

            for (int i = 0; i < pedidos.size(); i++) {

                Pedido pedido = pedidos.get(i);

                System.out.println(
                    (i + 1) + ". " +
                    pedido.getNombrePlato() +
                    " | Tipo: " +
                    pedido.getTipo()
                );
            }
        }
    }

    public void mostrarMenu() {

        System.out.println("\n================================");
        System.out.println("       SISTEMA DE PEDIDOS");
        System.out.println("================================");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
        System.out.println("================================");
    }

    public String solicitarOpcion() {

        System.out.print("Selecciona una opción: ");

        return scanner.nextLine();
    }

    public int solicitarIndice() {

        System.out.print("Introduce el número del pedido: ");

        try {

            return Integer.parseInt(scanner.nextLine()) - 1;

        } catch (NumberFormatException e) {

            return -1;
        }
    }

    public String solicitarBusqueda() {

        System.out.print(
            "Introduce el nombre o tipo que deseas buscar: "
        );

        return scanner.nextLine();
    }

    public void mostrarCantidadTotal(int cantidad) {

        System.out.println(
            "\nCantidad total de pedidos: " + cantidad
        );
    }

    public void mostrarCantidadPorTipo(
            String tipo,
            int cantidad) {

        System.out.println(
            "Cantidad de pedidos de tipo '" +
            tipo + "': " + cantidad
        );
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println("\n" + mensaje);
    }

    public void cerrarScanner() {

        scanner.close();
    }
}