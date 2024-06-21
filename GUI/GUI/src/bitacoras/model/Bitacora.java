package bitacoras.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
public abstract class Bitacora {
    private Set<Entrada> entradas;
    protected String identificador;
    private static int nid = 255;


    public Bitacora() {
        this.identificador = String.valueOf(nid);
        nid++;
        entradas = new TreeSet<>(new OrdenFechaEntrada());
    }

    public void registarEntrada(String textoEvento,LocalDateTime fechaHora,Categoria categoria){
        Entrada entrada = new Entrada(textoEvento, fechaHora, categoria);
        entradas.add(entrada);
    }

    public void registarEntrada(String textoEvento,Categoria categoria){
        registarEntrada(textoEvento, LocalDateTime.now(), categoria);
    }

    public Set<Entrada> getEntradas() {
        return entradas;
    }

    public Set<Entrada> buscarPor(String cadena, Categoria c){
        Set<Entrada> entradasEncontradas = new TreeSet<>(new OrdenFechaEntrada());
        for (Entrada entrada : entradas) {
            if(entrada.contiene(cadena, c)){
                entradasEncontradas.add(entrada);
            }
        }
        return entradasEncontradas;
    }

    public void incorpora(Bitacora otraBitacora){
        for (Entrada entrada : otraBitacora.getEntradas()) {
            registarEntrada(entrada.getTexto(), entrada.getHoraFecha(), entrada.getCategoria());
        }
    }

    public abstract void agregaCadena(String cadena);

    @Override
    public String toString() {
        return identificador;
    }

    

 

    



    
}
