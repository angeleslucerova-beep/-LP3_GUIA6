public class Pelicula {
    private String titulo;
    private String genero;
    private boolean disponible;

    public Pelicula(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
