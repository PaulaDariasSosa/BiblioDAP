package model;

import service.*;

import javax.swing.*;
import java.util.Scanner;

public class LibroModa extends Libro{

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
    }
}
