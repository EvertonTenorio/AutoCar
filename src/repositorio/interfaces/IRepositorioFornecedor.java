package repositorio.interfaces;

import java.util.List;
import negocio.entidade.Fornecedor;

public interface IRepositorioFornecedor {
    
    void cadastrarFornecedor(Fornecedor f);
    
    void removerFornecedor(Fornecedor f);
    
    Fornecedor buscarFornecedor(String cnpj);

    void alterarFornecedor(Fornecedor f);
    
    List<Fornecedor> recuperarTodos();
}
