package gui.controller.servico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Servico;
import negocio.execao.servico.ServicoNaoExisteException;

public class TelaAlterarServicoController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtValor;
    private Servico servico;

    @FXML
    protected void buscarAlterarServico() {
        try {
            if (!txtCodigo.getText().equals("")) {
                int codigo = Integer.parseInt(txtCodigo.getText());
                servico = Fachada.getnstance().buscarServico(codigo);
                txtNome.setText(servico.getNome());
                txtValor.setText(servico.getValor() + "");

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Buscar");
                alert.setHeaderText(null);
                alert.setContentText("Serviço não identificado!");

                alert.showAndWait();

            }
        } catch (ServicoNaoExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Buscar");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    protected void alterar() {
        try {
            if (servico != null) {

                String nome = txtNome.getText();
                double valor = Double.parseDouble(txtValor.getText());
                servico.setNome(nome);
                servico.setValor(valor);

                Fachada.getnstance().alterarServico(servico);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText("Serviço alterado!");

                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alterar");
                alert.setHeaderText(null);
                alert.setContentText("Serviço não identificado!");

                alert.showAndWait();
            }
        } catch (ServicoNaoExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alterar");
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
