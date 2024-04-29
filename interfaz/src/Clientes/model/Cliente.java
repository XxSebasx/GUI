package Clientes.model;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String pais;

    public Cliente(int id, String nombre, String apellido, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

}
