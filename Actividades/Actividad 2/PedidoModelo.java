import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {

    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    // Agregar un pedido
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Obtener todos los pedidos
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // Eliminar un pedido por posición
    public boolean eliminarPedido(int indice) {

        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.remove(indice);
            return true;
        }

        return false;
    }

    // Actualizar un pedido
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

    // Buscar pedidos por nombre o tipo
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

    // Contar todos los pedidos
    public int contarPedidos() {
        return pedidos.size();
    }

    // Contar pedidos según el tipo
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
}