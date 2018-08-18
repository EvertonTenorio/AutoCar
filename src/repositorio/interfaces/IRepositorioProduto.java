package repositorio.interfaces;

import java.util.List;
import negocio.entidade.Produto;

public interface IRepositorioProduto {
    
    void cadastrarProduto(Produto produto); 
    
    void removerProduto(Produto produto);
    
    Produto recuperarProduto(int codigo);
    
    void alterarProduto(Produto produto);
    
    List<Produto> recuperarTodos();
}
