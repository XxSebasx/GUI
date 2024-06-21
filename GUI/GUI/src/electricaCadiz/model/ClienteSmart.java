package electricaCadiz.model;

public class ClienteSmart extends Cliente {
    private double porcentajeDescuento;
    public ClienteSmart(String DNI, double potenciaEncontrada, double porcentajeDescuento) {
        super(DNI, potenciaEncontrada);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double importeFactura(){
        double factura = super.importeFactura();
        return  factura - (factura * (porcentajeDescuento / 100));
    }

    @Override
    public String toString() {
        return super.toString() + "," + "SMART" + "," + porcentajeDescuento;
    }

    

}
