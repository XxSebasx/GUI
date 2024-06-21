package electricaCadiz.model;

public class ClientePaneles extends Cliente {
    private double energiaInyectada;
    private double contadorEnergiaInyectada;

    public ClientePaneles(String DNI, Double potencia) {
        super(DNI, potencia);
        energiaInyectada = 0.0;
        contadorEnergiaInyectada = 0.0;
        energiaInyectada = 0.0;
    }


    public void actualizaEnergiaInyectada(double nuevaLecturaContador){
        energiaInyectada = nuevaLecturaContador - contadorEnergiaInyectada;
        contadorEnergiaInyectada = nuevaLecturaContador;
    }

    @Override
    public double importeFactura(){
       return super.importeFactura() - (energiaInyectada * 0.0034);
    }


    @Override
    public String toString() {
        return super.toString() + "," + "PANEL";
    }

    


}
