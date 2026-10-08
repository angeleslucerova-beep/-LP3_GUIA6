import java.util.List;

public class TiendaControlador {
    private TiendaModelo modelo;
    private TiendaVista vista;

    public TiendaControlador(TiendaModelo modelo, TiendaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion = "";
        do {
            if (modelo.getUsuarioLogueado() == null) {
                vista.mostrarMenuPrincipal();
                opcion = vista.solicitarTexto("Seleccione una opción: ");
                procesarMenuPrincipal(opcion);
            } else {
                vista.mostrarMenuUsuario(modelo.getUsuarioLogueado().getUsername());
                opcion = vista.solicitarTexto("Seleccione una opción: ");
                procesarMenuUsuario(opcion);
            }
        } while (!opcion.equals("4") || modelo.getUsuarioLogueado() != null);
        
        vista.cerrarScanner();
    }

    private void procesarMenuPrincipal(String opcion) {
        switch (opcion) {
            case "1":
                String regUser = vista.solicitarTexto("Ingrese nuevo usuario: ");
                String regPass = vista.solicitarTexto("Ingrese contraseña: ");
                if (modelo.registrarUsuario(regUser, regPass)) {
                    vista.mostrarMensaje("¡Registro exitoso! Ya puede iniciar sesión.");
                } else {
                    vista.mostrarMensaje("Error: El usuario ya existe.");
                }
                break;
            case "2":
                String loginUser = vista.solicitarTexto("Usuario: ");
                String loginPass = vista.solicitarTexto("Contraseña: ");
                if (modelo.iniciarSesion(loginUser, loginPass)) {
                    vista.mostrarMensaje("¡Bienvenido " + loginUser + "!");
                } else {
                    vista.mostrarMensaje("Credenciales incorrectas.");
                }
                break;
            case "3":
                vista.mostrarReseñas(modelo.getReseñas());
                break;
            case "4":
                vista.mostrarMensaje("Saliendo de la aplicación...");
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }

    private void procesarMenuUsuario(String opcion) {
        switch (opcion) {
            case "1":
                vista.listarProductos(modelo.getInventario());
                break;
            case "2":
                vista.listarProductos(modelo.getInventario());
                int indexAdd = vista.solicitarEntero("Seleccione el número de producto a agregar: ") - 1;
                if (indexAdd >= 0 && indexAdd < modelo.getInventario().size()) {
                    modelo.agregarAlCarrito(modelo.getInventario().get(indexAdd));
                    vista.mostrarMensaje("Producto agregado al carrito.");
                } else {
                    vista.mostrarMensaje("Selección inválida.");
                }
                break;
            case "3":
                vista.mostrarCarrito(modelo.getCarrito(), modelo.calcularTotal());
                break;
            case "4":
                vista.mostrarCarrito(modelo.getCarrito(), modelo.calcularTotal());
                if (!modelo.getCarrito().isEmpty()) {
                    int indexDel = vista.solicitarEntero("Seleccione el número de producto a eliminar: ") - 1;
                    if (indexDel >= 0 && indexDel < modelo.getCarrito().size()) {
                        modelo.eliminarDelCarrito(indexDel);
                        vista.mostrarMensaje("Producto eliminado del carrito.");
                    } else {
                        vista.mostrarMensaje("Selección inválida.");
                    }
                }
                break;
            case "5":
                if (modelo.getCarrito().isEmpty()) {
                    vista.mostrarMensaje("El carrito está vacío, no puede comprar.");
                } else {
                    double descuento = 10.0; // Descuento fijo de ejemplo
                    double envio = 5.0;      // Costo de envío de ejemplo
                    vista.mostrarMensaje("Aplicando Descuento: $" + descuento);
                    vista.mostrarMensaje("Costo de Envío: $" + envio);
                    modelo.realizarCompra(descuento, envio);
                    vista.mostrarMensaje("¡Compra realizada con éxito! Su carrito se ha vaciado.");
                }
                break;
            case "6":
                int calif = vista.solicitarEntero("Ingrese calificación (1 al 5): ");
                if (calif >= 1 && calif <= 5) {
                    String com = vista.solicitarTexto("Escriba su comentario: ");
                    modelo.agregarResena(calif, com);
                    vista.mostrarMensaje("¡Gracias por su reseña!");
                } else {
                    vista.mostrarMensaje("Calificación inválida.");
                }
                break;
            case "7":
                vista.mostrarHistorial(modelo.getHistorialCompras());
                break;
            case "8":
                modelo.cerrarSesion();
                vista.mostrarMensaje("Sesión cerrada.");
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }
}
