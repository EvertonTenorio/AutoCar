package gui.controller.cliente;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Carro;
import negocio.entidade.Cliente;
import negocio.execao.carro.CarroNaoExisteException;
import negocio.execao.cliente.ClienteNaoExisteException;

public class TelaRemoverCarroController implements Initializable {

    @FXML
    private TextField txtCpf;
    @FXML
    private Label nome;
    private Cliente cliente;
    @FXML
    private ComboBox<Carro> carros = new ComboBox<>();
    private Carro carro;

    @FXML
    protected void buscarRemoverCliente() {
        try {
            if (!txtCpf.getText().equals("")) {
                cliente = Fachada.getnstance().buscarCliente(txtCpf.getText());
                nome.setText(cliente.getNome());
                ObservableList<Carro> listaCarros = FXCollections.observableArrayList(cliente.getCarros());
                carros.setItems(listaCarros);

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Buscar");
                alert.setHeaderText(null);
                alert.setContentText("Cliente não identificado");

                alert.showAndWait();
            }

        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    protected void removerCarro() {
        Carro c = carros.getValue();

        cliente.removerCarro(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Remover");
        alert.setHeaderText(null);
        alert.setContentText("Carro removido!");

        alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
