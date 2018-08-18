package negocio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteInvalidoException;
import negocio.execao.cliente.ClienteJaExisteException;
import negocio.execao.cliente.ClienteNaoExisteException;
import negocio.execao.pessoa.PessoaInvalidaException;
import repositorio.RepositorioCliente;
import repositorio.interfaces.IRepositorioCliente;

/*
 Por exemplo, o que acontece se o cliente for removido e tiver
* alguma venda atrelada a ele? Queremos um sistema que funciona de forma consistente.
* Esse comentário se aplica para todas as demais classes de entidades.
* */
public class NegocioCliente {

    private IRepositorioCliente repositorio;

    public NegocioCliente() {
        this.repositorio = new RepositorioCliente();

    }

    public void cadastrarCliente(String nome, String cpf, String telefone) throws ClienteJaExisteException, PessoaInvalidaException {
        Cliente cliente = new Cliente(nome, cpf, telefone);

        Cliente c = repositorio.buscarCliente(cliente.getCpf());

        if (c == null) {
            repositorio.cadastrarCliente(cliente);
        } else {
            throw new ClienteJaExisteException();
        }
    }

    public void alterarCliente(Cliente cliente) throws ClienteNaoExisteException {
        Cliente c = repositorio.buscarCliente(cliente.getCpf());

        if (c != null) {
            repositorio.alterarCliente(cliente);
        } else {
            throw new ClienteNaoExisteException();

        }
    }

    public void removerCliente(String cpf) throws ClienteNaoExisteException {
        Cliente c = repositorio.buscarCliente(cpf);
        if (c != null) {
            repositorio.removerCliente(c);
        } else {
            throw new ClienteNaoExisteException();
        }
    }

    public Cliente buscarCliente(String cpf) throws ClienteNaoExisteException {
        Cliente c = repositorio.buscarCliente(cpf);

        if (c != null) {
            return c;
        } else {
            throw new ClienteNaoExisteException();
        }
    }

    public List<Cliente> listaClientes() {
        return repositorio.recuperarTodos();
    }
}
