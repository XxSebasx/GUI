package AparcaBicicletas.model;

import java.lang.Comparable;
import java.util.Set;
import java.util.TreeSet;

public class Barrio implements Comparable<Barrio> {
    private String nombre;
    private int cantidadAparcabicis;
    private int instalados;
    private Set<AparcaBicicleta> aparcaBicicletas;

    public Barrio(String nombre) {
        this.nombre = nombre;
        cantidadAparcabicis = 0;
        instalados = 0;
        this.aparcaBicicletas = new TreeSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadAparcabicis() {
        return cantidadAparcabicis;
    }

    public int getInstalados() {
        return instalados;
    }

    public Set<AparcaBicicleta> getAparcaBicicletas() {
        return aparcaBicicletas;
    }

    public void incrementarCantidad() {
        cantidadAparcabicis++;
    }

    public void incrementarInstalados() {
        instalados++;
    }

    public void aniadirAparcabicicleta(AparcaBicicleta aparcaBicicleta) {
        aparcaBicicletas.add(aparcaBicicleta);
    }

    @Override
    public int compareTo(Barrio o) {
        return nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }

}
