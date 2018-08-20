package gui.controller.servico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.entidade.Servico;
import negocio.execao.servico.ServicoInvalidoException;
import negocio.execao.servico.ServicoNaoExisteException;

public class TelaRemoverServicoController implements Initializable {

    @FXML
    private TextField txtCodigo;
    @FXML
    private Label nome;
    @FXML
    private Label valor;
    private Servico servico;

    @FXML
    protected void buscarRemoverServico() {

        try {
            if (txtCodigo.getText().equals("")) {
                throw new ServicoInvalidoException();
            } else {
                int codigo = Integer.parseInt(txtCodigo.getText());
                servico = Fachada.getnstance().buscarServico(codigo);

                nome.setText(servico.getNome());
                valor.setText(servico.getValor() + "");

            }
        } catch (ServicoNaoExisteException | ServicoInvalidoException ex) {
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
            if (servico != null) {
                Fachada.getnstance().removerServico(servico.getCodigo());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Remover");
                alert.setHeaderText(null);
                alert.setContentText("Serviço Removido!");
                nome.setText("");
                valor.setText("");

                alert.showAndWait();

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Remover");
                alert.setHeaderText(null);
                alert.setContentText("Serviço não encontrado");

                alert.showAndWait();
            }
        } catch (ServicoNaoExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Remover");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
