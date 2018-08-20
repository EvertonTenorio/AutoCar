package gui.controller.venda;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Cliente;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.entidade.Venda;
import negocio.execao.cliente.ClienteNaoExisteException;

public class TelaVendaController implements Initializable {

    @FXML
    private TableColumn codigo;
    @FXML
    private TableColumn nome;
    @FXML
    private TableColumn valor;
    @FXML
    private ComboBox<Produto> produtos = new ComboBox<>();
    @FXML
    private ComboBox<Servico> servicos = new ComboBox<>();
    private Venda venda;
    @FXML
    private Label labelNome;
    @FXML
    private TextField txtCpf;
    private Cliente cliente;
    private Produto produto;
    @FXML
    private ListView<Produto> lista = new ListView<>();
    @FXML
    protected void preencherProdutos() {

        ObservableList<Produto> listaProdutos = FXCollections.observableArrayList(((ArrayList) Fachada.getnstance().listarprodutos()));
        produtos.setItems(listaProdutos);

        ObservableList<Servico> listaServicos = FXCollections.observableArrayList(((ArrayList) Fachada.getnstance().listarServicos()));
        servicos.setItems(listaServicos);
    }

    @FXML
    protected void buscar() {
        try {
            if (!txtCpf.getText().equals("")) {
                cliente = Fachada.getnstance().buscarCliente(txtCpf.getText());
                labelNome.setText(cliente.getNome());

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não identificado.");
            }

        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    protected void adicionarProduto(){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
