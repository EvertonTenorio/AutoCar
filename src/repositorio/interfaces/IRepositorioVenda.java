package repositorio.interfaces;

import negocio.entidade.Venda;

public interface IRepositorioVenda {
    
    void cadastrarVenda(Venda venda);
    
    void removerVenda(Venda venda);
    
    Venda buscarVenda(int codigo);
    
    void alterarVenda(int indice, Venda venda);
}
