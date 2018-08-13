package repositorio.interfaces;

import negocio.entidade.Produto;

public interface IRepositorioProduto {
    
    void cadastrarProduto(Produto produto); 
    
    void removerProduto(Produto produto);
    
    Produto recuperarProduto(int codigo);
    
    void alterarProduto(int codigo, Produto produto);
}
