import java.util.Random;

public class CombateControlador {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateVista vista;
    private Random random;

    public CombateControlador(Jugador jugador, Enemigo enemigo, CombateVista vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
        this.random = new Random();
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("Un salvaje " + enemigo.getNombre() + " ha aparecido.");
        
        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            vista.mostrarEstado(jugador, enemigo);
            vista.mostrarMenu();
            String opc = vista.leerOpcion();
            
            boolean turnoValido = procesarTurnoJugador(opc);
            
            if (turnoValido && enemigo.getSalud() > 0) {
                turnoEnemigo();
            }
        }

        System.out.println("\n=== FIN DEL COMBATE ===");
        if (jugador.getSalud() <= 0) {
            vista.mostrarMensaje("Has sido derrotado por el " + enemigo.getNombre() + ". Fin de la partida.");
        } else {
            vista.mostrarMensaje("Victoria. Has eliminado a " + enemigo.getNombre() + ".");
        }
    }

    private boolean procesarTurnoJugador(String opcion) {
        switch (opcion) {
            case "1":
                int dmg = jugador.atacar();
                enemigo.recibirDanio(dmg);
                vista.mostrarMensaje(jugador.getNombre() + " ataco infligiendo " + dmg + " puntos de danio.");
                return true;
                
            case "2":
                vista.mostrarInventario(jugador.getInventario());
                if(jugador.getInventario().isEmpty()) return false;
                
                try {
                    int indice = Integer.parseInt(vista.leerOpcion());
                    if (indice == -1) return false;
                    
                    String nombreItem = jugador.getInventario().get(indice).getNombre();
                    String tipoItem = jugador.getInventario().get(indice).getTipo();
                    
                    if (jugador.usarObjeto(indice)) {
                        if(tipoItem.equalsIgnoreCase("Arma")) {
                            vista.mostrarMensaje("Te has equipado: " + nombreItem);
                        } else {
                            vista.mostrarMensaje("Consumiste una pocion. Salud restaurada.");
                        }
                        return true;
                    } else {
                        vista.mostrarMensaje("No pudiste usar ese objeto.");
                    }
                } catch (Exception e) {
                    vista.mostrarMensaje("Seleccion invalida.");
                }
                return false;

            default:
                vista.mostrarMensaje("Accion erronea. Pierdes concentracion.");
                return false;
        }
    }

    private void turnoEnemigo() {
        int accion = random.nextInt(2); 
        if (accion == 0) {
            int dmgEnemigo = enemigo.atacar();
            jugador.recibirDanio(dmgEnemigo);
            vista.mostrarMensaje("El " + enemigo.getNombre() + " lanza un zarpazo y te hace " + dmgEnemigo + " de danio.");
        } else {
            vista.mostrarMensaje("El " + enemigo.getNombre() + " se esta defendiendo y te observa fijamente.");
        }
    }
}
