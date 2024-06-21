package Calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController {

    @FXML
    private Button botonLimpiar;

    @FXML
    private Button division;

    @FXML
    private Button multiplicacion;

    @FXML
    private Button porcentaje;

    @FXML
    private TextField primerNumero;

    @FXML
    private Button resta;

    @FXML
    private TextField resulltado;

    @FXML
    private TextField segundoNumero;

    @FXML
    private Button suma;

    @FXML
    void CalcularPorcentaje(ActionEvent event) {

    }

    @FXML
    void Limpiar(ActionEvent event) {
       primerNumero.setText(null);
       segundoNumero.setText(null);
       resulltado.setText(null);
    }

    @FXML
    void dividir(ActionEvent event) {
        double divisionionResultado = Double.parseDouble(primerNumero.getText()) / Double.parseDouble(segundoNumero.getText());
        resulltado.setText(String.valueOf(divisionionResultado));
        
    }

    @FXML
    void multiplicar(ActionEvent event) {
        double multiplicacionResultado = Double.parseDouble(primerNumero.getText()) * Double.parseDouble(segundoNumero.getText());
        resulltado.setText(String.valueOf(multiplicacionResultado));
    }

    @FXML
    void restar(ActionEvent event) {
        double restaResultado = Double.parseDouble(primerNumero.getText()) - Double.parseDouble(segundoNumero.getText());
        resulltado.setText(String.valueOf(restaResultado));
    }

    @FXML
    void sumar(ActionEvent event) {
        double sumaResultado = Double.parseDouble(primerNumero.getText()) + Double.parseDouble(segundoNumero.getText());
        resulltado.setText(String.valueOf(sumaResultado));
    }

}
