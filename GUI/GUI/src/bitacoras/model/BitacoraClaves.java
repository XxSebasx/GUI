package bitacoras.model;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class BitacoraClaves extends Bitacora {

    private Set<String> palabrasClave;


    public BitacoraClaves() {
        palabrasClave = new TreeSet<>();
    }

    @Override
    public void agregaCadena(String cadena) {
        palabrasClave.add(cadena);
    }

    @Override
    public void registarEntrada(String textoEvento,LocalDateTime fechaHora,Categoria categoria){
        textoEvento =  textoEvento.toLowerCase();
        boolean aniadible = false;
        for (String cadena : palabrasClave) {
            if(textoEvento.contains(cadena)){
                aniadible = true;
                break;
            }
        }
        if(aniadible){
            super.registarEntrada(textoEvento, fechaHora, categoria);
        }
    }

    @Override
    public void registarEntrada(String textoEvento,Categoria categoria){
       registarEntrada(textoEvento, LocalDateTime.now(), categoria);
    }

    @Override
    public String toString() {
        return "[BC-" + super.toString() + "]    Palabras Clave: " + palabrasClave;
    }
    
    
}
