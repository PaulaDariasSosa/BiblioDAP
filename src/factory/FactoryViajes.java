package factory;

import model.*;

public class FactoryViajes implements Fabrica{
    /**
     * Crea una revista de viajes
     * @return
     */
    public Revista crearRevista(){
        return new RevistaViajes();
    }

    /**
     * Crea un libro de viajes
     * @return
     */
    public Libro crearLibro() {
        return new LibroViajes();
    }
}
