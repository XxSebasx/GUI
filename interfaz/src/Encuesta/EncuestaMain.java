package Encuesta;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EncuestaMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Encuesta.fxml"));
        primaryStage.setTitle("Mi counter app");
        primaryStage.setScene(new Scene(root, 446, 510));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}