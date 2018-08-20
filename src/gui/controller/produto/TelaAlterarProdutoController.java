package gui.controller.produto;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.entidade.Produto;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.produto.ProdutoNaoExisteException;

public class TelaAlterarProdutoController implements Initializable {

    private Produto produto;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtValor;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Button btAlterar;

    @FXML
    protected void alterar() {

        try {
            String nome = txtNome.getText();
            double valor = Double.parseDouble(txtValor.getText());
            produto.setNome(nome);
            produto.setValor(valor);

            Fachada.getnstance().alterarProduto(produto);

            txtNome.setText("");
            txtValor.setText("");
            txtCodigo.setDisable(false);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alterar");
            alert.setHeaderText(null);
            alert.setContentText("Produto Alterado!");

            alert.showAndWait();
        } catch (ProdutoNaoExisteException ex) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alterar");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());

            alert.showAndWait();
        }

    }

    @FXML
    protected void buscarAlterar() throws ProdutoNaoExisteException {

        try {
            if (txtCodigo.getText().equals("")) {
                throw new ProdutoInvalidoException();
            }
            int codigo = Integer.parseInt(txtCodigo.getText());
            produto = Fachada.getnstance().buscarProduto(codigo);

            txtNome.setText(produto.getNome());
            txtValor.setText(produto.getValor() + "");
            txtCodigo.setDisable(true);
        } catch (ProdutoNaoExisteException |ProdutoInvalidoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alterar");
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
