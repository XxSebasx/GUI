package Encuesta;
import java.util.HashSet;
import java.util.Set;
public class Usuario {
    private String profesion;
    private int nHermanos;
    private int edad;
    private char Sexo;
    private boolean practicaDeporte;
    private Deporte deporte;
    private Set<Integer> gradosAficiones;

    public Usuario(String profesion, int nHermanos, int edad, char sexo, boolean practicaDeporte, Deporte deporte) {
        this.profesion = profesion;
        this.nHermanos = nHermanos;
        this.edad = edad;
        Sexo = sexo;
        this.practicaDeporte = practicaDeporte;
        this.deporte = deporte;
        gradosAficiones = new HashSet<>();
    }

    public void aniadirGradoAficicio(int grado){
        gradosAficiones.add(grado);
    }

    @Override
    public String toString() {
        return "profesion=" + profesion + ", nHermanos=" + nHermanos + ", edad=" + edad + ", Sexo=" + Sexo
                + ", practicaDeporte=" + practicaDeporte + ", deporte=" + deporte + ", gradosAficiones="
                + gradosAficiones;
    }

   

    

    
}
