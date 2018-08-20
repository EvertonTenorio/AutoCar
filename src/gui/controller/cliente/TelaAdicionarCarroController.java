package gui.controller.cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Carro;
import negocio.entidade.Cliente;
import negocio.execao.carro.CarroInvalidoException;
import negocio.execao.carro.CarroJaExisteException;
import negocio.execao.cliente.ClienteNaoExisteException;

public class TelaAdicionarCarroController implements Initializable {

    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtPlaca;
    @FXML
    private Label nome;
    @FXML
    private Cliente cliente;

    @FXML
    protected void buscar() {
        try {
            if (!txtCpf.getText().equals("")) {
                cliente = Fachada.getnstance().buscarCliente(txtCpf.getText());
                nome.setText(cliente.getNome());
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não identificado.");
            }

        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    protected void adicionarCarro() {
        String placa;
        placa = txtPlaca.getText();

        try {
            if (!txtPlaca.getText().equals("")) {
                Carro c = new Carro(placa);
                Fachada.getnstance().cadastrarCarro(placa);
                cliente.adicionarCarro(c);
                JOptionPane.showMessageDialog(null, "Carro adicioado.");
                
                txtPlaca.setText("");

            }
        }catch (CarroJaExisteException | CarroInvalidoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            
        }

        @Override
        public void initialize
        (URL url, ResourceBundle rb
        
        
    

) {
        // TODO
    }

}
