package libreria.controller;

import java.util.HashSet;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import libreria.dao.LibreriaDao;
import libreria.model.Autor;
import libreria.model.Publicacion;

public class LibreriaController {
    private LibreriaDao libreriaDao;

    @FXML
    private Button btnbuscar;

    @FXML
    private Button btnlistar;

    @FXML
    private Button btnregistrar;

    @FXML
    private TextField buscador;

    @FXML
    private ListView<Publicacion> listaLibros;

    @FXML
    private TextArea listaAutores;


    @FXML
    private ComboBox<String> menuMateira;

    @FXML
    void buscar(ActionEvent event) {
        listaLibros.getItems().clear();
        String palabrasClave = buscador.getText().toLowerCase();
        for (Publicacion publicacion : libreriaDao.getPublicaciones()) {
            String titulo = publicacion.getTitulo().toLowerCase();
            if(titulo.contains(palabrasClave)){
                listaLibros.getItems().add(publicacion);
            }
        }
    }

    @FXML
    void listar(ActionEvent event) {
        Set<String> categorias = new HashSet<>();
        Set<Publicacion> publicaciones = libreriaDao.getPublicaciones();
        for (Publicacion publicacion : publicaciones) {
            categorias.add(publicacion.getCategoria());
        }
        ObservableList<String> lista = FXCollections.observableArrayList(categorias);
        menuMateira.setItems(lista);
        menuMateira.setValue(lista.get(0));
        listaLibros.getItems().addAll(publicaciones);
        mostrarAutor(lista.get(0));
    }

    public void mostrarAutor(String categoria){
        Set<Autor> autors = new HashSet<>();
        for (Publicacion publicacion : libreriaDao.getPublicaciones()) {
            for (Autor autor : publicacion.getAutores()) {
                if(autor.getMateria().equals(categoria)){
                    autors.add(autor);
                }
            }
        }
        
        String cadenaCompleta = "";
        for (Autor autor : autors) {
            cadenaCompleta += autor.getNombre() + "\n";
            for (Publicacion publicacion : autor.getPublicaciones()) {
                cadenaCompleta +=  "    " + publicacion.getTitulo() + "\n";
            }
        }

        listaAutores.setText(cadenaCompleta);
    }

    @FXML
    void mostrarAutores(ActionEvent event) {
        String materia = menuMateira.getSelectionModel().getSelectedItem();
        mostrarAutor(materia);
    }

    @FXML
    void registrar(ActionEvent event) {
        libreriaDao = new LibreriaDao();
        btnregistrar.setDisable(true);
    }

}
