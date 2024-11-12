package factory;

import model.Libro;
import model.Revista;
import service.ConexionAPILibros;
import service.ConexionAPIRevistas;

import java.util.ArrayList;

public class FabricaCiencia implements Fabrica {

    public FabricaCiencia() {
    }

    @Override
    public Revista crearRevista() {
        ConexionAPIRevistas conexion = new ConexionAPIRevistas("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=news_desk:%22science%22&sort=newest&api-key=BsEGWJx6KO6rf0Y9OJJh692KPvCUUAUC&fl=abstract,lead_paragraph,source,web_url,word_count");
        ArrayList<ArrayList<String>> datos_ = conexion.getInformacion().getDatos();
        System.out.println(datos_.toString());
        return null;
    }

    @Override
    public Libro crearLibro() {
        ConexionAPILibros conexion = new ConexionAPILibros("https://openlibrary.org/search.json?page=1&sorts=already_read_count%20desc&fields=title,publish_date,isbn,author_name&subject=science&limit=10");
        ArrayList<ArrayList<String>> datos_ = conexion.getInformacion().getDatos();
        return new Libro(datos_.get(0).get(0), datos_.get(0).get(3), Integer.parseInt(datos_.get(0).get(2)), datos_.get(0).get(1));
    }
}
