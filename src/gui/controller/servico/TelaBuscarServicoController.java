package gui.controller.servico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Servico;
import negocio.execao.servico.ServicoNaoExisteException;

public class TelaBuscarServicoController implements Initializable {

    @FXML
    private TextField txtCodigo;
    @FXML
    private Label nome;
    @FXML
    private Label valor;
    private Servico servico;

    @FXML
    protected void buscarServico() {
        try {
            if (!txtCodigo.getText().equals("")) {
                int codigo = Integer.parseInt(txtCodigo.getText());
                servico = Fachada.getnstance().buscarServico(codigo);
                nome.setText(servico.getNome());
                valor.setText(servico.getValor() + "");

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Buscar");
                alert.setHeaderText(null);
                alert.setContentText("Serviço não identificado");

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
