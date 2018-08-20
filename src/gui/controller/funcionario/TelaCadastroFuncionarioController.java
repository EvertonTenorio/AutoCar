package gui.controller.funcionario;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.execao.funcionario.FuncionarioJaExisteException;
import negocio.execao.pessoa.PessoaInvalidaException;

public class TelaCadastroFuncionarioController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtSalario;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtSenha;
    @FXML
    private Label loginLabel;
    @FXML
    private Label senhaLabel;
    @FXML
    private ComboBox<String> cargos = new ComboBox<>();
    private boolean gerente = false;

    @FXML
    protected void cadastrar() {
        String nome, senha, login, cpf, telefone;
        double salario;

        nome = txtNome.getText();
        login = txtLogin.getText();
        senha = txtSenha.getText();

        try {
            salario = Double.parseDouble(txtSalario.getText());
            cpf = txtCpf.getText();
            telefone = txtTelefone.getText();

            if (gerente == true) {
                Fachada.getnstance().cadastrarGerente(nome, cpf, telefone, salario, login, senha);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastrar");
                alert.setHeaderText(null);
                alert.setContentText("Gerente Cadastrado!");

                alert.showAndWait();
            } else {
                Fachada.getnstance().cadastrarFuncionario(nome, cpf, telefone, salario);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastrar");
                alert.setHeaderText(null);
                alert.setContentText("Funcionário Cadastrado!");

                alert.showAndWait();
            }

            txtCpf.setText("");
            txtLogin.setText("");
            txtNome.setText("");
            txtSalario.setText("");
            txtSenha.setText("");
            txtTelefone.setText("");

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cadastrar");
            alert.setHeaderText(null);
            alert.setContentText("Digite apenas números nos campos: Cpf, Telefone e Salario");

            alert.showAndWait();
        } catch (FuncionarioJaExisteException | PessoaInvalidaException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cadastrar");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    protected void preencherComboBox() {
        ArrayList<String> listaCargos = new ArrayList<>();
        listaCargos.add("Funcionário");
        listaCargos.add("Mecânico");
        listaCargos.add("Gerente");

        ObservableList<String> lista = FXCollections.observableArrayList(listaCargos);
        cargos.setItems(lista);
    }

    @FXML
    protected void habilitarCampos() {
        String cargo = cargos.valueProperty().get();

        if (cargo.equals("Gerente")) {

            loginLabel.setVisible(true);
            senhaLabel.setVisible(true);
            txtLogin.setVisible(true);
            txtSenha.setVisible(true);
            gerente = true;
        } else {
            loginLabel.setVisible(false);
            senhaLabel.setVisible(false);
            txtLogin.setVisible(false);
            txtSenha.setVisible(false);
            gerente = false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
