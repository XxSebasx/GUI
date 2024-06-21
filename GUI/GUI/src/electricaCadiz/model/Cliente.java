package electricaCadiz.model;
public class Cliente {
    protected String DNI;
    protected double contadorEnergiaConsumida;
    protected  double energiaConsumida;
    protected double potenciaEncontrada;

    public Cliente(String DNI, double potenciaEncontrada) {
        this.DNI = DNI;
        this.potenciaEncontrada = potenciaEncontrada;
        energiaConsumida = 0.0;
        contadorEnergiaConsumida = 0.0;
    }

    public void actualizaEnergiaConsumida(double nuevaLecturaContador){
        energiaConsumida +=  nuevaLecturaContador - contadorEnergiaConsumida;
        contadorEnergiaConsumida = nuevaLecturaContador;
    }

    public double importeFactura(){
        double importe = Tramo.TRAMO1.getCostoTerminoFijo() + (Tramo.TRAMO1.getCostoKwh() *energiaConsumida);
        if(potenciaEncontrada >= 3.4 && potenciaEncontrada <= 6.4){
            importe = Tramo.TRAMO2.getCostoTerminoFijo() + (Tramo.TRAMO2.getCostoKwh() *energiaConsumida);
        }else{
            importe = Tramo.TRAMO3.getCostoTerminoFijo() + (Tramo.TRAMO3.getCostoKwh() *energiaConsumida);
        }
        return importe;
    }

    @Override
    public String toString() {
        return DNI + "," + potenciaEncontrada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (DNI == null) {
            if (other.DNI != null)
                return false;
        } else if (!DNI.equals(other.DNI))
            return false;
        return true;
    }

    

    


    
}
