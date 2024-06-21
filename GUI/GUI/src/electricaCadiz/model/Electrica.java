package electricaCadiz.model;

import java.util.HashSet;
import java.util.Set;

public class Electrica {
    private Set<Cliente> clientes;

    public Electrica() {
        clientes = new HashSet<>();
    }

    public void agregaCliente(Cliente nuevoCliente){
        clientes.add(nuevoCliente);
    }

    public int getCantidadClientesPaneles(){
        Set<Cliente> clientesPaneles = new HashSet<>();
        for (Cliente cliente : clientes) {
            if(cliente instanceof ClientePaneles){
                clientesPaneles.add(cliente);
            }
        }

        return clientesPaneles.size();
    }

    public double getFacturacionTotal(){
        double facturaTotal = 0;
        for (Cliente cliente : clientes) {
            facturaTotal += cliente.importeFactura();
        }
        return facturaTotal;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    

    
}
