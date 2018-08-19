package gui.controller.produto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.produto.ProdutoJaExisteException;

public class TelaCadastrarProdutoController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtValor;
    @FXML
    private Button btCadastrar;

    @FXML
    protected void cadastrar() {
        String nome = txtNome.getText();
        double valor = Double.parseDouble(txtValor.getText());

        try {
            Fachada.getnstance().cadastrarProduto(nome, valor);

            txtNome.setText("");
            txtValor.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro");
            alert.setHeaderText(null);
            alert.setContentText("Produto Cadastrado!");

            alert.showAndWait();
        } catch (ProdutoInvalidoException | ProdutoJaExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cadastro");
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
