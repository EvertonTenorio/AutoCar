package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class TelaPrincipalController implements Initializable {

    @FXML
    private MenuItem btLogin;

    @FXML
    private AnchorPane pane;

    @FXML
    public void abrirTelaLogin() {
        pane.getChildren().clear();
        pane.getChildren().add(getNode("/gui/view/TelaLogin.fxml"));
    }

    public Node getNode(String node) {
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (Exception e) {

        }
        return no;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
