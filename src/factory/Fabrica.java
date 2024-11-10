package factory;

import model.*;

public interface Fabrica {
    public Revista crearRevista();
    public Libro crearLibro();
}
