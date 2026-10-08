import java.util.ArrayList;
import java.util.List;

public class TiendaModelo {
    private List<Producto> inventario;
    private List<Producto> carrito;
    private List<Usuario> usuariosRegistrados;
    private List<Resena> reseñas;
    private List<String> historialCompras;
    private Usuario usuarioLogueado;

    public TiendaModelo() {
        inventario = new ArrayList<>();
        carrito = new ArrayList<>();
        usuariosRegistrados = new ArrayList<>();
        reseñas = new ArrayList<>();
        historialCompras = new ArrayList<>();
        usuarioLogueado = null;

        // Productos por defecto
        inventario.add(new Producto("Laptop", 1200.0));
        inventario.add(new Producto("Mouse", 25.0));
        inventario.add(new Producto("Teclado", 45.0));
    }

    // Autenticación
    public boolean registrarUsuario(String username, String password) {
        for (Usuario u : usuariosRegistrados) {
            if (u.getUsername().equalsIgnoreCase(username)) return false;
        }
        usuariosRegistrados.add(new Usuario(username, password));
        return true;
    }

    public boolean iniciarSesion(String username, String password) {
        for (Usuario u : usuariosRegistrados) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                usuarioLogueado = u;
                return true;
            }
        }
        return false;
    }

    public void cerrarSesion() {
        usuarioLogueado = null;
        carrito.clear();
    }

    public Usuario getUsuarioLogueado() { return usuarioLogueado; }
    public List<Producto> getInventario() { return inventario; }
    public List<Producto> getCarrito() { return carrito; }
    public List<Resena> getReseñas() { return reseñas; }
    public List<String> getHistorialCompras() { return historialCompras; }

    // Carrito y Compra
    public void agregarAlCarrito(Producto p) { carrito.add(p); }
    public void eliminarDelCarrito(int index) { carrito.remove(index); }
    
    public double calcularTotal() {
        double total = 0;
        for (Producto p : carrito) total += p.getPrecio();
        return total;
    }

    public void realizarCompra(double descuento, double envio) {
        double totalFinal = (calcularTotal() - descuento) + envio;
        String registro = "Compra de " + usuarioLogueado.getUsername() + " - Total: $" + totalFinal;
        historialCompras.add(registro);
        carrito.clear();
    }

    public void agregarResena(int calificacion, String comentario) {
        reseñas.add(new Resena(usuarioLogueado.getUsername(), calificacion, comentario));
    }
}
