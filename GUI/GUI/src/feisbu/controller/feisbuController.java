package feisbu.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import feisbu.dao.FeisbuDAO;
import feisbu.model.Grupo;
import feisbu.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class feisbuController implements Initializable {
    private FeisbuDAO feisbuDAO;

    @FXML
    private Text fecha;

    @FXML
    private Text genero;

    @FXML
    private ListView<Usuario> listaAmigos;

    @FXML
    private ListView<Grupo> listaGrupos;

    @FXML
    private Label nombreCompleto;

    @FXML
    private Label nombreUsuario;

    @FXML
    private ComboBox<Usuario> usuarios;

    @FXML
    void mostrarDatosAmigos(MouseEvent event) {
        Usuario usuario = listaAmigos.getSelectionModel().getSelectedItem();
        fecha.setText(usuario.getFechaRegistro().toString());
        genero.setText(String.valueOf(usuario.getGenero()));
    }

    @FXML
    void mostrarDatos(ActionEvent event) {
        Usuario usuario = usuarios.getSelectionModel().getSelectedItem();
        mostrarDatos(usuario);
    }

    void mostrarDatos(Usuario usuario) {
        usuario = usuarios.getSelectionModel().getSelectedItem();
        listaAmigos.getItems().clear();
        listaGrupos.getItems().clear();
        listaAmigos.getItems().addAll(usuario.getAmigos());
        listaGrupos.getItems().addAll(usuario.getGrupos());
        nombreUsuario.setText(usuario.getNombre());
        nombreCompleto.setText(usuario.getNombreCompleto());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        feisbuDAO = new FeisbuDAO();
        Set<Usuario> conjuntoUsuarios = feisbuDAO.getDatos();
        ObservableList<Usuario> lista = FXCollections.observableArrayList(conjuntoUsuarios);
        usuarios.setItems(lista);
        usuarios.setValue(lista.get(0));
        mostrarDatos(lista.get(0));
        

    }



}
