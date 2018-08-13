package repositorio.interfaces;

import negocio.entidade.Cliente;

public interface IRepositorioCliente {
    
    void cadastrarCliente(Cliente cliente);
    
    void removerCliente(Cliente cliente);
    
    Cliente buscarCliente(String cpf);
    
    void alterarCliente(int indice, Cliente cliente);
}
