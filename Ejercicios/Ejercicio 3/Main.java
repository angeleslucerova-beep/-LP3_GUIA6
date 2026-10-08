public class Main {
    public static void main(String[] args) {
        InventarioModel model = new InventarioModel();
        InventarioView view = new InventarioView();
        InventarioController controller = new InventarioController(model, view);

        controller.iniciar();
    }
}
