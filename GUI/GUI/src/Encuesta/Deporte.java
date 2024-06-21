package Encuesta;

public enum Deporte {

    TENIS("Tenis"),FUTBOL("Fútbol");

    private String nombre;

    private Deporte(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    



    
    
}
