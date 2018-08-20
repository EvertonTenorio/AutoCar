package gui.controller.cliente;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Carro;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteInvalidoException;
import negocio.execao.cliente.ClienteJaExisteException;
import negocio.execao.pessoa.PessoaInvalidaException;

public class TelaCadastroClienteController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtTelefone;
    @FXML
    private Button cadastrar;
    

    @FXML
    protected void cadastrar() {
        String nome, cpf, telefone;
        nome = txtNome.getText();
        cpf = txtCpf.getText();
        telefone = txtTelefone.getText();

        try {
            Fachada.getnstance().cadastrarCliente(nome, cpf, telefone);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado.");
            txtNome.setText("");
            txtCpf.setText("");
            txtTelefone.setText("");
        } catch (PessoaInvalidaException | ClienteJaExisteException he) {
            JOptionPane.showMessageDialog(null, he.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
