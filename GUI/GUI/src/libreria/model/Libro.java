package libreria.model;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private Double precio;
    private int cantidad;

    public Libro(int id, String titulo, String autor, Double precio, int cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.cantidad = cantidad;
    }

}
