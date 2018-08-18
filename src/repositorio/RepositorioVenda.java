package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Venda;
import repositorio.interfaces.IRepositorioVenda;

public class RepositorioVenda implements IRepositorioVenda{

    private ArrayList<Venda> listaVendas;

    public RepositorioVenda() {
        this.listaVendas = new ArrayList<>();
    }

    @Override
    public void cadastrarVenda(Venda venda) {
        this.listaVendas.add(venda);
    }

    @Override
    public Venda buscarVenda(int codigo) {
        for (int i = 0; i < listaVendas.size(); i++) {
            if (listaVendas.get(i).getCodigo() == codigo) {
                return listaVendas.get(i);
            }
        }
        return null;
    }

    @Override
    public void removerVenda(Venda venda) {
        this.listaVendas.remove(venda);
    }

    @Override
    public void alterarVenda(Venda venda) {
        int indice = this.indiceVenda(venda.getCodigo());

        listaVendas.set(indice, venda);
    }

    public List<Venda> recuperarTodos() {
       ArrayList<Venda> lista = new ArrayList<>();
        
        for(int i = 0; i < listaVendas.size(); i++){
            lista.add(listaVendas.get(i));
        }
        
        return lista;
    }

    private int indiceVenda(int codigo) {
        for (int i = 0; i < listaVendas.size(); i++) {
            if (listaVendas.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
}
