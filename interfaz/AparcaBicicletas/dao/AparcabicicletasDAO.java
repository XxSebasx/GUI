package AparcaBicicletas.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import AparcaBicicletas.model.AparcaBicicleta;
import AparcaBicicletas.model.Barrio;

public class AparcabicicletasDAO {

    private final static String archivo = "Aparcabicicletas.csv";

    public Set<Barrio> getBarrios() {
        Set<Barrio> barrios = new TreeSet<>();
        try (BufferedReader bbfr = new BufferedReader(new FileReader(archivo));
                BufferedReader abfr = new BufferedReader(new FileReader(archivo))) {

            String linea = bbfr.readLine();

            while (linea != null) {
                String[] partes = linea.split(",");
                Barrio barrio = new Barrio(partes[3]);
                barrios.add(barrio);
                linea = bbfr.readLine();
            }

            linea = abfr.readLine();
            while (linea != null) {
                String[] partes = linea.split(",");
                double x = Double.parseDouble(partes[0]);
                double y = Double.parseDouble(partes[1]);
                int id = Integer.parseInt(partes[2]);

                int aros = Integer.parseInt(partes[4]);
                boolean instalado = true;
                if (partes[5].equals("NO")) {
                    instalado = false;
                }

                String nombreBarrio = partes[3];
                Barrio b = new Barrio(nombreBarrio);

                AparcaBicicleta aparcaBicicleta = new AparcaBicicleta(x, y, id, b, aros, instalado);
                for (Barrio barrio : barrios) {
                    if (barrio.getNombre().equals(nombreBarrio)) {
                        barrio.aniadirAparcabicicleta(aparcaBicicleta);
                        barrio.incrementarCantidad();
                        if (aparcaBicicleta.isInstalado()) {
                            barrio.incrementarInstalados();
                        }
                    }
                }
                linea = abfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return barrios;
    }

}
