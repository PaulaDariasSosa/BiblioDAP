package model;

public class RevistaCiencia extends Revista {

    public RevistaCiencia() {
        super();
    }

    public RevistaCiencia(String abstract_, String web_url_, String lead_paragraph_, String source_, int word_count) {
        super(abstract_, web_url_, lead_paragraph_, source_, word_count);
    }

    public void mostrar() {
        System.out.println("Abstract: " + abstract_);
        System.out.println("Web URL: " + web_url_);
        System.out.println("Lead Paragraph: " + lead_paragraph_);
        System.out.println("Source: " + source_);
        System.out.println("Word Count: " + word_count_);
        System.out.println("Es una revista de Ciencia");
    }

    public String toString() {
        return "Abstract: " + abstract_ + "\n" + "Web URL: " + web_url_ + "\n" + "Lead Paragraph: " + lead_paragraph_ + "\n" + "Source: " + source_ + "\n" + "Word Count: " + word_count_ + "\n" + "Es una revista de Ciencia";
    }
}
