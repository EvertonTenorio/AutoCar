package repositorio.interfaces;

import java.util.List;
import negocio.entidade.Funcionario;

public interface IRepositorioFuncionario {
    
    void cadastrarFuncionario(Funcionario funcionario);
    
    void removerFuncionario(Funcionario funcionario);
    
    Funcionario buscarFuncionario(String cpf);
    
    void alterarFuncionario(Funcionario funcionario);
    
    List<Funcionario> recuperarTodos();
    
    Funcionario logarGerente(String login, String senha);
}
