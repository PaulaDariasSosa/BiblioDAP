package factory;

import model.*;

/**
 * Interfaz que define los métodos que deben implementar las fábricas de productos.
 */

public interface Fabrica {
    public Revista crearRevista();
    public Libro crearLibro();
}
