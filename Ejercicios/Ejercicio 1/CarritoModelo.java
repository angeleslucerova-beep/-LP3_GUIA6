import java.util.ArrayList;
import java.util.List;
public class CarritoModelo {

    private List<Producto> productos;
    private List<Producto> carrito;
    private List<Producto> historialCompras;

    public CarritoModelo() {

        productos = new ArrayList<>();
        carrito = new ArrayList<>();
        historialCompras = new ArrayList<>();

        cargarProductos();
    }

    // PRODUCTOS DISPONIBLES
    private void cargarProductos() {

        productos.add(
            new Producto("Laptop", 2500.00)
        );

        productos.add(
            new Producto("Mouse", 80.00)
        );

        productos.add(
            new Producto("Teclado", 120.00)
        );

        productos.add(
            new Producto("Monitor", 850.00)
        );

        productos.add(
            new Producto("Audífonos", 150.00)
        );
    }

    // LISTAR PRODUCTOS
    public List<Producto> getProductos() {

        return productos;
    }

    // AGREGAR PRODUCTO AL CARRITO
    public boolean agregarAlCarrito(int indice) {

        if (indice >= 0 &&
            indice < productos.size()) {

            Producto producto =
                productos.get(indice);

            carrito.add(producto);

            return true;
        }

        return false;
    }

    // OBTENER CARRITO

    public List<Producto> getCarrito() {

        return carrito;
    }

    // ELIMINAR DEL CARRITO

    public boolean eliminarDelCarrito(int indice) {

        if (indice >= 0 &&
            indice < carrito.size()) {

            carrito.remove(indice);

            return true;
        }

        return false;
    }

    // CALCULAR SUBTOTAL

    public double calcularSubtotal() {

        double subtotal = 0;

        for (Producto producto : carrito) {

            subtotal += producto.getPrecio();
        }

        return subtotal;
    }

    // APLICAR DESCUENTO

    public double calcularDescuento() {

        double subtotal =
            calcularSubtotal();

        if (subtotal >= 1000) {

            return subtotal * 0.10;
        }

        if (subtotal >= 500) {

            return subtotal * 0.05;
        }

        return 0;
    }

    // CALCULAR ENVÍO
    public double calcularEnvio() {

        double subtotal =
            calcularSubtotal();

        if (subtotal == 0) {

            return 0;
        }

        if (subtotal >= 1000) {

            return 0;
        }

        return 20.00;
    }

    // CALCULAR TOTAL
    public double calcularTotal() {

        double subtotal =
            calcularSubtotal();

        double descuento =
            calcularDescuento();

        double envio =
            calcularEnvio();

        return subtotal -
               descuento +
               envio;
    }

    // REALIZAR COMPRA
    public boolean realizarCompra() {

        if (carrito.isEmpty()) {

            return false;
        }

        historialCompras.addAll(carrito);

        carrito.clear();

        return true;
    }

    // HISTORIAL
    public List<Producto> getHistorialCompras() {

        return historialCompras;
    }
}
