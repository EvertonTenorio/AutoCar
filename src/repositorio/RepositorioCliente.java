package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Cliente;
import negocio.execao.cliente.ClienteNaoExisteException;
import repositorio.interfaces.IRepositorioCliente;

public class RepositorioCliente implements IRepositorioCliente {

    private ArrayList<Cliente> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getCpf().equals(cpf)) {
                return this.listaClientes.get(i);
            }
        }
        return null;
    }

    @Override
    public void removerCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    @Override
    public void alterarCliente(Cliente cliente) {
        int indice = this.indiceCliente(cliente.getCpf());

        listaClientes.set(indice, cliente);
    }

    public List<Cliente> recuperarTodos() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        for (int i = 0; i < listaClientes.size(); i++) {
            clientes.add(listaClientes.get(i));
        }
        return listaClientes;
    }

    private int indiceCliente(String cpf) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }
}
