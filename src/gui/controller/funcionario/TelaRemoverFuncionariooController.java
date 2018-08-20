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
import negocio.execao.funcionario.FuncionarioNaoExisteException;

public class TelaRemoverFuncionariooController implements Initializable {

    private Funcionario funcionario;
    @FXML
    private TextField txtCpf;
    @FXML
    private Label nome;
    @FXML
    private Label salario;
    @FXML
    private Label telefone;

    @FXML
    protected void buscarRemover() {
        try {
            String cpf = txtCpf.getText();

            funcionario = Fachada.getnstance().buscarFuncionario(cpf);

            nome.setText(funcionario.getNome());
            telefone.setText(funcionario.getTelefone());
            salario.setText(funcionario.getSalario() + "");

        } catch (FuncionarioNaoExisteException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Remover");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void remover() {

        try {
            Fachada.getnstance().removerFuncionario(funcionario.getCpf());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Remover");
            alert.setHeaderText(null);
            alert.setContentText("Funcionário removido!");

            alert.showAndWait();
        } catch (FuncionarioNaoExisteException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Remover");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
