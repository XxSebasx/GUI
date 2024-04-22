package Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class LoginController {
    final String CONTRASENIA = "12345";
    String usuario = null;

    @FXML
    private Button btn1;

    @FXML
    private Button btn10;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private TextField btnContrasenia;

    @FXML
    private Button btnEnter;

    @FXML
    private Button btnLimpiar;

    @FXML
    void startApp(ActionEvent event) {
        
    }

    @FXML
    void limpiar(ActionEvent event) {
        btnContrasenia.setText(null);
    }

    @FXML
    void pulsar(ActionEvent event) {
        String cadena = btnContrasenia.getText() + "*";
        btnContrasenia.setText(cadena);

    }

}
