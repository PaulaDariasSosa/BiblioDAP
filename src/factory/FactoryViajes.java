package factory;

import model.*;

public class FactoryViajes implements Fabrica{
    public Revista crearRevista(){
        return new RevistaViajes();
    }

    public Libro crearLibro() {
        return new LibroViajes();
    }
}
