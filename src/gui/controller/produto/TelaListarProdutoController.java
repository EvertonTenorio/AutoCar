package gui.controller.produto;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import negocio.Fachada;
import negocio.entidade.Produto;

public class TelaListarProdutoController implements Initializable {
    @FXML
    private ListView<Produto> produtos = new ListView<>();
    
    @FXML
    protected void listar(){
        ArrayList<Produto> listaProd = (ArrayList<Produto>) Fachada.getnstance().listarprodutos();
        ObservableList<Produto> lista = FXCollections.observableArrayList(listaProd);
        produtos.setItems(lista);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
