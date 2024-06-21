package bitacoras.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import bitacoras.dao.ArchivoException;
import bitacoras.dao.BitacorasDAO;
import bitacoras.model.Bitacora;
import bitacoras.model.BitacoraInteligente;
import bitacoras.model.Categoria;
import bitacoras.model.Entrada;
import bitacoras.model.OrdenFechaEntrada;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BitacorasController{
    private BitacorasDAO bitacorasDAO;
    private Set<Entrada> entradas;
    private Set<Bitacora> bitacoras;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCargarDatos;

    @FXML
    private TextField cadena;

    @FXML
    private ComboBox<Categoria> categorias;

    @FXML
    private ListView<Bitacora> listaBitacoras;

    @FXML
    private ListView<Entrada> listaEntradas;

    @FXML
    private ListView<String> listaSpam;

    @FXML
    private TextField nombreFichero;

    @FXML
    private Label textEstado;

    @FXML
    private Label textoPorcentaje;

    @FXML
    void buscar(MouseEvent event) {
        listaEntradas.getItems().clear();
        Bitacora bitacora = listaBitacoras.getSelectionModel().getSelectedItem();
        Categoria categoriaSeleccionada = categorias.getSelectionModel().getSelectedItem();
        listaEntradas.getItems().addAll(bitacora.buscarPor(cadena.getText(), categoriaSeleccionada));
    }

    @FXML
    void cargarDatos(MouseEvent event) {
        try {
            bitacorasDAO = new BitacorasDAO(nombreFichero.getText());
            listaBitacoras.getItems().addAll(bitacorasDAO.getBitacoras());
            textEstado.setText(textEstado.getText() + "La carga exitosa");
            nombreFichero.setDisable(true);
            btnCargarDatos.setDisable(true);
            categorias.getItems().addAll(Categoria.values());
        } catch (ArchivoException e) {
            textEstado.setText(e.getMessage());
        }
    }

    @FXML
    void mostrarSeleccion(MouseEvent event) {
        Bitacora bitacora = listaBitacoras.getSelectionModel().getSelectedItem();
        listaEntradas.getItems().clear();
        entradas = bitacora.getEntradas();
        listaEntradas.getItems().addAll(entradas);
        listaSpam.getItems().clear();
        if(bitacora instanceof BitacoraInteligente){
            BitacoraInteligente bitacoraInteligente = (BitacoraInteligente) bitacora;
            listaSpam.getItems().addAll(bitacoraInteligente.getSpam());
            textoPorcentaje.setText(String.valueOf(bitacoraInteligente.getSpam().size() * (entradas.size()/100)) + "%");
        }

        



    }



}
