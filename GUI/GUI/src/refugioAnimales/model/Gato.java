package refugioAnimales.model;

import java.time.LocalDate;

public class Gato extends Animal{

    public Gato(String nombre, char sexo, LocalDate fecha, int id) {
        super(nombre, sexo, fecha, id);
    }

    @Override
    public String nombre() {
        return "Gato: " + nombre();
    }

   
    
}
