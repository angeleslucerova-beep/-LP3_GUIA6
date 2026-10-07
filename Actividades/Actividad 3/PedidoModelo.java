import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {

    private List<Pedido> pedidos;
    private List<Pedido> historial;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    // =========================
    // AGREGAR PEDIDO
    // =========================

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // =========================
    // OBTENER PEDIDOS
    // =========================

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // =========================
    // ELIMINAR PEDIDO
    // =========================

    public boolean eliminarPedido(int indice) {

        if (indice >= 0 && indice < pedidos.size()) {

            Pedido pedido = pedidos.get(indice);

            pedido.setEstado("Eliminado");

            // Guardar una copia en el historial
            Pedido copia = copiarPedido(pedido);
            historial.add(copia);

            // Eliminar de la lista de pedidos actuales
            pedidos.remove(indice);

            return true;
        }

        return false;
    }

    // =========================
    // ACTUALIZAR PEDIDO
    // =========================

    public boolean actualizarPedido(
            int indice,
            String nuevoNombre,
            String nuevoTipo) {

        if (indice >= 0 && indice < pedidos.size()) {

            Pedido pedido = pedidos.get(indice);

            pedido.setNombrePlato(nuevoNombre);
            pedido.setTipo(nuevoTipo);

            return true;
        }

        return false;
    }

    // =========================
    // BUSCAR PEDIDOS
    // =========================

    public List<Pedido> buscarPedidos(String texto) {

        List<Pedido> resultados = new ArrayList<>();

        for (Pedido pedido : pedidos) {

            if (pedido.getNombrePlato()
                    .toLowerCase()
                    .contains(texto.toLowerCase())
                    ||
                pedido.getTipo()
                    .toLowerCase()
                    .contains(texto.toLowerCase())) {

                resultados.add(pedido);
            }
        }

        return resultados;
    }

    // =========================
    // CONTAR PEDIDOS
    // =========================

    public int contarPedidos() {
        return pedidos.size();
    }

    // =========================
    // CONTAR POR TIPO
    // =========================

    public int contarPorTipo(String tipo) {

        int contador = 0;

        for (Pedido pedido : pedidos) {

            if (pedido.getTipo()
                    .equalsIgnoreCase(tipo)) {

                contador++;
            }
        }

        return contador;
    }

    // =========================
    // MARCAR COMO COMPLETO
    // =========================

    public boolean marcarComoCompleto(int indice) {

        if (indice >= 0 && indice < pedidos.size()) {

            Pedido pedido = pedidos.get(indice);

            if (pedido.getEstado()
                    .equalsIgnoreCase("Pendiente")) {

                pedido.setEstado("Completo");

                // Guardar una copia en el historial
                Pedido copia = copiarPedido(pedido);
                historial.add(copia);

                return true;
            }
        }

        return false;
    }

    // =========================
    // OBTENER PEDIDOS POR ESTADO
    // =========================

    public List<Pedido> obtenerPorEstado(String estado) {

        List<Pedido> resultados = new ArrayList<>();

        for (Pedido pedido : pedidos) {

            if (pedido.getEstado()
                    .equalsIgnoreCase(estado)) {

                resultados.add(pedido);
            }
        }

        return resultados;
    }

    // =========================
    // CONTAR PEDIDOS PENDIENTES
    // =========================

    public int contarPendientes() {

        int contador = 0;

        for (Pedido pedido : pedidos) {

            if (pedido.getEstado()
                    .equalsIgnoreCase("Pendiente")) {

                contador++;
            }
        }

        return contador;
    }

    // =========================
    // OBTENER HISTORIAL
    // =========================

    public List<Pedido> getHistorial() {
        return historial;
    }

    // =========================
    // CREAR COPIA DEL PEDIDO
    // =========================

    private Pedido copiarPedido(Pedido pedido) {

        Pedido copia = new Pedido(
            pedido.getNombrePlato(),
            pedido.getTipo()
        );

        copia.setEstado(
            pedido.getEstado()
        );

        return copia;
    }
}