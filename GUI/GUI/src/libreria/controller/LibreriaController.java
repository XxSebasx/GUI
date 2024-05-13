package libreria.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import libreria.dao.LibreriaDAO;
import libreria.model.Libro;

public class LibreriaController {
    private LibreriaDAO libreriaDAO;

    @FXML
    private ComboBox<?> OpcionesBusqueda;

    @FXML
    private TextField autor;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnaniadir;

    @FXML
    private Button btneliminar;

    @FXML
    private TextField buscador;

    @FXML
    private TextField cantidad;

    @FXML
    private TextField id;

    @FXML
    private TextField libreSeleccionado;

    @FXML
    private ListView<?> lista;

    @FXML
    private TextField nuevoPrecio;

    @FXML
    private TextField precio;

    @FXML
    private TextField titulo;

    @FXML
    void aniadirLIbro(MouseEvent event) {
        int idNuevo = Integer.parseInt(id.getText());
        String tituloNuevo = titulo.getText();
        String autorNuevo = autor.getText();
        double precioNuevo = Double.parseDouble(precio.getText());
        int cantidadNuevo = Integer.parseInt(cantidad.getText());
        Libro libroNuevo = new Libro(idNuevo, tituloNuevo, autorNuevo, precioNuevo, cantidadNuevo);
        libreriaDAO.
    }

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void eliminar(MouseEvent event) {
    }

    @FXML
    void limpiar(MouseEvent event) {

    }

    @FXML
    void modificar(MouseEvent event) {

    }

}
