
package models;


public class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private int idCategoria;

    public Libro() {
    }

    public Libro(String titulo, String autor, int idCategoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.idCategoria = idCategoria;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

   
    
}
