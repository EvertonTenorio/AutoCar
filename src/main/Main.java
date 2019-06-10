package main;

import conection.ConectionFactory;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.entidade.Cliente;
import negocio.entidade.Funcionario;
import negocio.entidade.Gerente;
import negocio.execao.funcionario.FuncionarioJaExisteException;
import negocio.execao.pessoa.PessoaInvalidaException;
import repositorio.dao.ClienteDAO;

public class Main extends Application {

    private Stage stage;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("/gui/view/TelaPrincipal.fxml"));
        root = (AnchorPane) load.load();
        stage.setTitle("Auto Car");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) {
        try {
            Fachada.getnstance().cadastrarGerente("Everton", "12343256789", "87996147789", 2000, "admin", "admin");
        } catch (PessoaInvalidaException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alterar");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());

            alert.showAndWait();
        } catch (FuncionarioJaExisteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        launch(args);
               
        try {
            Cliente c = new Cliente("Zé Maria","12345678900", "3763-2333");
            ClienteDAO cd = new ClienteDAO();
            
            cd.cadastrar(c);
        } catch (PessoaInvalidaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
