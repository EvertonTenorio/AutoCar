package gui.controller.cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteNaoExisteException;

public class TelaAlterarClienteController implements Initializable {

    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private TextField telefone;
    @FXML
    private Button btBuscar;
    @FXML
    private Button btAlterar;

    private Cliente cliente;

    @FXML
    protected void alterar() {
        try {
            if (cliente != null) {
                cliente = Fachada.getnstance().buscarCliente(cpf.getText());
                cliente.setNome(nome.getText());
                cliente.setTelefone(telefone.getText());
                Fachada.getnstance().alterarCliente(cliente);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText("Cliente alterado!");

                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText("Cliente não identificado");

                alert.showAndWait();
            }
        } catch (ClienteNaoExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alterar");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    protected void buscarAlterar() {
        try {
            if (!cpf.getText().equals("")) {
                cliente = Fachada.getnstance().buscarCliente(cpf.getText());
                nome.setText(cliente.getNome());
                telefone.setText(cliente.getTelefone());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Buscar");
                alert.setHeaderText(null);
                alert.setContentText("Cliente não identificado!");

                alert.showAndWait();;
            }

        } catch (ClienteNaoExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Buscar");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
