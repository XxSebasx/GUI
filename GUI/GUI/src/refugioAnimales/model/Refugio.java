package refugioAnimales.model;

import java.util.Set;
import java.util.TreeSet;

public class Refugio {
    private Set<Animal> animales;

    public Refugio() {
        animales = new TreeSet<>();
    }

    public void aniadirAnimal(Animal animal){
        animales.add(animal);
    }

    
    
    
}
