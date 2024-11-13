package model;

public class Libro implements Publicacion{
    protected String titulo_;
    protected String autor_;
    protected long isbn_;
    protected String fecha_;

    /**
     * Constructor por defecto
     */
    public Libro(){
        titulo_ = "";
        autor_ = "";
        isbn_ = 0;
        fecha_ = "";
    }

    /**
     * Constructor con parámetros
     * @param titulo
     * @param autor
     * @param isbn
     * @param fecha
     */
    public Libro(String titulo, String autor, long isbn, String fecha) {
        this.titulo_ = titulo;
        this.autor_ = autor;
        this.isbn_ = isbn;
        this.fecha_ = fecha;
    }

    /**
     * Método para obtener el título
     * @return
     */
    public String getTitulo() {
        return titulo_;
    }

    /**
     * Método para obtener el autor
     * @return
     */
    public String getAutor() {
        return autor_;
    }

    /**
     * Método para obtener el ISBN
     * @return
     */
    public long getIsbn() {
        return isbn_;
    }

    /**
     * Método para obtener la fecha
     * @return
     */
    public String getFecha() {
        return fecha_;
    }

    /**
     * Método para establecer el título
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo_ = titulo;
    }

    /**
     * Método para establecer el autor
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor_ = autor;
    }

    /**
     * Método para establecer el ISBN
     * @param isbn
     */
    public void setIsbn(long isbn) {
        this.isbn_ = isbn;
    }

    /**
     * Método para establecer la fecha
     * @param fecha
     */
    public void setFecha(String fecha_) {
        this.fecha_ = fecha_;
    }

    /**
     * Método para mostrar los datos del libro
     * @return
     */
    public String toString() {
        return "Titulo: " + titulo_ + "\n" + "Autor: " + autor_ + "\n" + "ISBN: " + isbn_ + "\n" + "Fecha: " + fecha_;
    }

    /**
     * Método para mostrar los datos del libro
     */
    public void mostrar(){
        System.out.println(this.toString());
    }
}
