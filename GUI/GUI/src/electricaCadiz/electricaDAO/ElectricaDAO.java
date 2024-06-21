package electricaCadiz.electricaDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import electricaCadiz.model.Cliente;
import electricaCadiz.model.ClientePaneles;
import electricaCadiz.model.ClienteSmart;
import electricaCadiz.model.Electrica;

public class ElectricaDAO {
    private static final String fichero = "clientes.csv";

    public Electrica getClientes(){
        Electrica electrica = new Electrica();
        try (BufferedReader brd = new BufferedReader(new FileReader(fichero))){
            brd.readLine();
            String linea = brd.readLine();
            while (linea != null) {
                Cliente cliente;
                String[] partes = linea.split(",");
                String dni = partes[0];
                Double potencia = Double.parseDouble(partes[1]);
                if( partes.length > 2){
                    if(partes[2].equals("PANEL")){
                        cliente = new ClientePaneles(dni, potencia);
                    }else{
                        Double porcentaje = Double.parseDouble(partes[3]);
                        cliente = new ClienteSmart(dni, potencia, porcentaje);
                    }
                }else{
                    cliente = new Cliente(dni, potencia);
                }
                electrica.agregaCliente(cliente);
                linea = brd.readLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return electrica;
    }

    public void aniadirCliente(Cliente cliente){

        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(fichero,true))){
            bfw.write(cliente.toString() +  "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
