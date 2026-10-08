public class MainVideoclub {
    public static void main(String[] args) {
        VideoclubModelo modelo = new VideoclubModelo();
        VideoclubVista vista = new VideoclubVista();
        
        VideoclubControlador control = new VideoclubControlador(modelo, vista);
        control.iniciar();
    }
}
