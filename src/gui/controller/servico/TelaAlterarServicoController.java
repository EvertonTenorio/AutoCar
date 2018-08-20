package gui.controller.servico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
                JOptionPane.showMessageDialog(null, "Serviço não identificado.");

            }
        } catch (ServicoNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
                JOptionPane.showMessageDialog(null, "Serviço alterado.");
            } else {
                JOptionPane.showMessageDialog(null, "Serviço não identificado.");
            }
        } catch (ServicoNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
