import client.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cambiarFabrica();
        biblioteca.buscar();
        biblioteca.mostrarPublicaciones();
    }
}