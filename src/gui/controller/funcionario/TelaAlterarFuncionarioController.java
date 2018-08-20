package gui.controller.funcionario;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.entidade.Funcionario;
import negocio.entidade.Gerente;
import negocio.execao.funcionario.FuncionarioNaoExisteException;

public class TelaAlterarFuncionarioController implements Initializable {

    private Funcionario funcionario;
    private Gerente gerente;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtSalario;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtSenha;
    @FXML
    private Label senha;
    @FXML
    private Label login;
    private boolean isGerente = false;

    @FXML
    protected void buscarAlterar() {

        try {
            String cpf = txtCpf.getText();
            funcionario = Fachada.getnstance().buscarFuncionario(cpf);

            if (funcionario instanceof Gerente) {
                gerente = (Gerente) funcionario;
                login.setVisible(true);
                senha.setVisible(true);
                txtLogin.setVisible(true);
                txtSenha.setVisible(true);
                txtLogin.setText(gerente.getLogin());
                txtSenha.setText(gerente.getSenha());
                isGerente = true;
            }

            txtCpf.setDisable(true);

            txtNome.setText(funcionario.getNome());
            txtTelefone.setText(funcionario.getTelefone());
            txtSalario.setText(funcionario.getSalario() + "");

        } catch (FuncionarioNaoExisteException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alterar");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    protected void alterar() {
        if (isGerente) {
            gerente.setNome(txtNome.getText());
            gerente.setTelefone(txtTelefone.getText());
            gerente.setSalario(Double.parseDouble(txtSalario.getText()));
            gerente.setLogin(txtLogin.getText());
            gerente.setSenha(txtSenha.getText());

            try {
                Fachada.getnstance().alterarFuncionario(gerente);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText("Funcionario Alterado");

                alert.showAndWait();
            } catch (FuncionarioNaoExisteException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());

                alert.showAndWait();
            }
        } else {
            funcionario.setNome(txtNome.getText());
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setSalario(Double.parseDouble(txtSalario.getText()));

            try {
                Fachada.getnstance().alterarFuncionario(funcionario);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText("Funcionario Alterado");

                alert.showAndWait();
            } catch (FuncionarioNaoExisteException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());

                alert.showAndWait();
            }
        }
        txtNome.setText("");
        txtTelefone.setText("");
        txtSalario.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
