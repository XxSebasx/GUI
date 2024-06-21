package bitacoras.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class BitacoraInteligente extends Bitacora {
    private Set<String> spam;
    private Set<String> cadenasProhibidas;

    public BitacoraInteligente() {
        spam = new HashSet<>();
        cadenasProhibidas = new HashSet<>();
    }

    



    public Set<String> getSpam() {
        return spam;
    }


    @Override
    public void agregaCadena(String cadena) {
        cadenasProhibidas.add(cadena);
    }

    @Override
    public void registarEntrada(String textoEvento,LocalDateTime fechaHora,Categoria categoria){
        textoEvento =  textoEvento.toLowerCase();
        boolean aniadibleSpam = false;
        for (String cadena : cadenasProhibidas) {
            if(textoEvento.contains(cadena)){
                aniadibleSpam = true;
                break;
            }
        }
        if(!aniadibleSpam){
            super.registarEntrada(textoEvento, fechaHora, categoria);
        }else{
            spam.add(textoEvento);
        }
        
        
        
    }

    @Override
    public void registarEntrada(String textoEvento,Categoria categoria){
        registarEntrada(textoEvento, LocalDateTime.now(), categoria);
    }



    @Override
    public String toString() {
        return "[BI-" + super.toString() + "]    Cadenas prohibidas:" + cadenasProhibidas;
    }

    




    
    
}
