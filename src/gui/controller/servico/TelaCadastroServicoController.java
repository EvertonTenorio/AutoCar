package gui.controller.servico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
                JOptionPane.showMessageDialog(null, "Serviço cadastrado.");
                txtNome.setText("");
                txtValor.setText("");
            } else {
                Fachada.getnstance().cadastrarServico(valor, nome);
                JOptionPane.showMessageDialog(null, "Serviço cadastrado.");
                txtNome.setText("");
                txtValor.setText("");
            }
        } catch (ProdutoInvalidoException | ServicoInvalidoException | ServicoJaExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
