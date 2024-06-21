package Supermercado.model;

public class Empleado extends Cliente {
    private Categoria categoria;

    public Empleado(String nTarjeta, String nombreCliente, int porcentajeBonificiacion,Categoria categoria) {
        super(nTarjeta, nombreCliente, porcentajeBonificiacion);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public void incSaldoAcumulado( double compra){
        super.incSaldoAcumulado(compra + (compra * categoria.getValor()/100));
    }

    

    @Override
    public String toString() {
        return super.toString() + " Empleado: " + categoria;
    }



    

    

    
}
