package repositorio.interfaces;

import java.util.List;
import negocio.entidade.Servico;

public interface IRepositorioServico {
    
    void cadastrarServico(Servico servico);
    
    void removerServico(Servico servico);
    
    Servico recuperarServico(int codigo);
    
    void alterarServico(Servico servico);
    
    List<Servico> recuperarTodos();
}
