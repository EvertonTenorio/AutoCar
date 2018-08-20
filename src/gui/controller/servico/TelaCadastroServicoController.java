package gui.controller.servico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.servico.ServicoInvalidoException;
import negocio.execao.servico.ServicoJaExisteException;

public class TelaCadastroServicoController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtValor;
    @FXML
    private CheckBox checkServico;

    @FXML
    protected void cadastrar() {
        String nome;
        double valor;
        nome = txtNome.getText();
        valor = Double.parseDouble(txtValor.getText());

        try {
            if (checkServico.isSelected()) {
                Fachada.getnstance().cadastrarServicoPeriodico(valor, nome);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText(null);
                alert.setContentText("Serviço cadastrado!");

                alert.showAndWait();
                txtNome.setText("");
                txtValor.setText("");
            } else {
                Fachada.getnstance().cadastrarServico(valor, nome);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastrar!");
                alert.setHeaderText(null);
                alert.setContentText("Serviço cadastrado!");

                alert.showAndWait();
                txtNome.setText("");
                txtValor.setText("");
            }
        } catch (ProdutoInvalidoException | ServicoInvalidoException | ServicoJaExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cadastrar");
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
