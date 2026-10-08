import java.util.ArrayList;
import java.util.List;

public class VideoclubModelo {
    private List<Pelicula> catalogo;

    public VideoclubModelo() {
        catalogo = new ArrayList<>();
    }

    public void registrarPelicula(Pelicula p) {
        catalogo.add(p);
    }

    public List<Pelicula> getCatalogo() {
        return catalogo;
    }
}
