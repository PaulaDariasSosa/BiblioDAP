package service;

public class ConexionAPILibros {
    // Atributos
    Dataset informacion_;

    // Constructor
    public ConexionAPILibros(String url) {
        System.out.println("Downloading from: " + url);

        // Divide el contenido
        String[] contents = HTTPFileDownloader.downloadFromURL(url).split("\n");
        JSON conversor_ = new JSON(contents);
        informacion_ = conversor_.parserLibro();
    }

    // Métodos
    public Dataset getInformacion() {
        return informacion_;
    }
}
