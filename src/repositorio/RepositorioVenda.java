package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Venda;
import repositorio.dao.VendaDAO;
import repositorio.interfaces.IRepositorioVenda;

public class RepositorioVenda implements IRepositorioVenda{

    private VendaDAO dao;

    public RepositorioVenda() {
        this.dao = new VendaDAO();
    }

    @Override
    public void cadastrarVenda(Venda venda) {
        this.dao.cadastrar(venda);
    }

    @Override
    public Venda buscarVenda(int codigo) {
//        for (int i = 0; i < listaVendas.size(); i++) {
//            if (listaVendas.get(i).getCodigo() == codigo) {
//                return listaVendas.get(i);
//            }
//        }
        return null;
    }

    @Override
    public void removerVenda(Venda venda) {
        this.dao.remover(venda);
    }

    @Override
    public void alterarVenda(Venda venda) {
        this.dao.alterar(venda);
    }

    public List<Venda> recuperarTodos() {
        return dao.recuperarTodos();
    }
}
