package Login;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

public class LoginController implements Initializable {

    final String CONTRASENIA = "1";
    String usuario = "";

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

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
    private Text texto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        List <String> listaNumeros = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            listaNumeros.add(String.valueOf(i));
        }

        Collections.shuffle(listaNumeros);

        btn0.setText(listaNumeros.get(0));
        btn1.setText(listaNumeros.get(1));
        btn2.setText(listaNumeros.get(2));
        btn3.setText(listaNumeros.get(3));
        btn4.setText(listaNumeros.get(4));
        btn5.setText(listaNumeros.get(5));
        btn6.setText(listaNumeros.get(6));
        btn7.setText(listaNumeros.get(7));
        btn8.setText(listaNumeros.get(8));
        btn9.setText(listaNumeros.get(9));
    }

    @FXML
    void limpiar(ActionEvent event) {
        usuario = "";
        btnContrasenia.setText(usuario);
    }

    @FXML
    void pulsarbtn0(ActionEvent event) {
        guardarClave(btn0);
    }

    @FXML
    void pulsarbtn1(ActionEvent event) {
        guardarClave(btn1);
    }

    @FXML
    void pulsarbtn2(ActionEvent event) {
        guardarClave(btn2);
    }

    @FXML
    void pulsarbtn3(ActionEvent event) {
        guardarClave(btn3);
    }

    @FXML
    void pulsarbtn4(ActionEvent event) {
        guardarClave(btn4);
    }

    @FXML
    void pulsarbtn5(ActionEvent event) {
        guardarClave(btn5);
    }

    @FXML
    void pulsarbtn6(ActionEvent event) {
        guardarClave(btn6);
    }

    @FXML
    void pulsarbtn7(ActionEvent event) {
        guardarClave(btn7);
    }

    @FXML
    void pulsarbtn8(ActionEvent event) {
        guardarClave(btn8);
    }

    @FXML
    void pulsarbtn9(ActionEvent event) {
        guardarClave(btn9);
    }

    @FXML
    void startApp(ActionEvent event) {
        if(usuario.equals(CONTRASENIA)){
            texto.setText("CORRECTO HAS ENTRADO!");
        }else{
            texto.setText("CONTRASEÑA INCORRECTA :(");
        }
    }

    public void guardarClave(Button btn){
        usuario += btn.getText();
        String aux = btnContrasenia.getText()+"*";
        btnContrasenia.setText(aux);
    }
}
