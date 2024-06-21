package Hogwarts.model;

import java.util.HashSet;
import java.util.Set;

public class Casa {
    private String nombre;
    private String color;
    private String fundador;
    private String descripcion;
    private Set<Estudiante> estudiantes;

    

    public Casa(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Casa(String nombre, String color, String fundador, String descripcion) {
        this.nombre = nombre;
        this.color = color;
        this.fundador = fundador;
        this.descripcion = descripcion;
        estudiantes = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public String getFundador() {
        return fundador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void aniadirEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
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
        Casa other = (Casa) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Casa [nombre=" + nombre + "]";
    }

    

    
    
    
}
