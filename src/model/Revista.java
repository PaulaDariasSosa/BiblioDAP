package model;

public class Revista implements Publicacion{
    protected String abstract_;
    protected String web_url_;
    protected String lead_paragraph_;
    protected String source_;
    protected int word_count_;

    /**
     * Constructor por defecto
     */
    public Revista(){
        abstract_ = "";
        web_url_ = "";
        lead_paragraph_ = "";
        source_ = "";
        word_count_ = 0;
    }

    /**
     * Constructor con parametros
     * @param abstract_ Resumen de la revista
     * @param web_url_ URL de la revista
     * @param lead_paragraph_ Parrafo principal de la revista
     * @param source_ Fuente de la revista
     * @param word_count_ Cantidad de palabras de la revista
     */
    public Revista(String abstract_, String web_url_, String lead_paragraph_, String source_, int word_count_){
        this.abstract_ = abstract_;
        this.web_url_ = web_url_;
        this.lead_paragraph_ = lead_paragraph_;
        this.source_ = source_;
        this.word_count_ = word_count_;
    }

    // Metodos de acceso

    /**
     * Metodo para obtener el resumen de la revista
     * @return
     */
    public String getAbstract_(){
        return abstract_;
    }

    /**
     * Metodo para obtener la URL de la revista
     * @return
     */
    public String getWeb_url_(){
        return web_url_;
    }

    /**
     * Metodo para obtener el parrafo principal de la revista
     * @return
     */
    public String getLead_paragraph_(){
        return lead_paragraph_;
    }

    /**
     * Metodo para obtener la fuente de la revista
     * @return
     */
    public String getSource_(){
        return source_;
    }

    /**
     * Metodo para obtener la cantidad de palabras de la revista
     * @return
     */
    public int getWord_count_(){
        return word_count_;
    }

    /**
     * Metodo para establecer el resumen de la revista
     */
    public void mostrar(){
        System.out.println("Abstract: " + abstract_);
        System.out.println("Web URL: " + web_url_);
        System.out.println("Lead Paragraph: " + lead_paragraph_);
        System.out.println("Source: " + source_);
        System.out.println("Word Count: " + word_count_);
    }

    /**
     * Metodo para establecer el resumen de la revista
     */
    public String toString(){
        return "Abstract: " + abstract_ + "\n" + "Web URL: " + web_url_ + "\n" + "Lead Paragraph: " + lead_paragraph_ + "\n" + "Source: " + source_ + "\n" + "Word Count: " + word_count_;
    }
}
