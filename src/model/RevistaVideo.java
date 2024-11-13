package model;

import service.*;
import java.util.Scanner;

public class RevistaVideo extends Revista {

    private String abstract_;
    private String web_url_;
    private String lead_paragraph_;
    private String source_;
    private int word_count_;

    public RevistaVideo() {
        super();

        ConexionAPIRevistas conexion = new ConexionAPIRevistas("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=news_desk:(\"video\")&sort=newest&api-key=BsEGWJx6KO6rf0Y9OJJh692KPvCUUAUC&fl=abstract,lead_paragraph,source,web_url,word_count");
        Dataset informacion = conexion.getInformacion();

        mostrarRevistas(informacion);
        int opcion = obtenerOpcion(informacion);

        asignarDatos(informacion, opcion);
    }

    private void mostrarRevistas(Dataset informacion) {
        System.out.println("Revistas de Video:");
        informacion.show();
    }

    private int obtenerOpcion(Dataset informacion) {
        System.out.println("Elija una revista de Video (introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    private void asignarDatos(Dataset informacion, int opcion) {
        abstract_ = informacion.getDatos().get(opcion - 1).get(0);
        web_url_ = informacion.getDatos().get(opcion - 1).get(1);
        lead_paragraph_ = informacion.getDatos().get(opcion - 1).get(2);
        source_ = informacion.getDatos().get(opcion - 1).get(3);
        word_count_ = Integer.parseInt(informacion.getDatos().get(opcion - 1).get(4));
    }

    public String toString() {
        return "Abstract: " + abstract_ + "\n" + "Web URL: " + web_url_ + "\n" + "Lead Paragraph: " + lead_paragraph_ + "\n" + "Source: " + source_ + "\n" + "Word Count: " + word_count_ + "\n" + "Es una revista de Video";
    }
}