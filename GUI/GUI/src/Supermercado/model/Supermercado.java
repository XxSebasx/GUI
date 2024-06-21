package Supermercado.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Supermercado {
    private Set<Cliente> clientes;

    public Supermercado() {
        clientes = new HashSet<>();
    }

    public boolean annadirCliente(Cliente cliente){
        boolean aniadido = false;
        if(!clientes.contains(cliente)){
            clientes.add(cliente);
            aniadido = true;
        }

        return aniadido;
        
    }

    public boolean annadirSaldo( String tarjeta, double compra){
        for (Cliente cliente : clientes) {
            if(cliente.getnTarjeta().equals(tarjeta)){
                cliente.incSaldoAcumulado(compra);
                return true;
            }
        }

        return false;
    }

    public double totalSaldoEmpleados(){
        double totalSaldo = 0;
        for (Cliente cliente : clientes) {
            if(cliente instanceof Empleado){
                totalSaldo += cliente.getSaldoAcumuluado();
            }
            
        }

        return totalSaldo;
    }

    @Override
    public String toString() {
        return clientes.toString();
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    

    

    


    
}
