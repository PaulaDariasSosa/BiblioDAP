package factory;

import model.Libro;
import model.LibroCiencia;
import model.Revista;
import model.RevistaCiencia;
import service.ConexionAPILibros;
import service.ConexionAPIRevistas;
import java.util.Scanner;
import java.util.ArrayList;

public class FabricaCiencia implements Fabrica {

    public FabricaCiencia() {
    }

    @Override
    public RevistaCiencia crearRevista() {
        ConexionAPIRevistas conexion = new ConexionAPIRevistas("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=news_desk:%22science%22&sort=newest&api-key=BsEGWJx6KO6rf0Y9OJJh692KPvCUUAUC&fl=abstract,lead_paragraph,source,web_url,word_count");
        ArrayList<String> atributos_ = conexion.getInformacion().getNombreAtributos();
        ArrayList<ArrayList<String>> datos_ = conexion.getInformacion().getDatos();
        System.out.println("Escoge una revista:");
        //a for with an index to show all the data
        for (int i = 0; i < datos_.size(); i++) {
            System.out.println("--------------------");
            System.out.println("Revista " + i + ":");
            for (int j = 0; j < datos_.get(i).size(); j++) {
                System.out.print(atributos_.get(j) + ": ");
                System.out.println(datos_.get(i).get(j));
            }
        }
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        RevistaCiencia revista_ = new RevistaCiencia(datos_.get(opcion).get(0), datos_.get(opcion).get(1), datos_.get(opcion).get(2), datos_.get(opcion).get(3), Integer.parseInt(datos_.get(opcion).get(4)));
        return revista_;
    }

    @Override
    public LibroCiencia crearLibro() {
        ConexionAPILibros conexion = new ConexionAPILibros("https://openlibrary.org/search.json?page=1&sorts=already_read_count%20desc&fields=title,publish_date,isbn,author_name&subject=science&limit=10");
        ArrayList<String> atributos_ = conexion.getInformacion().getNombreAtributos();
        ArrayList<ArrayList<String>> datos_ = conexion.getInformacion().getDatos();
        System.out.println("Escoge un libro:");
        //a for with an index to show all the data
        for (int i = 0; i < datos_.size(); i++) {
            System.out.println("--------------------");
            System.out.println("Libro " + i + ":");
            for (int j = 0; j < datos_.get(i).size(); j++) {
                System.out.print(atributos_.get(j) + ": ");
                System.out.println(datos_.get(i).get(j));
            }
        }
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        LibroCiencia libro_ = new LibroCiencia(datos_.get(opcion).get(0), datos_.get(opcion).get(2), Long.parseLong(datos_.get(opcion).get(1)), datos_.get(opcion).get(3));
        return libro_;
    }
}
