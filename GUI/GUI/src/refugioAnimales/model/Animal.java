package refugioAnimales.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal {
    private String nombre;
    private char sexo;
    private LocalDate fecha;
    private int id;
    private Set<Dosis> historialDosis;

    public Animal(String nombre, char sexo, LocalDate fecha, int id) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha = fecha;
        this.id = id;
        historialDosis = new HashSet<>();
    }

    public abstract String nombre();

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }





   

}
