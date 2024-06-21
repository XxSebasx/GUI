package electricaCadiz.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import electricaCadiz.model.Cliente;
import electricaCadiz.model.ClientePaneles;
import electricaCadiz.model.ClienteSmart;
import electricaCadiz.electricaDAO.ElectricaDAO;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ElectricaCadizController implements Initializable{
    private ElectricaDAO electricaDAO;

    @FXML
    private Button btnMostrarFacturacion;

    @FXML
    private Button btnMostrarPaneles;

    @FXML
    private Button btnaniadir;

    @FXML
    private TextField cantidadPaneles;

    @FXML
    private ComboBox<String> combobox;

    @FXML
    private TextField descuento;

    @FXML
    private TextField dni;

    @FXML
    private TextField facturaTotal;

    @FXML
    private ListView<Cliente> lista;

    @FXML
    private TextField potencia;

    @FXML
    void seleccion(ActionEvent event) {
        String tipo = combobox.getSelectionModel().getSelectedItem();
        if(tipo.equals("Smart")){
            descuento.setDisable(false);
        }
    }

    @FXML
    void aniadirCliente(ActionEvent event) {
        Cliente cliente = null;
        String DNI = dni.getText();
        Double p = Double.parseDouble(potencia.getText());
        String tipo = combobox.getSelectionModel().getSelectedItem();
        switch (tipo) {
            case "Comun":
                cliente = new Cliente(DNI, p);
                break;
            case "Panel":
                cliente = new ClientePaneles(DNI, p);
                break;
            case "Smart":
                Double porcentaje = Double.parseDouble(descuento.getText());
                cliente = new ClienteSmart(DNI, p, porcentaje);
                break;
        }

        if(!electricaDAO.getClientes().getClientes().contains(cliente)){
            electricaDAO.aniadirCliente(cliente);
            lista.getItems().add(cliente);
        }


    }

    @FXML
    void mostrarFacturacion(ActionEvent event) {
        facturaTotal.setText(String.valueOf(electricaDAO.getClientes().getFacturacionTotal()));
    }

    @FXML
    void mostrarPaneles(ActionEvent event) {
        cantidadPaneles.setText(String.valueOf(electricaDAO.getClientes().getCantidadClientesPaneles()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        electricaDAO = new ElectricaDAO();
        Set<Cliente> clientes = electricaDAO.getClientes().getClientes();
        lista.getItems().addAll(clientes);
        ObservableList<String> menu = FXCollections.observableArrayList("Comun", "Panel", "Smart");
        combobox.setItems(menu);
        combobox.setValue(menu.get(0));

    }

}
