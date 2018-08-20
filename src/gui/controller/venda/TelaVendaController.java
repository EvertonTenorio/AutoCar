package gui.controller.venda;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.Fachada;
import negocio.entidade.Carro;
import negocio.entidade.Cliente;
import negocio.entidade.Mecanico;
import negocio.entidade.Pessoa;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.entidade.ServicoPeriodico;
import negocio.entidade.Venda;
import negocio.execao.cliente.ClienteNaoExisteException;
import negocio.execao.venda.VendaInvalidaException;
import negocio.execao.venda.VendaJaExisteException;

public class TelaVendaController implements Initializable {

    @FXML
    private ComboBox<Produto> produtos = new ComboBox<>();
    @FXML
    private ComboBox<Servico> servicos = new ComboBox<>();
    @FXML
    private ComboBox<Mecanico> mecanicos = new ComboBox<>();
    @FXML
    private ComboBox<Carro> carros = new ComboBox<>();
    private Venda venda = null;
    private Carro carro;
    private Servico servico;
    @FXML
    private Label labelNome;
    @FXML
    private Label mecanico;
    @FXML
    private Label kmAtual;
    @FXML
    private Label kmProx;
    @FXML
    private TextField txtkmAtual;
    @FXML
    private TextField txtkmProx;
    @FXML
    private TextField txtCpf;
    private Pessoa cliente;
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
                venda = new Venda(cliente);

                ObservableList<Carro> listaCarros = FXCollections.observableArrayList(((ArrayList) cliente.getCarros()));
                carros.setItems(listaCarros);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login");
                alert.setHeaderText(null);
                alert.setContentText("Cliente não identificado");

                alert.showAndWait();
            }

        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    protected void adicionarProduto() {
        produto = produtos.getValue();
        venda.adicionarProduto(produto);
        listar();
    }

    private void preencherMecanicos() {
        ObservableList<Mecanico> listaMecanicos = FXCollections.observableArrayList((ArrayList) Fachada.getnstance().listarMecanicos());
        mecanicos.setItems(listaMecanicos);
    }

    @FXML
    protected void listar() {
        ArrayList<Produto> listaProd = (ArrayList<Produto>) venda.getProdutos();
        ObservableList<Produto> lista = FXCollections.observableArrayList(listaProd);
        produtos.setItems(lista);
    }

    @FXML
    protected void selecionarServico() {
        servico = servicos.getValue();

        if (servico instanceof ServicoPeriodico) {
            kmAtual.setVisible(true);
            kmProx.setVisible(true);
            txtkmAtual.setVisible(true);
            txtkmProx.setVisible(true);
        }
        mecanicos.setVisible(true);
        mecanico.setVisible(true);
        preencherMecanicos();
    }

    @FXML
    protected void adicionarServico() {
        ServicoPeriodico s;
        if (servico instanceof ServicoPeriodico) {
            s = (ServicoPeriodico) servico;
            try {
                int km1 = Integer.parseInt(txtkmAtual.getText());
                int km2 = Integer.parseInt(txtkmProx.getText());
                s.setKmAtual(km1);
                s.setKmProximoServico(km2);
                if (mecanicos.getValue() != null) {
                    s.setMecanico(mecanicos.getValue());
                    venda.adicionarServico(servico, cliente.getCarros().get(0).getPlaca(), mecanicos.getValue());
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Venda");
                    alert.setHeaderText(null);
                    alert.setContentText("Selecione o mecanico!");

                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {

            }
        }

        servico.setMecanico(mecanicos.getValue());

        venda.adicionarServico(servico, cliente.getCarros().get(0).getPlaca(), mecanicos.getValue());

        listar();
    }

    @FXML
    protected void finalizar() {
        if (venda != null) {
            try {
                Fachada.getnstance().cadastrarVenda(venda);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Venda");
                alert.setHeaderText(null);
                alert.setContentText("Total: " + venda.getValorTotal());

                alert.showAndWait();
            } catch (VendaInvalidaException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Venda");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());

                alert.showAndWait();
            } catch (VendaJaExisteException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Venda");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());

                alert.showAndWait();
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
