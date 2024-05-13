
package AparcaBicicletas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import AparcaBicicletas.dao.AparcabicicletasDAO;
import AparcaBicicletas.model.AparcaBicicleta;
import AparcaBicicletas.model.Barrio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class AparcabicicletasController implements Initializable {
    private AparcabicicletasDAO aparcabicicletasDAO;

    @FXML
    private ListView<AparcaBicicleta> lista;

    @FXML
    private ComboBox<Barrio> menuBarrio;

    @FXML
    void mostrarBarrio(ActionEvent event) {
        lista.getItems().clear();
        Set<AparcaBicicleta> conjuntoAparcabcis = menuBarrio.getSelectionModel().getSelectedItem()
                .getAparcaBicicletas();

        lista.getItems().addAll(conjuntoAparcabcis);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        aparcabicicletasDAO = new AparcabicicletasDAO();
        Set<Barrio> conjuntoBarrio = aparcabicicletasDAO.getBarrios();
        ObservableList<Barrio> list = FXCollections.observableArrayList(conjuntoBarrio);
        menuBarrio.setItems(list);
        menuBarrio.setValue(list.get(0));
    }

}
