package repositorio.interfaces;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Funcionario;
import negocio.entidade.Mecanico;

public interface IRepositorioFuncionario {
    
    void cadastrarFuncionario(Funcionario funcionario);
    
    void removerFuncionario(Funcionario funcionario);
    
    Funcionario buscarFuncionario(String cpf);
    
    void alterarFuncionario(Funcionario funcionario);
    
    List<Funcionario> recuperarTodos();
    
    Funcionario logarGerente(String login, String senha);
    
    public ArrayList<Mecanico> recuperarMecanicos();
}
