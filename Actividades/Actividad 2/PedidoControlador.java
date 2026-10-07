import java.util.List;

public class PedidoControlador {

    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(
            PedidoModelo modelo,
            PedidoVista vista) {

        this.modelo = modelo;
        this.vista = vista;
    }

    // Agregar pedido
    public void agregarPedido(
            String nombrePlato,
            String tipo) {

        if (nombrePlato.isEmpty()) {

            vista.mostrarMensaje(
                "El nombre del plato no puede estar vacío."
            );

            return;
        }

        if (tipo.isEmpty()) {

            vista.mostrarMensaje(
                "El tipo del plato no puede estar vacío."
            );

            return;
        }

        Pedido nuevoPedido =
            new Pedido(nombrePlato, tipo);

        modelo.agregarPedido(nuevoPedido);

        vista.mostrarMensaje(
            "Pedido agregado correctamente."
        );
    }

    // Mostrar pedidos
    public void mostrarPedidos() {

        List<Pedido> pedidos =
            modelo.getPedidos();

        vista.mostrarPedidos(pedidos);
    }

    // Eliminar pedido
    public void eliminarPedido() {

        mostrarPedidos();

        if (modelo.getPedidos().isEmpty()) {
            return;
        }

        int indice = vista.solicitarIndice();

        boolean eliminado =
            modelo.eliminarPedido(indice);

        if (eliminado) {

            vista.mostrarMensaje(
                "Pedido eliminado correctamente."
            );

        } else {

            vista.mostrarMensaje(
                "Número de pedido inválido."
            );
        }
    }

    // Actualizar pedido
    public void actualizarPedido() {

        mostrarPedidos();

        if (modelo.getPedidos().isEmpty()) {
            return;
        }

        int indice = vista.solicitarIndice();

        if (indice < 0 ||
            indice >= modelo.getPedidos().size()) {

            vista.mostrarMensaje(
                "Número de pedido inválido."
            );

            return;
        }

        String nuevoNombre =
            vista.solicitarNombrePlato();

        String nuevoTipo =
            vista.solicitarTipo();

        boolean actualizado =
            modelo.actualizarPedido(
                indice,
                nuevoNombre,
                nuevoTipo
            );

        if (actualizado) {

            vista.mostrarMensaje(
                "Pedido actualizado correctamente."
            );

        } else {

            vista.mostrarMensaje(
                "No se pudo actualizar el pedido."
            );
        }
    }

    // Buscar pedido
    public void buscarPedido() {

        String texto =
            vista.solicitarBusqueda();

        List<Pedido> resultados =
            modelo.buscarPedidos(texto);

        if (resultados.isEmpty()) {

            vista.mostrarMensaje(
                "No se encontraron pedidos."
            );

        } else {

            vista.mostrarMensaje(
                "Resultados de la búsqueda:"
            );

            vista.mostrarPedidos(resultados);
        }
    }

    // Contar pedidos
    public void contarPedidos() {

        int total =
            modelo.contarPedidos();

        vista.mostrarCantidadTotal(total);

        String tipo =
            vista.solicitarTipo();

        int cantidadTipo =
            modelo.contarPorTipo(tipo);

        vista.mostrarCantidadPorTipo(
            tipo,
            cantidadTipo
        );
    }

    // Iniciar aplicación
    public void iniciar() {

        String opcion;

        do {

            vista.mostrarMenu();

            opcion =
                vista.solicitarOpcion();

            switch (opcion) {

                case "1":

                    String nombre =
                        vista.solicitarNombrePlato();

                    String tipo =
                        vista.solicitarTipo();

                    agregarPedido(
                        nombre,
                        tipo
                    );

                    break;

                case "2":

                    mostrarPedidos();

                    break;

                case "3":

                    eliminarPedido();

                    break;

                case "4":

                    actualizarPedido();

                    break;

                case "5":

                    buscarPedido();

                    break;

                case "6":

                    contarPedidos();

                    break;

                case "7":

                    vista.mostrarMensaje(
                        "Saliendo del sistema..."
                    );

                    break;

                default:

                    vista.mostrarMensaje(
                        "Opción no válida. Inténtalo de nuevo."
                    );
            }

        } while (!opcion.equals("7"));

        vista.cerrarScanner();
    }
}
