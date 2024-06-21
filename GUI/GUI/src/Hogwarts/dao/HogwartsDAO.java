package Hogwarts.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import Hogwarts.model.Casa;
import Hogwarts.model.Estudiante;

public class HogwartsDAO {
    private final static String ficheroCasa = "casas.txt";
    private final static String ficheroEstudiante = "clasificacion.txt";

    public Set<Casa> getCasas(){

        Set<Casa> casas = new HashSet<>();
        try (BufferedReader bwr = new BufferedReader(new FileReader(ficheroCasa));
        BufferedReader bwr2 = new BufferedReader(new FileReader(ficheroEstudiante))){

            String linea = bwr.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String color = partes[1];
                String fundador = partes[2];
                String descripcion = partes[3];
                Casa casa = new Casa(nombre, color, fundador, descripcion);
                casas.add(casa);
                linea = bwr.readLine();
            }

            String linea2 = bwr2.readLine();
            while (linea2 != null) {
                String[] partes = linea2.split(";");
                String nombre = partes[0];
                Casa casaEstudiante = new Casa(partes[1]);
                for (Casa casa : casas) {
                    if(casa.equals(casaEstudiante)){
                        casa.aniadirEstudiante(new Estudiante(nombre, casaEstudiante));
                    }
                }
                linea2 = bwr2.readLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return casas;
    }
    
}
