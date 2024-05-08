package AparcaBicicletas.model;

import java.lang.Comparable;

public class AparcaBicicleta implements Comparable<AparcaBicicleta> {
    private double x;
    private double y;
    private int id;
    private Barrio barrios;
    private int aros;
    private boolean instalado;

    public AparcaBicicleta(double x, double y, int id, Barrio barrios, int aros, boolean instalado) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.barrios = barrios;
        this.aros = aros;
        this.instalado = instalado;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public Barrio getBarrios() {
        return barrios;
    }

    public int getAros() {
        return aros;
    }

    public boolean isInstalado() {
        return instalado;
    }

    @Override
    public String toString() {
        String instaladoCadena = "SI";
        if (!instalado) {
            instaladoCadena = "NO";
        }
        return +x + ";" + y + ";" + id + ";" + barrios + ";" + aros + ";" + instaladoCadena;
    }

    @Override
    public int compareTo(AparcaBicicleta o) {
        return o.id - id;
    }

}
