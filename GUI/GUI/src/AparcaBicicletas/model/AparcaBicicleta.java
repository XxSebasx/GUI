package AparcaBicicletas.model;

import java.lang.Comparable;

public class AparcaBicicleta implements Comparable<AparcaBicicleta> {
    private double x;
    private double y;
    private int id;
    private Barrio barrio;
    private int aros;
    private boolean instalado;

    public AparcaBicicleta(double x, double y, int id, Barrio barrio, int aros, boolean instalado) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.barrio = barrio;
        this.aros = aros;
        this.instalado = instalado;
    }

    public AparcaBicicleta(double x, double y, int id, int aros, boolean instalado) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.aros = aros;
        this.instalado = instalado;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public void setAros(int aros) {
        this.aros = aros;
    }

    public void setInstalado(boolean instalado) {
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

    public Barrio getBarrio() {
        return barrio;
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
        return +x + ";" + y + ";" + id + ";" + barrio + ";" + aros + ";" + instaladoCadena;
    }

    @Override
    public int compareTo(AparcaBicicleta o) {
        return o.id - id;
    }

}
