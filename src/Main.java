import client.Biblioteca;
<<<<<<< HEAD

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cambiarFabrica();
        biblioteca.buscar();
        biblioteca.mostrarPublicaciones();
=======

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setVisible(true);
        });
>>>>>>> e9a07bbeb1e37f66b623d34359a9413f81e31bc1
    }
}