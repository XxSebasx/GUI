package bitacoras.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.LocalDateTime;
import bitacoras.model.Bitacora;
import bitacoras.model.BitacoraClaves;
import bitacoras.model.BitacoraInteligente;
import bitacoras.model.Categoria;
import bitacoras.model.Entrada;

public class BitacorasDAO {
    private String fichero;
    

    public BitacorasDAO(String fichero){
        this.fichero = fichero;
    }


    public Set<Bitacora> getBitacoras() throws ArchivoException{
        Set<Bitacora> bitacoras = new HashSet<>();
        try (BufferedReader brd = new BufferedReader(new FileReader(fichero))){
            String linea = brd.readLine();
            Bitacora bitacora = null;
            while (linea != null) {
                String [] partes = linea.split(":");
                String tipo = partes[0];
                String[] datos = partes[1].split(";");
                if(!tipo.equals("entrada")){
                    if(tipo.equals("C")){
                        bitacora = new BitacoraClaves();

                    }else{
                        bitacora = new BitacoraInteligente();
                    }

                    for (String palabra : datos) {
                        bitacora.agregaCadena(palabra);
                    }
                }else{
                    String texto = datos[0];
                    Categoria categoria = Categoria.valueOf(datos[1]);
                    int anio = Integer.parseInt(datos[2]);
                    int mes = Integer.parseInt(datos[3]);
                    int dia = Integer.parseInt(datos[4]);
                    int hora = Integer.parseInt(datos[5]);
                    int minutos = Integer.parseInt(datos[6]);
                    int segundos = Integer.parseInt(datos[7]);
                    bitacora.registarEntrada(texto,LocalDateTime.of(anio,mes,dia,hora,minutos,segundos),categoria);
                }

                if(!bitacoras.contains(bitacora)){
                    bitacoras.add(bitacora);
                }

                linea = brd.readLine();
            }
            
        } catch (IOException e) {
            throw new ArchivoException("Problemas con el fichero");
        }
        return bitacoras;
    }

     public static void main(String[] args) {
         BitacorasDAO bitacorasDAO = new BitacorasDAO("bitacoras.txt");
         try {
             System.out.println(bitacorasDAO.getBitacoras().toString());
         } catch (ArchivoException e) {
             e.printStackTrace();
         }
    }


}
