package Supermercado.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Supermercado.model.Cliente;
import Supermercado.model.Supermercado;
import Supermercado.model.Categoria;
import Supermercado.model.Empleado;

public class SupermercadoDAO {
    private static final String fichero = "ClientesSupermercado.txt";

    public Supermercado getSupermercado() throws FormatoException{
        Supermercado supermercado = new Supermercado();
        try (BufferedReader brd = new BufferedReader(new FileReader(fichero))){
            Cliente cliente = null;
            String linea = brd.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                if(partes.length > 4 || partes.length < 3){
                    throw new FormatoException("Error de formato");
                }
                String nombre = partes[0];
                String tarjeta = partes[1];
                int porcentaje = Integer.parseInt(partes[2]);
                if(partes.length < 4){
                    cliente = new Cliente(tarjeta, nombre, porcentaje);
                }else{
                    Categoria categoria = Categoria.valueOf(partes[3]);
                    cliente = new Empleado(tarjeta, nombre, porcentaje, categoria);
                }
                supermercado.annadirCliente(cliente);
                linea = brd.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return supermercado;
    }

    public void aniadirCliente(Cliente cliente){
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(fichero,true))){
            String linea = cliente.getNombreCliente() + ";" + cliente.getnTarjeta() + ";" + cliente.getPorcentajeBonificiacion();
            if(cliente instanceof Empleado){
                Empleado empleado = (Empleado) cliente;
                linea += ";" + empleado.getCategoria().toString();
            }
            bfw.write(linea + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

    }
}
