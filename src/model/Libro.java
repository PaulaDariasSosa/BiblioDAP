package model;

public class Libro implements Publicacion{
    protected String titulo_;
    protected String autor_;
    protected long isbn_;
    protected String fecha_;

    public Libro(){
        titulo_ = "";
        autor_ = "";
        isbn_ = 0;
        fecha_ = "";
    }

    public Libro(String titulo, String autor, long isbn, String fecha) {
        this.titulo_ = titulo;
        this.autor_ = autor;
        this.isbn_ = isbn;
        this.fecha_ = fecha;
    }

    public String getTitulo() {
        return titulo_;
    }

    public String getAutor() {
        return autor_;
    }

    public long getIsbn() {
        return isbn_;
    }

    public String getFecha() {
        return fecha_;
    }

    public void setTitulo(String titulo) {
        this.titulo_ = titulo;
    }

    public void setAutor(String autor) {
        this.autor_ = autor;
    }

    public void setIsbn(long isbn) {
        this.isbn_ = isbn;
    }

    public void setFecha(String fecha_) {
        this.fecha_ = fecha_;
    }

    public String toString() {
        return "model.Libro{" +
                "titulo='" + titulo_ + '\'' +
                ", autor='" + autor_ + '\'' +
                ", isbn=" + isbn_ +
                ", fecha_=" + fecha_ +
                '}';
    }

    public void mostrar(){
        System.out.println(this.toString());
    }
}
