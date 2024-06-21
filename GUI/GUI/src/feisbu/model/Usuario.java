package feisbu.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
    // Atributos
    private Set<Usuario> amigos;
    private Set<Grupo> grupos;
    private String nombre;
    private String nombreCompleto;
    private LocalDate fechaRegistro;
    private char genero;

    // Constructores
    // <Inserta tu código aquí>
    public Usuario(String nombre, String nombreCompleto) {
        this(nombre, nombreCompleto, LocalDate.of(2010, 2, 2), ' ');
    }

    

    public Usuario(String nombre) {
        this(nombre, nombre);
    }



    public Usuario(String nombre, String nombreCompleto, LocalDate fechaRegistro, char genero) {
        this.nombre = nombre;
        this.nombreCompleto = nombreCompleto;
        this.fechaRegistro = fechaRegistro;
        this.genero = genero;
        amigos = new HashSet<>();
        grupos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public char getGenero() {
        return genero;
    }

    public boolean esAmigo(Usuario unUsuario) {
        boolean amigo = true;
        if(!amigos.contains(unUsuario)){
            amigo = false;
        }

        return amigo;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    // método para obtener amigos
    public Set<Usuario> getAmigos() {
        return amigos;
    }

    // método para obtener grupos
    public Set<Grupo> getGrupos() {
        return grupos;
    }

    // método para agregar un amigo
    public void aniadirAmigo(Usuario usuario){
        amigos.add(usuario);
    }

 

    // método para agregar un grupo
    public void aniadirGrupo(Grupo grupo){
        grupos.add(grupo);
    }

    public Set<Usuario> amigosDeGenero(char genero) {
        Set<Usuario> amigosGenero = new HashSet<>();
        for (Usuario usuario : amigos) {
            if(usuario.getGenero() == genero){
                amigosGenero.add(usuario);
            }
        }

        if(amigosGenero.isEmpty()){
            amigosGenero = null;
        }

        return amigosGenero;
    }

    @Override
    public String toString() {
        return nombre;
    }



    
}
