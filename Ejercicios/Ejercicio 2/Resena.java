public class Resena {
    private String usuario;
    private int calificacion;
    private String comentario;

    public Resena(String usuario, int calificacion, String comentario) {
        this.usuario = usuario;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public String getUsuario() { return usuario; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }
}
