package repositorio;

import java.util.ArrayList;
import negocio.entidade.Produto;
import repositorio.interfaces.IRepositorioProduto;

public class RepositorioProduto implements IRepositorioProduto{

    private ArrayList<Produto> listaProdutos;

    public RepositorioProduto() {
        this.listaProdutos = new ArrayList<>();
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        this.listaProdutos.add(produto);
    }

    @Override
    public void removerProduto(Produto produto) {
        this.listaProdutos.remove(produto);

    }

    @Override
    public Produto recuperarProduto(int codigo) {
        for (Produto p : this.listaProdutos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void alterarProduto(int codigo, Produto produto) {
        this.listaProdutos.set(codigo, produto);
    }

    public int indiceProduto(int codigo) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
    
    
    public ArrayList<Produto> recuperarTodos() {
        return listaProdutos;
    }
}
