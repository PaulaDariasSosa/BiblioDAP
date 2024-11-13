package client;

import factory.Fabrica;
import factory.FactoryVideo;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private Fabrica factory_;
    private ArrayList<Publicacion> publicaciones_;

    public Biblioteca() {
        publicaciones_ = new ArrayList<Publicacion>();
        //factory_ = new Fabrica(); aqui ponemos una fabrica por defecto
    }

    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones_.add(publicacion);
    }

    public void mostrarPublicaciones() {
        for (Publicacion publicacion : publicaciones_) {
            publicacion.mostrar();
        }
    }

    public void cambiarFabrica() {
        System.out.println("¿Que fabrica desea usar?");
        System.out.println("1. Fabrica de x");
        System.out.println("2. Fabrica de y");
        System.out.println("2. Fabrica de z");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            factory_ = new FactoryVideo();
        } else if (opcion == 2) {
            // factory_ = new Fabrica();
        } else if (opcion == 3) {
            // factory_ = new Fabrica();
        }
    }


    public void buscar() {
        System.out.println("¿Que desea buscar?");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        Scanner scanner = new Scanner(System.in);
        Publicacion publicacion = null;
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            publicacion = factory_.crearLibro();
        } else if (opcion == 2) {
            publicacion = factory_.crearRevista();
        }

        //preguntar si desea agregar la publicacion
        System.out.println("¿Desea agregar la publicacion?");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = scanner.nextInt();
        if (opcion == 1) {
            agregarPublicacion(publicacion);
        }
    }

}