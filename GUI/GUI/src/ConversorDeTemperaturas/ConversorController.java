package ConversorDeTemperaturas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ConversorController {

    @FXML
    private TextField Celsius;

    @FXML
    private TextField Farenheit;

    @FXML
    void PasarFarenheit(KeyEvent event) {
        double F = (1.8*Double.parseDouble(Celsius.getText()))+32;
        Farenheit.setText(String.format("%.1f", F));
    }

}
