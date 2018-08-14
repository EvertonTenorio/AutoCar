package negocio;

import java.util.ArrayList;
import negocio.entidade.Venda;
import negocio.execao.venda.VendaInvalidaException;
import negocio.execao.venda.VendaJaExisteException;
import negocio.execao.venda.VendaNaoExisteException;
import repositorio.RepositorioVenda;

public class NegocioVenda {

    private RepositorioVenda repositorio;

    public NegocioVenda() {
        this.repositorio = new RepositorioVenda();
    }

    public void cadastrarVenda(Venda venda) throws VendaInvalidaException, VendaJaExisteException {
        Venda v = this.repositorio.buscarVenda(venda.getCodigo());

        if (venda.getCliente() == null && (venda.getProdutos().size() + venda.getProdutos().size() == 0)) {
            throw new VendaInvalidaException();
        } else if (v == null) {
            this.repositorio.cadastrarVenda(venda);
        } else {
            throw new VendaJaExisteException();
        }
    }

    public void alterarVenda(Venda venda) throws VendaNaoExisteException {
        int indice = this.repositorio.indiceVenda(venda.getCodigo());

        if (indice != -1) {
            this.repositorio.alterarVenda(indice, venda);
        } else {
            throw new VendaNaoExisteException();
        }
    }

    public void removerVenda(int codigo) throws VendaNaoExisteException {
        Venda venda = this.repositorio.buscarVenda(codigo);

        if (venda != null) {
            this.repositorio.removerVenda(venda);
        } else {
            throw new VendaNaoExisteException();
        }
    }

    public Venda buscarVenda(int codigo) throws VendaNaoExisteException {
        Venda v = this.repositorio.buscarVenda(codigo);

        if (v != null) {
            return v;
        } else {
            throw new VendaNaoExisteException();
        }
    }

    public ArrayList<Venda> listaVendas() {
        return this.repositorio.recuperarTodos();
    }
}
