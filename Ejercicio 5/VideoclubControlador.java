public class VideoclubControlador {
    private VideoclubModelo modelo;
    private VideoclubVista vista;

    public VideoclubControlador(VideoclubModelo modelo, VideoclubVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opc;
        do {
            vista.mostrarMenu();
            opc = vista.obtenerOpcion();
            evaluarOpcion(opc);
        } while (!opc.equals("4"));
    }

    private void evaluarOpcion(String opc) {
        switch (opc) {
            case "1":
                String titulo = vista.pedirTexto("el titulo de la pelicula");
                String genero = vista.pedirTexto("el genero");
                if(!titulo.trim().isEmpty()) {
                    modelo.registrarPelicula(new Pelicula(titulo, genero));
                    vista.mostrarMensaje("Pelicula guardada exitosamente.");
                } else {
                    vista.mostrarMensaje("Error: El titulo no puede quedar vacio.");
                }
                break;
            case "2":
                vista.imprimirCatalogo(modelo.getCatalogo());
                break;
            case "3":
                vista.imprimirCatalogo(modelo.getCatalogo());
                if(modelo.getCatalogo().isEmpty()) break;
                try {
                    int id = Integer.parseInt(vista.pedirTexto("el numero de la pelicula a rentar"));
                    Pelicula seleccionada = modelo.getCatalogo().get(id);
                    if(seleccionada.isDisponible()) {
                        seleccionada.setDisponible(false);
                        vista.mostrarMensaje("Transaccion completada. Disfruta de: " + seleccionada.getTitulo());
                    } else {
                        vista.mostrarMensaje("Lo sentimos, esa pelicula ya esta rentada.");
                    }
                } catch(Exception e) {
                    vista.mostrarMensaje("Numero de pelicula invalido.");
                }
                break;
            case "4":
                vista.mostrarMensaje("Saliendo del sistema...");
                break;
            default:
                vista.mostrarMensaje("Opcion incorrecta.");
        }
    }
}
