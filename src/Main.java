import controlador.PersonaControlador;
import vista.PersonaVista;

public class Main {
    public static void main(String[] args) {
        new PersonaControlador(new PersonaVista());
    }
}