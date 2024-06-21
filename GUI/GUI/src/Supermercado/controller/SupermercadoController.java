package Supermercado.controller;

import java.net.URL;
import java.util.ResourceBundle;
import Supermercado.model.Cliente;
import Supermercado.model.Supermercado;
import Supermercado.dao.FormatoException;
import Supermercado.dao.SupermercadoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SupermercadoController implements Initializable {
    private SupermercadoDAO supermercadoDAO;

    @FXML
    private Button btnAniadirSaldo;

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnMostrar;

    @FXML
    private TextField compra;

    @FXML
    private ListView<Cliente> listaClientes;

    @FXML
    private TextField nombre;

    @FXML
    private TextField porcentaje;

    @FXML
    private TextField saldo;

    @FXML
    private TextField saldoEmpleados;

    @FXML
    private TextField tarjeta;

    @FXML
    private TextField tarjetaSaldo;

    @FXML
    void aniadir(ActionEvent event) {
        Cliente cliente = new Cliente(tarjeta.getText(), nombre.getText(), Integer.parseInt(porcentaje.getText()));
        listaClientes.getItems().add(cliente);
        supermercadoDAO.aniadirCliente(cliente);
    }

    @FXML
    void aniadirSaldo(MouseEvent event) {
        Cliente cliente = listaClientes.getSelectionModel().getSelectedItem();
        double precio = Double.parseDouble(compra.getText());
        cliente.incSaldoAcumulado(precio);
        saldo.setText(String.valueOf(cliente.getSaldoAcumuluado()));
    }

    @FXML
    void mostrarSaldoEmpleados(MouseEvent event) {
        Supermercado supermercado = new Supermercado();
        for (Cliente cliente : listaClientes.getItems()) {
            supermercado.annadirCliente(cliente);
        }

        saldoEmpleados.setText(String.valueOf(supermercado.totalSaldoEmpleados()));
    }

    @FXML
    void mostrarTarjeta(MouseEvent event) {
        Cliente cliente = listaClientes.getSelectionModel().getSelectedItem();
        tarjetaSaldo.setText(cliente.getnTarjeta());
        saldo.setText(String.valueOf(cliente.getSaldoAcumuluado()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        supermercadoDAO = new SupermercadoDAO();
        try {
            listaClientes.getItems().addAll(supermercadoDAO.getSupermercado().getClientes());
        } catch (FormatoException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
