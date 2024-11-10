package service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPFileDownloader {
    private static final int BUFFER_SIZE = 1024;

    // Constructor privado para evitar instanciación
    private HTTPFileDownloader() {}

    /**
     * Descarga el contenido de una URL como una cadena de texto.
     * @param link URL de la cual descargar contenido
     * @return Contenido de la URL en formato String
     */
    public static String downloadFromURL(String link) {
        StringBuilder myURLContent = new StringBuilder();

        try (BufferedInputStream in = new BufferedInputStream(new URL(link).openStream())) {
            byte[] byteContents = new byte[BUFFER_SIZE];
            int bytesRead;

            // Lectura del contenido en bloques de bytes
            while ((bytesRead = in.read(byteContents)) != -1) {
                myURLContent.append(new String(byteContents, 0, bytesRead, "UTF-8"));
            }

            return myURLContent.toString();
        } catch (MalformedURLException e) {
            System.err.println("URL malformada: " + link);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de IO al descargar desde la URL: " + link);
            e.printStackTrace();
        }

        // Retorno en caso de error
        return "Error al descargar contenido.";
    }
}
