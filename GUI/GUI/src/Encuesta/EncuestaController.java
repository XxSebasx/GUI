package Encuesta;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class EncuestaController implements Initializable{

    SpinnerValueFactory<Integer> listaSpinner;

    @FXML
    private Button btaceptar;

    @FXML
    private Button btncancelar;

    @FXML
    private CheckBox checkbox;

    @FXML
    private Slider cine;

    @FXML
    private Slider compras;

    @FXML
    private ComboBox<Integer> edad;

    @FXML
    private RadioButton hombre;

    @FXML
    private ListView<Deporte> lista;

    @FXML
    private RadioButton mujer;

    @FXML
    private Spinner<Integer> nHermanos;

    @FXML
    private TextField profesion;

    @FXML
    private Slider television;

    @FXML
    void aceptar(ActionEvent event) {
        File fichero = new File("clientes.txt");
        if(!fichero.exists()){
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<String> listaUsuario = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String linea = br.readLine();
            while (linea != null) {
                listaUsuario.add(linea);
                linea = br.readLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))){
            String nombreProfesion = profesion.getText();
            int hermanos = nHermanos.getValue();
            int anios = edad.getSelectionModel().getSelectedItem();
            Deporte deporte = lista.getSelectionModel().getSelectedItem();

            char sexo = 'h';
            if(mujer.isSelected()){
                sexo = 'm';
            }

            boolean practicaDeporte = true;
            if(!checkbox.isSelected()){
                practicaDeporte = false;
            }

            Usuario usuario = new Usuario(nombreProfesion, hermanos, anios, sexo, practicaDeporte, deporte);
            usuario.aniadirGradoAficicio((int)compras.getValue());
            usuario.aniadirGradoAficicio((int)television.getValue());
            usuario.aniadirGradoAficicio((int)cine.getValue());

            listaUsuario.add(usuario.toString());
            for (String string : listaUsuario) {
                bw.write(string);
                bw.newLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void borrar(ActionEvent event) {
        profesion.setText("");
        hombre.setSelected(false);
        mujer.setSelected(false);
        checkbox.setSelected(false);
        lista.setDisable(true);
        lista.getSelectionModel().clearSelection();
        listaSpinner.setValue(1);
        edad.setValue(18);
        compras.setValue(0);
        television.setValue(0);
        cine.setValue(0);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<Deporte> listaDeporte = new LinkedList<>();
        for (Deporte deporte : Deporte.values()) {
            listaDeporte.add(deporte);
        }

        lista.getItems().addAll(listaDeporte);

        ToggleGroup tg = new ToggleGroup();
        hombre.setToggleGroup(tg);
        mujer.setToggleGroup(tg);

        ObservableList<Integer> listaEdad = FXCollections.observableArrayList();
        for (int i = 18; i <= 50; i++) {
            listaEdad.add(i);
        }
       edad.setItems(listaEdad);
       edad.setValue(18);

       listaSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
       listaSpinner.setValue(1);
       nHermanos.setValueFactory(listaSpinner);

       lista.setDisable(true);

    }

    public void activarLista(){
        if(checkbox.isSelected()){
            lista.setDisable(false);
        }else{
            lista.setDisable(true);
        }
    }



}
