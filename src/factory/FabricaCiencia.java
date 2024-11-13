package factory;

import model.Libro;
import model.LibroCiencia;
import model.Revista;
import model.RevistaCiencia;
import service.ConexionAPILibros;
import service.ConexionAPIRevistas;
import service.Dataset;

import java.util.Scanner;
import java.util.ArrayList;

public class FabricaCiencia implements Fabrica {

    public FabricaCiencia() {
    }

    /**
     * Crea una revista de ciencia
     * @return
     */
    @Override
    public RevistaCiencia crearRevista() {
        ConexionAPIRevistas conexion = new ConexionAPIRevistas("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=news_desk:%22science%22&sort=newest&api-key=BsEGWJx6KO6rf0Y9OJJh692KPvCUUAUC&fl=abstract,lead_paragraph,source,web_url,word_count");
        Dataset informacion = conexion.getInformacion();
        ArrayList<ArrayList<String>> datos_ = conexion.getInformacion().getDatos();
        informacion.show();
        int opcion = 1;
        System.out.println("Elija una revista de ciencia(introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        opcion = scanner.nextInt();
        scanner.nextLine();
        opcion = opcion - 1;
        RevistaCiencia revista_ = new RevistaCiencia(datos_.get(opcion).get(0), datos_.get(opcion).get(1), datos_.get(opcion).get(2), datos_.get(opcion).get(3), Integer.parseInt(datos_.get(opcion).get(4)));
        return revista_;
    }

    /**
     * Crea un libro de ciencia
     * @return
     */
    @Override
    public LibroCiencia crearLibro() {
        ConexionAPILibros conexion = new ConexionAPILibros("https://openlibrary.org/search.json?page=1&sorts=already_read_count%20desc&fields=title,publish_date,isbn,author_name&subject=science&limit=10");
        Dataset informacion = conexion.getInformacion();
        ArrayList<ArrayList<String>> datos_ = informacion.getDatos();
        informacion.show();
        int opcion = 1;
        System.out.println("Elija una libro de ciencia(introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        opcion = scanner.nextInt();
        scanner.nextLine();
        opcion = opcion - 1;
        LibroCiencia libro_ = new LibroCiencia(datos_.get(opcion).get(0), datos_.get(opcion).get(2), Long.parseLong(datos_.get(opcion).get(1)), datos_.get(opcion).get(3));
        return libro_;
    }
}
