package repositorio.interfaces;

import negocio.entidade.Servico;

public interface IRepositorioServico {
    
    void cadastrarServico(Servico servico);
    
    void removerServico(Servico servico);
    
    Servico recuperarServico(int codigo);
    
    void alterarServico(int indice, Servico servico);
}
