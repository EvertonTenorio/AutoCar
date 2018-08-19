package gui.controller.cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteNaoExisteException;

public class TelaRemoverClienteController implements Initializable {

    @FXML
    private TextField txtCpf;
    @FXML
    private Label nome;
    @FXML
    private Label telefone;

    private Cliente cliente;

    @FXML
    private Button btBuscar;

    @FXML
    private Button btRemover;

    @FXML
    protected void buscarRemover() {
        try {
            if (!txtCpf.getText().equals("")) {
                cliente = Fachada.getnstance().buscarCliente(txtCpf.getText());
                nome.setText(cliente.getNome());
                telefone.setText(cliente.getTelefone());
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não identificado.");
            }

        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    protected void remover() {
        try {
            if (cliente != null) {
                Fachada.getnstance().removerCliente(cliente.getCpf());
                JOptionPane.showMessageDialog(null, "Cliente removido.");
                nome.setText("");
                telefone.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não identificado.");
            }

        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
