package Clientes.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Clientes.dao.ClienteDao;
import Clientes.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ClienteController implements Initializable {
    private ClienteDao clienteDao;

    @FXML
    private TextField apellido;

    @FXML
    private Button btinsertar;

    @FXML
    private TextField id;

    @FXML
    private ListView<Cliente> listaClientes;

    @FXML
    private Label mostrarApellido;

    @FXML
    private Label mostrarId;

    @FXML
    private Label mostrarNombre;

    @FXML
    private Label mostrarPais;

    @FXML
    private TextField nombre;

    @FXML
    private TextField pais;

    @FXML
    void insertar(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clienteDao = new ClienteDao();
        List<Cliente> clientes = clienteDao.getClientes();
        listaClientes.getItems().addAll(clientes);
    }

}
