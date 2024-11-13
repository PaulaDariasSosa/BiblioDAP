package factory;

import model.Libro;
import model.LibroVideo;
import model.Revista;
import model.RevistaVideo;

public class FactoryVideo implements Fabrica {
    @Override
    public Libro crearLibro() {
        return new LibroVideo();
    }

    @Override
    public Revista crearRevista() {
        return new RevistaVideo();
    }
}