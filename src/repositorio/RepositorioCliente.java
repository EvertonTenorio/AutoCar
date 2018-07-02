package repositorio;

import java.util.ArrayList;
import negocio.entidade.Cliente;

public class RepositorioCliente {

    private ArrayList<Cliente> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
    }

    public Cliente buscarCliente(String cpf) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getCpf().equals(cpf)) {
                return this.listaClientes.get(i);
            }
        }
        return null;
    }

    public void removerCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public void alterarCliente(int indice, Cliente cliente) {
        listaClientes.set(indice, cliente);
    }

    public ArrayList<Cliente> recuperarClientes() {
        return listaClientes;
    }

    public int indiceCliente(String cpf) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }
}