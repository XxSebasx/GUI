package libreria.model;

import java.util.HashSet;
import java.util.Set;

public class Autor {
    private String nombre;
    private String materia;
  

    private Set<Publicacion> publicaciones;

    public Autor(String nombre, String materia) {
        this.nombre = nombre;
        this.materia = materia;
        publicaciones = new HashSet<>();
    }

    public void aniadirPublicacion(Publicacion publicacion){
        publicaciones.add(publicacion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }

    public Set<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    @Override
    public String toString() {
        return  nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autor other = (Autor) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    

    

    
}
