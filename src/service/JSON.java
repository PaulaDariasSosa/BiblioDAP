package service;

import java.util.ArrayList;
import java.util.HashSet;

public class JSON extends Documento{

    /**
     * Constructor que recibe el contenido del JSON
     * @param contenido
     */
    public JSON(String[] contenido){
        super(contenido);
    }

    /**
     * Metodo para parsear un JSON
     * @return
     */
    @Override
    public Dataset parser() {
        ArrayList<String> atributos = new ArrayList<>();
        HashSet<String> atributosSet = new HashSet<>(); // Para evitar atributos duplicados
        ArrayList<ArrayList<String>>  resultado = new ArrayList<>();

        for (int i = 0; i < registros_.size(); i++) {
            String texto = registros_.get(i);
            // Expresiones regulares para encontrar el contenido entre los corchetes
            // El contenido fuera de los corchetes suele ser el nombre del archivo o similar
            String contenido = texto.replaceAll(".*?\\[(.*?)\\].*", "$1");
            registros_.set(i, contenido); // Guardar solo el contenido entre corchetes
        }
        //registros_ = resultado; // el contenido sin lo que habia fuera de [ ]
        // Procesar cada línea del contenido JSON
        for (String linea : registros_) {
            linea = linea.trim();
            if (linea.isEmpty() || !linea.startsWith("{") || !linea.endsWith("}")) {
                continue; // Ignorar líneas vacías o que no son instancias
            }

            // Dividir el contenido en pares clave-valor ( estan entre { })
            String[] instancias = linea.split("\\{");
            for (String aux: instancias) {
                // eliminar } de la instancia
                aux = aux.replaceAll("\\}", "");
                // Crear una lista para almacenar los datos de la fila
                ArrayList<String> filaDatos = new ArrayList<>();
                // La expresion sirve para encontrar comas (,) que no están dentro de comillas dobles en un texto
                String[] pares = aux.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // soluciona el problema cuando un atributo tiene varias valores (ej: "Hola, mundo")

                for (String par: pares) {
                    String[] claveValor = par.split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // separamos "esto" : " de esto"
                    String atributo = claveValor[0].trim().replaceAll("\"", ""); // quitar "
                    String valor = "";
                    if (claveValor.length == 2) {// Obtener el valor para el atributo del par
                        valor = claveValor[1];
                    }
                    // Agregar el atributo a la lista si no está presente o si no es vacio
                    if (!atributos.contains(atributo) && !atributo.isEmpty()) {
                        atributos.add(atributo); // Solo lo añadimos si no está
                    }
                    // Almacenar el valor (quitar comillas) en la fila de datos
                    String valorSinComillas = valor.replaceAll("\"", "").trim();
                    filaDatos.add(valorSinComillas);
                }
                // Agregar la fila de datos al registro siempre que los datos no esten vacios
                if (!String.join(",", filaDatos).isEmpty()) resultado.add(filaDatos); // Unir elementos en un solo String
            }

        }
        Dataset dataset = new Dataset();
        // Si no hay registros, devolvemos un dataset vacío
        if (resultado.isEmpty()) return dataset;

        // Procesar el nombre_ como los nombres de los atributos
        int numAtributos = atributos.size();  // Número de atributos para validar los registros
        dataset.setNombreAtributos(atributos);

        // Procesar las líneas de registros como datos
        for (ArrayList<String> lineas : resultado) {
            ArrayList<String> fila = new ArrayList<>();

            // Añadir los valores existentes y completar con null si faltan valores
            for (int i = 0; i < numAtributos; i++) {
                if (i < lineas.size()) {
                    fila.add(lineas.get(i).trim());  // Añadir valor existente
                } else {
                    fila.add(null);  // Completar con null si faltan valores
                }
            }
            dataset.addFilaDatos(fila);  // Añadir la fila de datos al dataset
        }
        return dataset;
    }

    public Dataset parserLibro() {
        ArrayList<String> atributos = new ArrayList<>();
        HashSet<String> atributosSet = new HashSet<>(); // Para evitar atributos duplicados
        ArrayList<ArrayList<String>>  resultado = new ArrayList<>();
        String registros = String.join("", registros_);
        registros_.clear();
        registros_.add(registros);
        for (int i = 0; i < registros_.size(); i++) {
            String texto = registros_.get(i);

            // Expresiones regulares para encontrar el contenido entre los corchetes
            // El contenido fuera de los corchetes suele ser el nombre del archivo o similar
            String contenido = texto.replaceAll(".*?\\[(.*)\\].*", "$1");
            registros_.set(i, contenido); // Guardar solo el contenido entre corchetes
        }
        //registros_ = resultado; // el contenido sin lo que había fuera de [ ]
        // Procesar cada línea del contenido JSON
        for (String linea : registros_) {
            linea = linea.trim();
            if (linea.isEmpty() || !linea.startsWith("{") || !linea.endsWith("}")) {
                continue; // Ignorar líneas vacías o que no son instancias
            }
            // Dividir el contenido en pares clave-valor ( estan entre { })
            String[] instancias = linea.split("\\{");
            for (String aux: instancias) {
                // eliminar } de la instancia
                aux = aux.replaceAll("\\}", "");
                // Crear una lista para almacenar los datos de la fila
                ArrayList<String> filaDatos = new ArrayList<>();
                // La expresion sirve para encontrar comas (,) que no están dentro de comillas dobles en un texto
                String[] pares = aux.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // soluciona el problema cuando un atributo tiene varias valores (ej: "Hola, mundo")

                for (String par: pares) {
                    String[] claveValor = par.split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // separamos "esto" : " de esto"
                    String atributo = claveValor[0].trim().replaceAll("\"", ""); // quitar "
                    String valor = "";
                    if (claveValor.length == 2) {// Obtener el valor para el atributo del par
                        valor = claveValor[1];
                        // Agregar el atributo a la lista si no está presente o si no es vacio
                        if (!atributos.contains(atributo) && !atributo.isEmpty()) {
                            atributos.add(atributo); // Solo lo añadimos si no está
                        }
                        // Almacenar el valor (quitar comillas) en la fila de datos
                        valor = valor.replaceAll(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", "");
                        valor = valor.replaceAll("[\\[]|\\]", "");
                        String valorSinComillas = valor.replaceAll("\"", "").trim();
                        filaDatos.add(valorSinComillas);
                    }

                }
                // Agregar la fila de datos al registro siempre que los datos no esten vacios
                if (!String.join(",", filaDatos).isEmpty()) resultado.add(filaDatos); // Unir elementos en un solo String
            }

        }
        Dataset dataset = new Dataset();
        // Si no hay registros, devolvemos un dataset vacío
        if (resultado.isEmpty()) return dataset;

        // Procesar el nombre_ como los nombres de los atributos
        int numAtributos = atributos.size();  // Número de atributos para validar los registros
        dataset.setNombreAtributos(atributos);

        // Procesar las líneas de registros como datos
        for (ArrayList<String> lineas : resultado) {
            ArrayList<String> fila = new ArrayList<>();

            // Añadir los valores existentes y completar con null si faltan valores
            for (int i = 0; i < numAtributos; i++) {
                if (i < lineas.size()) {
                    fila.add(lineas.get(i).trim());  // Añadir valor existente
                } else {
                    fila.add(null);  // Completar con null si faltan valores
                }
            }
            dataset.addFilaDatos(fila);  // Añadir la fila de datos al dataset
        }
        return dataset;
    }
}
