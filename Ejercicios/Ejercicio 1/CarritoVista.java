import java.util.List;
import java.util.Scanner;

public class CarritoVista {

    private Scanner scanner;

    public CarritoVista() {

        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {

        System.out.println();
        System.out.println(
            "=========================================="
        );
        System.out.println(
            "          CARRITO DE COMPRAS"
        );
        System.out.println(
            "=========================================="
        );

        System.out.println(
            "1. Listar productos"
        );

        System.out.println(
            "2. Agregar producto al carrito"
        );

        System.out.println(
            "3. Ver carrito"
        );

        System.out.println(
            "4. Eliminar producto del carrito"
        );

        System.out.println(
            "5. Ver resumen de compra"
        );

        System.out.println(
            "6. Realizar compra"
        );

        System.out.println(
            "7. Ver historial de compras"
        );

        System.out.println(
            "8. Salir"
        );

        System.out.println(
            "=========================================="
        );
    }


    public String solicitarOpcion() {

        System.out.print(
            "Selecciona una opción: "
        );

        return scanner.nextLine();
    }

    public void mostrarProductos(
            List<Producto> productos) {

        System.out.println();
        System.out.println(
            "===== PRODUCTOS DISPONIBLES ====="
        );

        if (productos.isEmpty()) {

            System.out.println(
                "No hay productos disponibles."
            );

            return;
        }

        for (int i = 0;
             i < productos.size();
             i++) {

            System.out.println(
                (i + 1) +
                ". " +
                productos.get(i)
            );
        }
    }
    
    public void mostrarCarrito(
            List<Producto> carrito) {

        System.out.println();
        System.out.println(
            "===== CARRITO DE COMPRAS ====="
        );

        if (carrito.isEmpty()) {

            System.out.println(
                "El carrito está vacío."
            );

            return;
        }

        for (int i = 0;
             i < carrito.size();
             i++) {

            System.out.println(
                (i + 1) +
                ". " +
                carrito.get(i)
            );
        }
    }


    public void mostrarHistorial(
            List<Producto> historial) {

        System.out.println();
        System.out.println(
            "===== HISTORIAL DE COMPRAS ====="
        );

        if (historial.isEmpty()) {

            System.out.println(
                "No existen compras realizadas."
            );

            return;
        }

        for (int i = 0;
             i < historial.size();
             i++) {

            System.out.println(
                (i + 1) +
                ". " +
                historial.get(i)
            );
        }
    }


    public int solicitarIndice() {

        System.out.print(
            "Introduce el número del producto: "
        );

        try {

            return Integer.parseInt(
                scanner.nextLine()
            ) - 1;

        } catch (NumberFormatException e) {

            return -1;
        }
    }


    public void mostrarResumen(
            double subtotal,
            double descuento,
            double envio,
            double total) {

        System.out.println();
        System.out.println(
            "===== RESUMEN DE COMPRA ====="
        );

        System.out.printf(
            "Subtotal:   S/ %.2f%n",
            subtotal
        );

        System.out.printf(
            "Descuento:  S/ %.2f%n",
            descuento
        );

        System.out.printf(
            "Envío:      S/ %.2f%n",
            envio
        );

        System.out.println(
            "------------------------------"
        );

        System.out.printf(
            "TOTAL:      S/ %.2f%n",
            total
        );
    }

    public void mostrarMensaje(
            String mensaje) {

        System.out.println();
        System.out.println(mensaje);
    }

    public void cerrarScanner() {

        scanner.close();
    }
}