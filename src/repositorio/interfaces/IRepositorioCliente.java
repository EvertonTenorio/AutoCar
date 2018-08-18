package repositorio.interfaces;

import java.util.List;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteNaoExisteException;

public interface IRepositorioCliente {

    void cadastrarCliente(Cliente cliente);

    void removerCliente(Cliente cliente);

    Cliente buscarCliente(String cpf);

    void alterarCliente(Cliente cliente);
    
    List<Cliente> recuperarTodos();
}
