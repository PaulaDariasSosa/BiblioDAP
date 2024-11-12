package model;
import service.*;
import java.util.Scanner;

public class LibroViajes extends Libro {
    private long isbn_; // Change the type to long

    public LibroViajes() {
        super();
        ConexionAPILibros conexion = new ConexionAPILibros("https://openlibrary.org/search.json?page=1&sorts=already_read_count%20desc&fields=title,publish_date,isbn,author_name&subject=travel");
        Dataset informacion = conexion.getInformacion();

        System.out.println("Libros de Viajes:");
        informacion.show();

        System.out.println("Elija un libro de Viaje(introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();

        titulo_ = informacion.getDatos().get(opcion-1).get(3);
        autor_ = informacion.getDatos().get(opcion-1).get(0);
        isbn_ = Long.parseLong(informacion.getDatos().get(opcion-1).get(1)); // This line remains the same
        fecha_ = informacion.getDatos().get(opcion-1).get(2);
    }
}