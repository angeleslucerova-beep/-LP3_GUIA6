import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    private List<Item> items;

    public InventarioModel() {
        this.items = new ArrayList<>();
        // Items iniciales de prueba
        items.add(new Item("Espada de Hierro", 1, "Arma", "Una espada ligera y afilada."));
        items.add(new Item("Poción de Vida", 5, "Poción", "Restaura 50 puntos de salud."));
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public boolean eliminarItem(Item item) {
        return this.items.remove(item);
    }

    public List<Item> obtenerItems() {
        return this.items;
    }

    public Item buscarItem(String nombre) {
        for (Item item : items) {
            if (item.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return item;
            }
        }
        return null;
    }
}
