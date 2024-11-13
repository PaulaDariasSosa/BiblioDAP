package model;

public class LibroCiencia extends Libro {

    public LibroCiencia() {
        super();
    }

    public LibroCiencia(String titulo, String autor, long isbn, String fecha) {
        super(titulo, autor, isbn, fecha);
    }

    public void mostrar() {
        System.out.println("Titulo: " + titulo_);
        System.out.println("Autor: " + autor_);
        System.out.println("ISBN: " + isbn_);
        System.out.println("Fecha: " + fecha_);
        System.out.println("Es un libro de Ciencia");
    }

    public String toString() {
        return "Titulo: " + titulo_ + "\n" + "Autor: " + autor_ + "\n" + "ISBN: " + isbn_ + "\n" + "Fecha: " + fecha_ + "\n" + "Es un libro de Ciencia";
    }


}
