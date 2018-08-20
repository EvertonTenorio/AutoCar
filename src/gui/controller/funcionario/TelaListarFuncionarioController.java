package gui.controller.funcionario;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import negocio.Fachada;
import negocio.entidade.Funcionario;

public class TelaListarFuncionarioController implements Initializable {
    @FXML
    private ListView<Funcionario> listaFunc = new ListView<>();
    
    @FXML
    protected void listarFuncionarios(){
        ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) Fachada.getnstance().listarFuncionarios();
        ObservableList<Funcionario> lista = FXCollections.observableArrayList(funcionarios);
        listaFunc.setItems(lista);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
