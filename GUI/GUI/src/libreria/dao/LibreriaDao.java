package libreria.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import libreria.model.Autor;
import libreria.model.Publicacion;

public class LibreriaDao {
    private static final String fichero= "publicaciones.txt";

    public Set<Publicacion> getPublicaciones(){
        Map<Autor,Set<Publicacion>> mapa = new HashMap<>();
        Set<Publicacion> publicaciones = new HashSet<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(fichero))){
            String linea = bfr.readLine();
            while (linea != null) {
                String [] partes = linea.split(";");
                String tipo = partes[0];
                String titulo = partes[1];
                String descripcion = partes[partes.length - 1];
                int nPaginas = Integer.parseInt(partes[partes.length - 2]);
                String editorial = partes[partes.length - 3];
                String ISBN = partes[partes.length - 4];
                String categoria = partes[partes.length - 5];
                String materia = "informatica";
                if(!categoria.equals("I")){
                    materia = "biologia";
                }
                int dia = Integer.parseInt(partes[partes.length - 6]);
                int mes = Integer.parseInt(partes[partes.length - 7]);
                int anio = Integer.parseInt(partes[partes.length - 8]);
                Publicacion publicacion = new Publicacion(tipo, titulo, LocalDate.of(anio, mes, dia), materia, ISBN, editorial, nPaginas,descripcion);
                for (int i = 2; i < partes.length - 8; i++) {
                    String nombreAutor = partes[i];
                    Autor autor = new Autor(nombreAutor, materia);;
                    Set<Publicacion> conuntPublicacions = new HashSet<>();
                    if(!mapa.containsKey(autor)){
                        mapa.put(autor, conuntPublicacions);

                    }
                    mapa.get(autor).add(publicacion);
                    
                }
                linea = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Autor autor : mapa.keySet()) {
            for (Publicacion publicacion : mapa.get(autor)) {
                autor.aniadirPublicacion(publicacion);
                publicacion.aniadirAutor(autor);
                if(!publicaciones.contains(publicacion)){
                    publicaciones.add(publicacion);
                }
                
            }
        }
        
        return publicaciones;
    }

    public static void main(String[] args) {
        // LibreriaDao libreriaDao = new LibreriaDao();
        // List<Publicacion> lista = new LinkedList<>(libreriaDao.getPublicaciones());
        // System.out.println(lista.get(4));
        // List<Autor> lista2 = new LinkedList<>(lista.get(4).getAutores());
        // System.out.println(lista2);
        // List<Publicacion> lista3 = new LinkedList<>(lista2.get(1).getPublicaciones());
        // System.out.println(lista3);
        
        
    }
}
