import java.util.List;
import java.util.Scanner;

public class PedidoVista {

    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // =========================
    // SOLICITAR NOMBRE
    // =========================

    public String solicitarNombrePlato() {

        System.out.print(
            "Introduce el nombre del plato: "
        );

        return scanner.nextLine();
    }

    // =========================
    // SOLICITAR TIPO
    // =========================

    public String solicitarTipo() {

        System.out.print(
            "Introduce el tipo de plato: "
        );

        return scanner.nextLine();
    }

    // =========================
    // MOSTRAR PEDIDOS
    // =========================

    public void mostrarPedidos(
            List<Pedido> pedidos) {

        if (pedidos.isEmpty()) {

            System.out.println(
                "\nNo hay pedidos en la lista."
            );

        } else {

            System.out.println(
                "\n===== LISTA DE PEDIDOS ====="
            );

            for (int i = 0;
                 i < pedidos.size();
                 i++) {

                Pedido pedido = pedidos.get(i);

                System.out.println(
                    (i + 1) + ". " +
                    pedido.getNombrePlato() +
                    " | Tipo: " +
                    pedido.getTipo() +
                    " | Estado: " +
                    pedido.getEstado()
                );
            }
        }
    }

    // =========================
    // MOSTRAR MENÚ
    // =========================

    public void mostrarMenu() {

        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "         SISTEMA DE PEDIDOS"
        );

        System.out.println(
            "=========================================="
        );

        System.out.println(
            "1. Agregar Pedido"
        );

        System.out.println(
            "2. Mostrar Pedidos"
        );

        System.out.println(
            "3. Eliminar Pedido"
        );

        System.out.println(
            "4. Actualizar Pedido"
        );

        System.out.println(
            "5. Buscar Pedido"
        );

        System.out.println(
            "6. Contar Pedidos"
        );

        System.out.println(
            "7. Marcar Pedido como Completo"
        );

        System.out.println(
            "8. Mostrar Pedidos por Estado"
        );

        System.out.println(
            "9. Contar Pedidos Pendientes"
        );

        System.out.println(
            "10. Mostrar Historial de Pedidos"
        );

        System.out.println(
            "11. Salir"
        );

        System.out.println(
            "=========================================="
        );
    }

    // =========================
    // SOLICITAR OPCIÓN
    // =========================

    public String solicitarOpcion() {

        System.out.print(
            "Selecciona una opción: "
        );

        return scanner.nextLine();
    }

    // =========================
    // SOLICITAR ÍNDICE
    // =========================

    public int solicitarIndice() {

        System.out.print(
            "Introduce el número del pedido: "
        );

        try {

            return Integer.parseInt(
                scanner.nextLine()
            ) - 1;

        } catch (NumberFormatException e) {

            return -1;
        }
    }

    // =========================
    // SOLICITAR BÚSQUEDA
    // =========================

    public String solicitarBusqueda() {

        System.out.print(
            "Introduce el nombre o tipo que deseas buscar: "
        );

        return scanner.nextLine();
    }

    // =========================
    // SOLICITAR ESTADO
    // =========================

    public String solicitarEstado() {

        System.out.println(
            "\nEstados disponibles:"
        );

        System.out.println(
            "1. Pendiente"
        );

        System.out.println(
            "2. Completo"
        );

        System.out.print(
            "Selecciona el estado: "
        );

        String opcion = scanner.nextLine();

        if (opcion.equals("1")) {
            return "Pendiente";
        }

        if (opcion.equals("2")) {
            return "Completo";
        }

        return "";
    }

    // =========================
    // MOSTRAR CANTIDAD TOTAL
    // =========================

    public void mostrarCantidadTotal(
            int cantidad) {

        System.out.println(
            "\nCantidad total de pedidos: "
            + cantidad
        );
    }

    // =========================
    // MOSTRAR CANTIDAD POR TIPO
    // =========================

    public void mostrarCantidadPorTipo(
            String tipo,
            int cantidad) {

        System.out.println(
            "Cantidad de pedidos de tipo '" +
            tipo +
            "': " +
            cantidad
        );
    }

    // =========================
    // MOSTRAR PENDIENTES
    // =========================

    public void mostrarCantidadPendientes(
            int cantidad) {

        System.out.println(
            "\nCantidad de pedidos pendientes: "
            + cantidad
        );
    }

    // =========================
    // MOSTRAR MENSAJE
    // =========================

    public void mostrarMensaje(
            String mensaje) {

        System.out.println(
            "\n" + mensaje
        );
    }

    // =========================
    // CERRAR SCANNER
    // =========================

    public void cerrarScanner() {

        scanner.close();
    }
}