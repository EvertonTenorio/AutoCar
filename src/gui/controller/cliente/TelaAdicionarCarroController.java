package gui.controller.cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Buscar");
                alert.setHeaderText(null);
                alert.setContentText("Cliente não encontrado!");

                alert.showAndWait();
            }

        } catch (ClienteNaoExisteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Buscar");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Adicionar");
                alert.setHeaderText(null);
                alert.setContentText("Carro adicionado!");

                alert.showAndWait();

                txtPlaca.setText("");

            }
        } catch (CarroJaExisteException | CarroInvalidoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Adicinar");
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
