package bitacoras.model;

import java.util.Comparator;

public class OrdenFechaEntrada implements Comparator <Entrada>{

    @Override
    public int compare(Entrada entrada, Entrada entrada2) {
        if(entrada.getHoraFecha().equals(entrada2.getHoraFecha())){
            return entrada2.getCategoria().compareTo(entrada.getCategoria());

        }else{
            return entrada2.getHoraFecha().compareTo(entrada.getHoraFecha());
        }
    }
    
}
