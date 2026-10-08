import java.util.List;

public class CarritoControlador {

    private CarritoModelo modelo;
    private CarritoVista vista;

    public CarritoControlador(
            CarritoModelo modelo,
            CarritoVista vista) {

        this.modelo = modelo;
        this.vista = vista;
    }

    // LISTAR PRODUCTOS
    public void listarProductos() {

        List<Producto> productos =
            modelo.getProductos();

        vista.mostrarProductos(
            productos
        );
    }


    // AGREGAR AL CARRITO
    public void agregarAlCarrito() {

        listarProductos();

        int indice =
            vista.solicitarIndice();

        boolean agregado =
            modelo.agregarAlCarrito(
                indice
            );

        if (agregado) {

            vista.mostrarMensaje(
                "Producto agregado al carrito correctamente."
            );

        } else {

            vista.mostrarMensaje(
                "Número de producto inválido."
            );
        }
    }


    public void verCarrito() {

        vista.mostrarCarrito(
            modelo.getCarrito()
        );
    }


    public void eliminarDelCarrito() {

        verCarrito();

        if (modelo.getCarrito().isEmpty()) {

            return;
        }

        int indice =
            vista.solicitarIndice();

        boolean eliminado =
            modelo.eliminarDelCarrito(
                indice
            );

        if (eliminado) {

            vista.mostrarMensaje(
                "Producto eliminado del carrito."
            );

        } else {

            vista.mostrarMensaje(
                "Número de producto inválido."
            );
        }
    }


    public void verResumen() {

        if (modelo.getCarrito().isEmpty()) {

            vista.mostrarMensaje(
                "El carrito está vacío."
            );

            return;
        }

        double subtotal =
            modelo.calcularSubtotal();

        double descuento =
            modelo.calcularDescuento();

        double envio =
            modelo.calcularEnvio();

        double total =
            modelo.calcularTotal();

        vista.mostrarResumen(
            subtotal,
            descuento,
            envio,
            total
        );
    }


    public void realizarCompra() {

        if (modelo.getCarrito().isEmpty()) {

            vista.mostrarMensaje(
                "No puedes realizar una compra con el carrito vacío."
            );

            return;
        }

        verResumen();

        boolean comprado =
            modelo.realizarCompra();

        if (comprado) {

            vista.mostrarMensaje(
                "Compra realizada correctamente."
            );

            vista.mostrarMensaje(
                "Los productos fueron agregados al historial."
            );
        }
    }

    // VER HISTORIAL
    public void verHistorial() {

        vista.mostrarHistorial(
            modelo.getHistorialCompras()
        );
    }


    // INICIAR SISTEMA
    public void iniciar() {

        String opcion;

        do {

            vista.mostrarMenu();

            opcion =
                vista.solicitarOpcion();

            switch (opcion) {

                case "1":

                    listarProductos();

                    break;

                case "2":

                    agregarAlCarrito();

                    break;

                case "3":

                    verCarrito();

                    break;

                case "4":

                    eliminarDelCarrito();

                    break;

                case "5":

                    verResumen();

                    break;

                case "6":

                    realizarCompra();

                    break;

                case "7":

                    verHistorial();

                    break;

                case "8":

                    vista.mostrarMensaje(
                        "Saliendo del sistema..."
                    );

                    break;

                default:

                    vista.mostrarMensaje(
                        "Opción no válida."
                    );
            }

        } while (!opcion.equals("8"));

        vista.cerrarScanner();
    }
}