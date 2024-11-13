package service;

public class ConexionAPIRevistas {
    // Atributos
    Dataset informacion_;

    /**
     * Constructor de la clase
     * @param url
     */
    public ConexionAPIRevistas(String url) {
        System.out.println("Downloading from: " + url);

        // Divide el contenido
        String[] contents = HTTPFileDownloader.downloadFromURL(url).split("\n");
        Convertible conversor_ = new JSON(contents);
        informacion_ = conversor_.parser();
    }

    /**
     * Devuelve la información
     * @return
     */
    public Dataset getInformacion() {
        return informacion_;
    }
}
