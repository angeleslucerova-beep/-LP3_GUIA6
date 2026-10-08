public class MainJuego {
    public static void main(String[] args) {
        Jugador heroe = new Jugador("Aragorn", 100, 3);
        heroe.agregarAlInventario(new Item("Espada de Acero", 1, "Arma", "Aumenta tu poder"));
        heroe.agregarAlInventario(new Item("Pocion de Vida", 2, "Pocion", "Recupera 25 HP"));

        Enemigo orco = new Enemigo("Orco Merodeador", 60, 2, "Guerrero Oscuro");

        CombateVista vista = new CombateVista();
        CombateControlador juego = new CombateControlador(heroe, orco, vista);

        juego.iniciarCombate();
    }
}
