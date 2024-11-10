package model;

import service.*;

import java.util.Scanner;

public class RevistaModa extends Revista{
    public RevistaModa(){
        super();
        ConexionAPIRevistas conexion = new ConexionAPIRevistas("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=news_desk:(\"Fashion\")&sort=newest&api-key=BsEGWJx6KO6rf0Y9OJJh692KPvCUUAUC&fl=abstract,lead_paragraph,source,web_url,word_count");
        Dataset informacion = conexion.getInformacion();

        System.out.println("Revistas de moda:");
        informacion.show();

        System.out.println("Elija una revista de moda(introduzca un numero de 1 a " + informacion.getDatos().size() + "):");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();

        abstract_ = informacion.getDatos().get(opcion-1).get(0);
        web_url_  = informacion.getDatos().get(opcion-1).get(1);
        lead_paragraph_ = informacion.getDatos().get(opcion-1).get(2);
        source_  = informacion.getDatos().get(opcion-1).get(3);
        word_count_ = Integer.parseInt(informacion.getDatos().get(opcion-1).get(4));

    }
}
