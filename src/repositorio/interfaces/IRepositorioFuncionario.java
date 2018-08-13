package repositorio.interfaces;

import negocio.entidade.Funcionario;

public interface IRepositorioFuncionario {
    
    void cadastrarFuncionario(Funcionario funcionario);
    
    void removerFuncionario(Funcionario funcionario);
    
    Funcionario buscarFuncionario(String cpf);
    
    void alterarFuncionario(int indice, Funcionario funcionario);
}
