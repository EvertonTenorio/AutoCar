package repositorio;

import java.util.ArrayList;
import negocio.entidade.Cliente;
import repositorio.interfaces.IRepositorioCliente;

public class RepositorioCliente implements IRepositorioCliente{

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
    public void alterarCliente(int indice, Cliente cliente) {
        listaClientes.set(indice, cliente);
    }

    /* Thaís: É preciso ter cuidado com essa implementação, pois ela expõe o repositório, deixando-o vulnerável à mudanças
     * sem controle. O correto seria devolver um ArrayList com uma cópia do conteúdo do repositório. Parece a mesma coisa,
     * mas é diferente. Sendo a cópia, nenhuma mudança feita nela vai afetar o repositório. Isso se aplica aos demais
     * repositórios.*/
    public ArrayList<Cliente> recuperarClientes() {
        return listaClientes;
    }

    /* Thaís: Esse método só faz sentido para uso nessa classe. Quem usa o repositório não quer "enxergar" índice. */
    public int indiceCliente(String cpf) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }
}