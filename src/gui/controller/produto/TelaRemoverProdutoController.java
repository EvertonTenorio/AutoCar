package gui.controller.produto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.entidade.Produto;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.produto.ProdutoNaoExisteException;

public class TelaRemoverProdutoController implements Initializable {

    private Produto produto;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Button btBuscar;
    @FXML
    private Label nome;
    @FXML
    private Label valor;

    @FXML
    protected void buscarRemover() {

        try {
            if (txtCodigo.getText().equals("")) {
                throw new ProdutoInvalidoException();
            }
            int codigo = Integer.parseInt(txtCodigo.getText());
            produto = Fachada.getnstance().buscarProduto(codigo);

            nome.setText(produto.getNome());
            valor.setText(produto.getValor() + "");

        } catch (ProdutoNaoExisteException|ProdutoInvalidoException ex) {
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
            Fachada.getnstance().removerProduto(produto.getCodigo());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Remover");
            alert.setHeaderText(null);
            alert.setContentText("Produto Removido!");

            alert.showAndWait();

        } catch (ProdutoNaoExisteException ex) {
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
