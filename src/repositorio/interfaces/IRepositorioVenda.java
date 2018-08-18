package repositorio.interfaces;

import java.util.List;
import negocio.entidade.Venda;

public interface IRepositorioVenda {
    
    void cadastrarVenda(Venda venda);
    
    void removerVenda(Venda venda);
    
    Venda buscarVenda(int codigo);
    
    void alterarVenda(Venda venda);
    
    List<Venda> recuperarTodos();
}
