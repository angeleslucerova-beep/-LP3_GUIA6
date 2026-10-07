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

    // ========================================
    // AGREGAR PEDIDO
    // ========================================

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
            new Pedido(
                nombrePlato,
                tipo
            );

        modelo.agregarPedido(
            nuevoPedido
        );

        vista.mostrarMensaje(
            "Pedido agregado correctamente."
        );
    }

    // ========================================
    // MOSTRAR PEDIDOS
    // ========================================

    public void mostrarPedidos() {

        List<Pedido> pedidos =
            modelo.getPedidos();

        vista.mostrarPedidos(
            pedidos
        );
    }

    // ========================================
    // ELIMINAR PEDIDO
    // ========================================

    public void eliminarPedido() {

        mostrarPedidos();

        if (modelo.getPedidos().isEmpty()) {
            return;
        }

        int indice =
            vista.solicitarIndice();

        boolean eliminado =
            modelo.eliminarPedido(
                indice
            );

        if (eliminado) {

            vista.mostrarMensaje(
                "Pedido eliminado correctamente y enviado al historial."
            );

        } else {

            vista.mostrarMensaje(
                "Número de pedido inválido."
            );
        }
    }

    // ========================================
    // ACTUALIZAR PEDIDO
    // ========================================

    public void actualizarPedido() {

        mostrarPedidos();

        if (modelo.getPedidos().isEmpty()) {
            return;
        }

        int indice =
            vista.solicitarIndice();

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

    // ========================================
    // BUSCAR PEDIDO
    // ========================================

    public void buscarPedido() {

        String texto =
            vista.solicitarBusqueda();

        List<Pedido> resultados =
            modelo.buscarPedidos(
                texto
            );

        if (resultados.isEmpty()) {

            vista.mostrarMensaje(
                "No se encontraron pedidos."
            );

        } else {

            vista.mostrarMensaje(
                "Resultados de la búsqueda:"
            );

            vista.mostrarPedidos(
                resultados
            );
        }
    }

    // ========================================
    // CONTAR PEDIDOS
    // ========================================

    public void contarPedidos() {

        int total =
            modelo.contarPedidos();

        vista.mostrarCantidadTotal(
            total
        );

        String tipo =
            vista.solicitarTipo();

        int cantidadTipo =
            modelo.contarPorTipo(
                tipo
            );

        vista.mostrarCantidadPorTipo(
            tipo,
            cantidadTipo
        );
    }

    // ========================================
    // MARCAR PEDIDO COMO COMPLETO
    // ========================================

    public void marcarPedidoCompleto() {

        mostrarPedidos();

        if (modelo.getPedidos().isEmpty()) {
            return;
        }

        int indice =
            vista.solicitarIndice();

        boolean completado =
            modelo.marcarComoCompleto(
                indice
            );

        if (completado) {

            vista.mostrarMensaje(
                "Pedido marcado como completo correctamente."
            );

        } else {

            vista.mostrarMensaje(
                "No se pudo completar el pedido. " +
                "Verifica el número o si ya está completo."
            );
        }
    }

    // ========================================
    // MOSTRAR PEDIDOS POR ESTADO
    // ========================================

    public void mostrarPedidosPorEstado() {

        String estado =
            vista.solicitarEstado();

        if (estado.isEmpty()) {

            vista.mostrarMensaje(
                "Estado no válido."
            );

            return;
        }

        List<Pedido> resultados =
            modelo.obtenerPorEstado(
                estado
            );

        if (resultados.isEmpty()) {

            vista.mostrarMensaje(
                "No existen pedidos con estado: "
                + estado
            );

        } else {

            vista.mostrarMensaje(
                "Pedidos con estado: "
                + estado
            );

            vista.mostrarPedidos(
                resultados
            );
        }
    }

    // ========================================
    // CONTAR PEDIDOS PENDIENTES
    // ========================================

    public void contarPedidosPendientes() {

        int cantidad =
            modelo.contarPendientes();

        vista.mostrarCantidadPendientes(
            cantidad
        );
    }

    // ========================================
    // MOSTRAR HISTORIAL
    // ========================================

    public void mostrarHistorial() {

        List<Pedido> historial =
            modelo.getHistorial();

        if (historial.isEmpty()) {

            vista.mostrarMensaje(
                "El historial está vacío."
            );

        } else {

            vista.mostrarMensaje(
                "===== HISTORIAL DE PEDIDOS ====="
            );

            vista.mostrarPedidos(
                historial
            );
        }
    }

    // ========================================
    // INICIAR APLICACIÓN
    // ========================================

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

                    marcarPedidoCompleto();

                    break;

                case "8":

                    mostrarPedidosPorEstado();

                    break;

                case "9":

                    contarPedidosPendientes();

                    break;

                case "10":

                    mostrarHistorial();

                    break;

                case "11":

                    vista.mostrarMensaje(
                        "Saliendo del sistema..."
                    );

                    break;

                default:

                    vista.mostrarMensaje(
                        "Opción no válida. " +
                        "Inténtalo de nuevo."
                    );
            }

        } while (!opcion.equals("11"));

        vista.cerrarScanner();
    }
}