package factory;

import model.*;

public class FabricaModa implements Fabrica {
    public Revista crearRevista() {
        return new RevistaModa();
    }

    public Libro crearLibro() {
        return new LibroModa();
    }
}
