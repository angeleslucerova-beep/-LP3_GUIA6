public class Item {
    private String nombre;
    private int cantidad;
    private String tipo; // Arma, Poción, etc.
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void usarItem() {
        if (this.cantidad > 0) {
            this.cantidad--;
            System.out.println("Has usado el objeto: " + this.nombre);
        } else {
            System.out.println("No quedan unidades disponibles de " + this.nombre);
        }
    }
}
