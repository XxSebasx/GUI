package refugioAnimales.model;

import java.time.LocalDate;

public class Perro extends Animal {

    public Perro(String nombre, char sexo, LocalDate fecha, int id) {
        super(nombre, sexo, fecha, id);
    }

    @Override
    public String nombre() {
       return "Perro: " + nombre();
    }

 
    
}
