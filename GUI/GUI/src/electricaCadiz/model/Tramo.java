package electricaCadiz.model;

public enum Tramo {
    TRAMO1(5, 0.00138), TRAMO2(7, 0.00276),TRAMO3(9, 0.01104);
    private int costoTerminoFijo;
    private double costoKwh;
    
    private Tramo(int costoTerminoFijo, double costoKwh) {
        this.costoTerminoFijo = costoTerminoFijo;
        this.costoKwh = costoKwh;
    }

    public int getCostoTerminoFijo() {
        return costoTerminoFijo;
    }

    public double getCostoKwh() {
        return costoKwh;
    }

    
    
    
}
