package model;

public class Revista implements Publicacion{
    protected String abstract_;
    protected String web_url_;
    protected String lead_paragraph_;
    protected String source_;
    protected int word_count_;

    //constructor vacio
    public Revista(){
        abstract_ = "";
        web_url_ = "";
        lead_paragraph_ = "";
        source_ = "";
        word_count_ = 0;
    }

    public Revista(String abstract_, String web_url_, String lead_paragraph_, String source_, int word_count_){
        this.abstract_ = abstract_;
        this.web_url_ = web_url_;
        this.lead_paragraph_ = lead_paragraph_;
        this.source_ = source_;
        this.word_count_ = word_count_;
    }

    public String getAbstract_(){
        return abstract_;
    }

    public String getWeb_url_(){
        return web_url_;
    }

    public String getLead_paragraph_(){
        return lead_paragraph_;
    }

    public String getSource_(){
        return source_;
    }

    public int getWord_count_(){
        return word_count_;
    }

    // mostrar con saltos de linea
    public void mostrar(){
        System.out.println("Abstract: " + abstract_);
        System.out.println("Web URL: " + web_url_);
        System.out.println("Lead Paragraph: " + lead_paragraph_);
        System.out.println("Source: " + source_);
        System.out.println("Word Count: " + word_count_);
    }
}
