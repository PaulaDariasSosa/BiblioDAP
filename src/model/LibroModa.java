package model;

import service.*;
<<<<<<< HEAD
=======

import javax.swing.*;
>>>>>>> e9a07bbeb1e37f66b623d34359a9413f81e31bc1
import java.util.Scanner;

public class LibroModa extends Libro {
    private long isbn_; // Change the type to long

<<<<<<< HEAD
    public LibroModa() {
        super();
        ConexionAPILibros conexion = new ConexionAPILibros("https://openlibrary.org/search.json?page=1&sorts=already_read_count%20desc&fields=title,publish_date,isbn,author_name&subject=fashion");
        Dataset informacion = conexion.getInformacion();

        System.out.println("Libros de moda:");
        informacion.show();

        System.out.println("Elija un libro de moda(introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();

        titulo_ = informacion.getDatos().get(opcion - 1).get(3);
        autor_ = informacion.getDatos().get(opcion - 1).get(0);
        isbn_ = Long.parseLong(informacion.getDatos().get(opcion - 1).get(1));
        fecha_ = informacion.getDatos().get(opcion - 1).get(2);
=======
    /**
     * Constructor
     * @param titulo
     * @param autor
     * @param isbn
     * @param fecha
     */
    public LibroModa(String titulo, String autor, long isbn, String fecha){
        super(titulo, autor, isbn, fecha);

    }

    /**
     * Metodo que muestra los datos del libro
     */
    public String toString(){
        return "Titulo: " + titulo_ + "\n" + "Autor: " + autor_ + "\n" + "ISBN: " + isbn_ + "\n" + "Fecha: " + fecha_ + "\n" + "Es un libro de Moda";
>>>>>>> e9a07bbeb1e37f66b623d34359a9413f81e31bc1
    }
}