package bitacoras.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entrada {
    private String texto;
    private LocalDateTime horaFecha;
    private Categoria categoria;

    protected Entrada(String texto, LocalDateTime horaFecha, Categoria categoria) {
        this.texto = texto;
        this.horaFecha = horaFecha;
        this.categoria = categoria;
    }

    public String getTexto() {
        return texto;
    }

    

    public LocalDateTime getHoraFecha() {
        return horaFecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    protected boolean contiene(String palabrasClave, Categoria categoriaClave){
        boolean encontrada = false;
        if(texto.contains(palabrasClave) || categoria.equals(categoriaClave)){
            encontrada = true;
        }
        return encontrada;
    }

    @Override
    public String toString() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        String fechaFormateado = horaFecha.format(formateador);
        return fechaFormateado + " " + categoria + " " + texto;
    }




    

    

    

}
