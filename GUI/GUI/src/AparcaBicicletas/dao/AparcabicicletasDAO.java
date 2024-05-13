package AparcaBicicletas.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import AparcaBicicletas.model.AparcaBicicleta;
import AparcaBicicletas.model.Barrio;

public class AparcabicicletasDAO {

    private final static String archivo = "Aparcabicicletas.csv";

    public Set<Barrio> getBarrios() {
        Map<String, Barrio> mapaBarrio = new HashMap<>();
        try (BufferedReader bbfr = new BufferedReader(new FileReader(archivo))) {
            String linea = bbfr.readLine();
            while (linea != null) {
                String[] partes = linea.split(",");
                String nombreBarrio = partes[3];
                double x = Double.parseDouble(partes[0]);
                double y = Double.parseDouble(partes[1]);
                int id = Integer.parseInt(partes[2]);
                int aros = Integer.parseInt(partes[4]);
                boolean instalado = true;
                if (partes[5].equals("NO")) {
                    instalado = false;
                }
                AparcaBicicleta aparcaBicicleta = new AparcaBicicleta(x, y, id, aros, instalado);
                if (!mapaBarrio.containsKey(nombreBarrio)) {
                    mapaBarrio.put(nombreBarrio, new Barrio(nombreBarrio));
                }
                Barrio barrio = mapaBarrio.get(nombreBarrio);
                barrio.aniadirAparcabicicleta(aparcaBicicleta);
                aparcaBicicleta.setBarrio(barrio);

                linea = bbfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Barrio> barrios = new TreeSet<>(mapaBarrio.values());

        return barrios;
    }

}
