import client.Biblioteca;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setVisible(true);
        });
    }
}