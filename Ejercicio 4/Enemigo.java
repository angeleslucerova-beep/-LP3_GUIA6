public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public int atacar() {
        return 6 + (nivel * 2); 
    }

    public void recibirDanio(int cantidad) {
        this.salud -= cantidad;
        if (this.salud < 0) this.salud = 0;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public String getTipo() { return tipo; }
}
