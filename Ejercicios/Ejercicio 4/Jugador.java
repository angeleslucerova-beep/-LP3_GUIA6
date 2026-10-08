import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private List<Item> inventario;
    private Item armaEquipada;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new ArrayList<>();
        this.armaEquipada = null;
    }

    public int atacar() {
        if (armaEquipada != null) {
            return 10 + (nivel * 3); 
        }
        return 4; 
    }

    public boolean usarObjeto(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            Item item = inventario.get(indice);
            if (item.getCantidad() > 0) {
                if (item.getTipo().equalsIgnoreCase("Pocion")) {
                    this.salud += 25; 
                    item.reducirCantidad();
                    if (item.getCantidad() == 0) inventario.remove(indice);
                    return true;
                } else if (item.getTipo().equalsIgnoreCase("Arma")) {
                    this.armaEquipada = item;
                    return true;
                }
            }
        }
        return false;
    }

    public void recibirDanio(int cantidad) {
        this.salud -= cantidad;
        if (this.salud < 0) this.salud = 0;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public List<Item> getInventario() { return inventario; }
    public Item getArmaEquipada() { return armaEquipada; }
    public void agregarAlInventario(Item item) { this.inventario.add(item); }
}
