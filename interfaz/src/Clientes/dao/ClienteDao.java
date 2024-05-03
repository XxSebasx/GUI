package Clientes.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Clientes.model.Cliente;

public class ClienteDao {
    private static final String archivo = "clientes.txt";
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String apellido = partes[2];
                String pais = partes[3];
                Cliente c = new Cliente(id, nombre, apellido, pais);
                clientes.add(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public void aniadirCliente(Cliente cliente){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true))){
            String cadena = cliente.getId() + ";" + cliente.getNombre() + ";" + cliente.getApellido() + ";" + cliente.getPais();
            bw.newLine();
            bw.write(cadena);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

 
}
