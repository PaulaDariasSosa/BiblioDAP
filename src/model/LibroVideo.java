package model;

import service.*;
import java.util.Scanner;

public class LibroVideo extends Libro {
    private long isbn_;

    public LibroVideo() {
        super();
        ConexionAPILibros conexion = new ConexionAPILibros("https://openlibrary.org/search.json?page=1&sorts=already_read_count%20desc&fields=title,publish_date,isbn,author_name&subject=video&limit=10");
        Dataset informacion = conexion.getInformacion();

        mostrarLibros(informacion);
        int opcion = obtenerOpcion(informacion);

        asignarDatos(informacion, opcion);
    }

    private void mostrarLibros(Dataset informacion) {
        System.out.println("Libros de Video:");
        informacion.show();
    }

    private int obtenerOpcion(Dataset informacion) {
        System.out.println("Elija un libro de Video (introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    private void asignarDatos(Dataset informacion, int opcion) {
        titulo_ = informacion.getDatos().get(opcion - 1).get(3);
        autor_ = informacion.getDatos().get(opcion - 1).get(0);
        isbn_ = Long.parseLong(informacion.getDatos().get(opcion - 1).get(1));
        fecha_ = informacion.getDatos().get(opcion - 1).get(2);
    }
}