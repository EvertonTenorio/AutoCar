package gui.controller.cliente;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Carro;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteNaoExisteException;

public class TelaBuscarClienteController implements Initializable {

    @FXML
    private TextField txtCpf;
    @FXML
    private Label nome;
    @FXML
    private Label telefone;
    @FXML
    private Button btBuscar;
    @FXML
    private ListView carros;
    
    private Cliente cliente;
    @FXML
    private Label frequencia;
    @FXML
    private ListView<Carro> listaCarros = new ListView<>();

    @FXML
    protected void buscar() {
        try {
            if (!txtCpf.getText().equals("")) {
                cliente = Fachada.getnstance().buscarCliente(txtCpf.getText());
                nome.setText(cliente.getNome());
                telefone.setText(cliente.getTelefone());
                frequencia.setText(String.valueOf(cliente.getFrequencia()));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não identificado.");
            }

        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    protected void listarCarros(){
        ArrayList<Carro> carros = cliente.getCarros();

        ObservableList<Carro> listaDeCarros = FXCollections.observableArrayList(carros);
        listaCarros.setItems(listaDeCarros);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
