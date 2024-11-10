package service;

import java.util.ArrayList;

public abstract class Documento implements Convertible{
    protected ArrayList<String> registros_;

    /**
     * Constructor vacío
     */
    public Documento() {
        registros_ = new ArrayList<>();
    }

    /**
     * Constructor con parametros
     * @param contenido
     */
    public Documento(String[] contenido){
        this();
        registros_ = new ArrayList<String>();
        for (int i = 0; i < contenido.length; i++) {
            registros_.add(contenido[i]);
        }
    }

    /**
     * Metodo abstracto para parsear el documento a un Dataset
     * @return Dataset
     */
    public abstract Dataset parser();

    /**
     * Metodo getter para obtener los registros
     * @return ArrayList<String>
     */
    public ArrayList<String> getRegistros() {
        return registros_;
    }

}
