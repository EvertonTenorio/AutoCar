package negocio;

import java.util.ArrayList;
import negocio.entidade.Cliente;
import repositorio.RepositorioCliente;

public class NegocioCliente {

    private RepositorioCliente repositorio;

    public NegocioCliente() {
        this.repositorio = new RepositorioCliente();
    }

    public void cadastrarCliente(Cliente cliente) {
        Cliente c = repositorio.buscarCliente(cliente.getCpf());

        if (c == null) {
            repositorio.cadastrarCliente(cliente);
        } else {
            System.out.println("Não foi possivel cadastrar");
        }
    }

    public void alterarCliente(Cliente cliente) {
        int indice = repositorio.indiceCliente(cliente.getCpf());

        if (indice != -1) {
            repositorio.alterarCliente(indice, cliente);
        } else {
            System.out.println("Não é possível alterar");

        }
    }

    public void removerCliente(String cpf) {
        Cliente c = repositorio.buscarCliente(cpf);
        if (c != null) {
            repositorio.removerCliente(c);
        } else {
            System.out.println("Não é possivel remover");
        }
    }

    public Cliente buscarCliente(String cpf) {
        Cliente c = repositorio.buscarCliente(cpf);

        if (c != null) {
            return c;
        } else {
            System.out.println("Cliente não encontrado");
        }
        return null;
    }

    public ArrayList<Cliente> listaClientes() {
        return repositorio.recuperarClientes();
    }
}
