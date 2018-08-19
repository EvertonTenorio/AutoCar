package gui.controller.cliente;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import negocio.Fachada;
import negocio.entidade.Cliente;

public class TelaListarClienteController implements Initializable {

    @FXML
    private ListView<Cliente> lista = new ListView<>();

    @FXML
    protected void listarClientes() {
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) Fachada.getnstance().listarClientes();

        ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(clientes);
        lista.setItems(listaClientes);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
