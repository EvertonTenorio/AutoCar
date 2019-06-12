package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteNaoExisteException;
import repositorio.dao.ClienteDAO;
import repositorio.interfaces.IRepositorioCliente;

public class RepositorioCliente implements IRepositorioCliente {

    private ClienteDAO clientesDAO;

    public RepositorioCliente() {
        this.clientesDAO = new ClienteDAO();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        this.clientesDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        return null;
    }

    @Override
    public void removerCliente(Cliente cliente) {
        this.clientesDAO.remover(cliente);
    }

    @Override
    public void alterarCliente(Cliente cliente) {
        this.clientesDAO.alterar(cliente);
    }

    public List<Cliente> recuperarTodos() {
        return null;
    }

}
