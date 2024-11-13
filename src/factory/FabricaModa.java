package factory;

import model.*;
import service.ConexionAPILibros;
import service.ConexionAPIRevistas;
import service.Dataset;
import java.util.Scanner;

public class FabricaModa implements Fabrica {
    /**
     * Crea una revista de moda
     * @return
     */
    public Revista crearRevista() {
        ConexionAPIRevistas conexion = new ConexionAPIRevistas("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=news_desk:(\"Fashion\")&sort=newest&api-key=BsEGWJx6KO6rf0Y9OJJh692KPvCUUAUC&fl=abstract,lead_paragraph,source,web_url,word_count");
        Dataset informacion = conexion.getInformacion();

        System.out.println("Revistas de moda:");
        informacion.show();
        int opcion = 1;
        System.out.println("Elija una revista de moda(introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        opcion = scanner.nextInt();
        scanner.nextLine();

        return new RevistaModa(informacion.getDatos().get(opcion-1).get(0), informacion.getDatos().get(opcion-1).get(1), informacion.getDatos().get(opcion-1).get(2), informacion.getDatos().get(opcion-1).get(3), Integer.parseInt(informacion.getDatos().get(opcion-1).get(4)));
    }

    /**
     * Crea un libro de moda
     * @return
     */
    public Libro crearLibro() {
        ConexionAPILibros conexion = new ConexionAPILibros("https://openlibrary.org/search.json?page=1&sorts=already_read_count%20desc&fields=title,publish_date,isbn,author_name&subject=fashion");
        Dataset informacion = conexion.getInformacion();

        System.out.println("Libros de moda:");
        informacion.show();
        int opcion = 1;
        System.out.println("Elija un libro de moda(introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        opcion = scanner.nextInt();
        scanner.nextLine();

        return new LibroModa(informacion.getDatos().get(opcion-1).get(3), informacion.getDatos().get(opcion-1).get(0), Long.parseLong(informacion.getDatos().get(opcion-1).get(1)), informacion.getDatos().get(opcion-1).get(2));
    }
}
