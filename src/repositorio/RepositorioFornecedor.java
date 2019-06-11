package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Fornecedor;
import repositorio.interfaces.IRepositorioFornecedor;

public class RepositorioFornecedor implements IRepositorioFornecedor{
    
    private ArrayList<Fornecedor> listaFornecedores;

    public RepositorioFornecedor() {
        this.listaFornecedores = new ArrayList<>();
    }

    @Override
    public void cadastrarFornecedor(Fornecedor f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerFornecedor(Fornecedor f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fornecedor buscarFornecedor(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarFornecedor(Fornecedor f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fornecedor> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}