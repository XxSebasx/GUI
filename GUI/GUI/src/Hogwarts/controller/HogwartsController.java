package Hogwarts.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import Hogwarts.dao.HogwartsDAO;
import Hogwarts.model.Casa;
import Hogwarts.model.Estudiante;
import Hogwarts.model.Rango;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class HogwartsController implements Initializable{
    private HogwartsDAO hogwartsDAO;

    @FXML
    private Button btactualizar;

    @FXML
    private ListView<Estudiante> listaGriffindor;

    @FXML
    private ListView<Estudiante> listaHufflepuff;

    @FXML
    private ListView<Estudiante> listaRavenclaw;

    @FXML
    private ListView<Estudiante> listaSlytherin;

    @FXML
    private RadioButton mago;

    @FXML
    private RadioButton muggle;

    @FXML
    private TextField nombre;

    @FXML
    private Slider slider;



    @FXML
    void mostrarEstudianteGryffindor(MouseEvent event) {
        nombre.setText(listaGriffindor.getSelectionModel().getSelectedItem().getNombre());;
    }

    @FXML
    void mostrarEstudianteHufflepuff(MouseEvent event) {
        nombre.setText(listaHufflepuff.getSelectionModel().getSelectedItem().getNombre());;
    }

    @FXML
    void mostrarEstudianteRavenclaw(MouseEvent event) {
        nombre.setText(listaRavenclaw.getSelectionModel().getSelectedItem().getNombre());;
    }

    @FXML
    void mostrarEstudianteSlytherin(MouseEvent event) {
        nombre.setText(listaSlytherin.getSelectionModel().getSelectedItem().getNombre());
    }

    @FXML
    void actualizar(MouseEvent event) {
        Set<Casa> casitas = hogwartsDAO.getCasas();
        for (Casa casa : casitas) {
            Set<Estudiante> estudiantesCasa = casa.getEstudiantes();
            for (Estudiante estudiante : estudiantesCasa) {
                if(estudiante.getNombre().equals(nombre.getText())){
                    int nuevaEdad = (int) slider.getValue();
                    estudiante.setEdad(nuevaEdad);
                    if(mago.isSelected()){
                        estudiante.setRango(Rango.MAGO);
                    }else{
                        estudiante.setRango(Rango.MUGGLE);
                    }
                    System.out.println(estudiante.getEdad());
                    
                }
            }
        }

        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup tg = new ToggleGroup();
        mago.setToggleGroup(tg);
        muggle.setToggleGroup(tg);
        hogwartsDAO = new HogwartsDAO();
        Set<Casa> casitas = hogwartsDAO.getCasas();
        for (Casa casa : casitas) {
            String nombreCasa = casa.getNombre();
            Set<Estudiante> estudiantesCasa = casa.getEstudiantes();
            if(nombreCasa.equals("Gryffindor")){
                listaGriffindor.getItems().addAll(estudiantesCasa);
            }else if (nombreCasa.equals("Slytherin")) {
                listaSlytherin.getItems().addAll(estudiantesCasa);
            }else if(nombreCasa.equals("Ravenclaw")){
                listaRavenclaw.getItems().addAll(estudiantesCasa);
            }else{
                listaHufflepuff.getItems().addAll(estudiantesCasa);
            }
        }
    }

}
