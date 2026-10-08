import java.util.List;

public class InventarioController {
    private InventarioModel model;
    private InventarioView view;

    public InventarioController(InventarioModel model, InventarioView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            view.mostrarMenu();
            opcion = view.solicitarEntero("Seleccione una opción: ");
            procesarOpcion(opcion);
        } while (opcion != 6);
        view.cerrarScanner();
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                verInventario();
                break;
            case 2:
                agregarItem();
                break;
            case 3:
                eliminarItem();
                break;
            case 4:
                buscarItem();
                break;
            case 5:
                usarItem();
                break;
            case 6:
                view.mostrarMensaje("Saliendo del sistema de inventarios...");
                break;
            default:
                view.mostrarMensaje("Opción inválida. Intente de nuevo.");
        }
    }

    public void verInventario() {
        List<Item> items = model.obtenerItems();
        view.mostrarInventario(items);
    }

    public void agregarItem() {
        String nombre = view.solicitarTexto("Nombre del nuevo objeto: ");
        int cantidad = view.solicitarEntero("Cantidad inicial: ");
        String tipo = view.solicitarTexto("Tipo (Arma, Poción, etc.): ");
        String descripcion = view.solicitarTexto("Descripción corta: ");

        Item nuevoItem = new Item(nombre, cantidad, tipo, descripcion);
        model.agregarItem(nuevoItem);
        view.mostrarMensaje("¡Objeto añadido correctamente!");
    }

    public void eliminarItem() {
        verInventario();
        List<Item> lista = model.obtenerItems();
        if (lista.isEmpty()) return;

        int indice = view.solicitarEntero("Ingrese el número del objeto a eliminar: ") - 1;
        if (indice >= 0 && indice < lista.size()) {
            Item removido = lista.get(indice);
            model.eliminarItem(removido);
            view.mostrarMensaje("Se ha retirado '" + removido.getNombre() + "' del inventario.");
        } else {
            view.mostrarMensaje("Índice inválido.");
        }
    }

    public void buscarItem() {
        String nombre = view.solicitarTexto("Ingrese el nombre del objeto a buscar: ");
        Item itemEncontrado = model.buscarItem(nombre);
        if (itemEncontrado != null) {
            view.mostrarDetallesItem(itemEncontrado);
        } else {
            view.mostrarMensaje("No se encontró ningún objeto con ese nombre.");
        }
    }

    private void usarItem() {
        String nombre = view.solicitarTexto("¿Qué objeto desea usar?: ");
        Item itemEncontrado = model.buscarItem(nombre);
        if (itemEncontrado != null) {
            itemEncontrado.usarItem();
        } else {
            view.mostrarMensaje("No se encontró el objeto indicado.");
        }
    }
}

