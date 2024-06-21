package libreria.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Publicacion {
    private String tipo;
    private String titulo;
    private Set<Autor>autores;
    private LocalDate fecha;
    private String categoria;
    private String ISBN;
    private String editorial;
    private int nPaginas;
    public String descripcion;


    public Publicacion(String tipo, String titulo, LocalDate fecha, String categoria, String ISBN, String editorial,int nPaginas, String descripcion) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.fecha = fecha;
        this.categoria = categoria;
        this.ISBN = ISBN;
        this.editorial = editorial;
        this.nPaginas = nPaginas;
        this.descripcion = descripcion;
        autores = new HashSet<>();
    }

    




    public String getTipo() {
        return tipo;
    }






    public String getTitulo() {
        return titulo;
    }






    public LocalDate getFecha() {
        return fecha;
    }






    public String getCategoria() {
        return categoria;
    }






    public String getISBN() {
        return ISBN;
    }






    public String getEditorial() {
        return editorial;
    }






    public int getnPaginas() {
        return nPaginas;
    }






    public String getDescripcion() {
        return descripcion;
    }




    public void aniadirAutor(Autor autor){
        autores.add(autor);
    }

    






    @Override
    public String toString() {
        return "[" + ISBN + "]." + autores + " " + titulo + " " + fecha + ". " + categoria + ". " + editorial;
    }






    public Set<Autor> getAutores() {
        return autores;
    }

    


    

    


    
    
    
}
