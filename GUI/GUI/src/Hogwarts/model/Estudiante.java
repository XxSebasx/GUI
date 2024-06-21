package Hogwarts.model;

public class Estudiante {
    private String nombre;
    private Casa casa;
    private Rango rango;
    private int edad;

   

    public Estudiante(String nombre, Casa casa, Rango rango, int edad) {
        this.nombre = nombre;
        this.casa = casa;
        this.rango = rango;
        this.edad = edad;
    }    

    public Estudiante(String nombre, Casa casa) {
        this.nombre = nombre;
        this.casa = casa;
    }



    public String getNombre() {
        return nombre;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Casa getCasa() {
        return casa;
    }

    public Rango getRango() {
        return rango;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre;
    }

  

    

    
    

    

}
