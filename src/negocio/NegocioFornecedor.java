package negocio;

import negocio.entidade.Fornecedor;
import repositorio.RepositorioFornecedor;
import repositorio.interfaces.IRepositorioFornecedor;

public class NegocioFornecedor {
    private IRepositorioFornecedor repositorio;
    
    public NegocioFornecedor(){
        repositorio = new RepositorioFornecedor();
    }
    
    public void cadastrarFornecedor(Fornecedor f){
        
    }
    
    public void removerFornecedor(Fornecedor f){
        
    }
    
    public void alterarFornecedor(Fornecedor f){
        
    }
    public Fornecedor buscarFornecedor(String cnpj){
        return null;
    }
}
