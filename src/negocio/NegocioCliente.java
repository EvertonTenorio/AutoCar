package negocio;

import java.util.ArrayList;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteInvalidoException;
import negocio.execao.cliente.ClienteJaExisteException;
import negocio.execao.cliente.ClienteNaoExisteException;
import repositorio.RepositorioCliente;

/*
 Por exemplo, o que acontece se o cliente for removido e tiver
* alguma venda atrelada a ele? Queremos um sistema que funciona de forma consistente.
* Esse comentário se aplica para todas as demais classes de entidades.
* */
public class NegocioCliente {

    private RepositorioCliente repositorio;

    public NegocioCliente() {
        this.repositorio = new RepositorioCliente();
    }

    public void cadastrarCliente(Cliente cliente) throws ClienteInvalidoException, ClienteJaExisteException{
        Cliente c = repositorio.buscarCliente(cliente.getCpf());
        
        if (cliente.getNome().equals("") && cliente.getCpf().equals("") && cliente.getTelefone().equals("")){
            throw  new ClienteInvalidoException();
        }
        
        else if (c == null) {
            repositorio.cadastrarCliente(cliente);
        } else {
            throw new ClienteJaExisteException();
        }
    }

    public void alterarCliente(Cliente cliente) throws ClienteNaoExisteException{
        int indice = repositorio.indiceCliente(cliente.getCpf());

        if (indice != -1) {
            repositorio.alterarCliente(indice, cliente);
        } else {
            throw new ClienteNaoExisteException();

        }
    }

    public void removerCliente(String cpf) throws ClienteNaoExisteException{
        Cliente c = repositorio.buscarCliente(cpf);
        if (c != null) {
            repositorio.removerCliente(c);
        } else {
            throw new ClienteNaoExisteException();
        }
    }

    public Cliente buscarCliente(String cpf) throws ClienteNaoExisteException{
        Cliente c = repositorio.buscarCliente(cpf);

        if (c != null) {
            return c;
        } else {
            throw new ClienteNaoExisteException();
        }
    }

    public ArrayList<Cliente> listaClientes() {
        return repositorio.recuperarClientes();
    }
}
