package Supermercado.model;

public class Cliente {
    private String nTarjeta;
    private String nombreCliente;
    protected double saldoAcumuluado;
    protected int porcentajeBonificiacion;

    public Cliente(String nTarjeta, String nombreCliente, int porcentajeBonificiacion) {
        this.nTarjeta = nTarjeta;
        this.nombreCliente = nombreCliente;
        this.porcentajeBonificiacion = porcentajeBonificiacion;
        saldoAcumuluado = 0.0;
    }

    public void resetSaldoAcumulado(){
        saldoAcumuluado = 0.0;
    }

    public void incSaldoAcumulado( double compra){
        saldoAcumuluado += compra - (compra* (porcentajeBonificiacion/100));
    }

    public String getnTarjeta() {
        return nTarjeta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getSaldoAcumuluado() {
        return saldoAcumuluado;
    }

    public int getPorcentajeBonificiacion() {
        return porcentajeBonificiacion;
    }

    @Override
    public String toString() {
        return nombreCliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nTarjeta == null) ? 0 : nTarjeta.hashCode());
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
        if (nTarjeta == null) {
            if (other.nTarjeta != null)
                return false;
        } else if (!nTarjeta.equals(other.nTarjeta))
            return false;
        return true;
    }

    

    

    

    
}
