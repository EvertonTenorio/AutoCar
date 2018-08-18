package repositorio;

import java.util.ArrayList;
import java.util.List;
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
    public void alterarProduto(Produto produto) {
        int codigo = this.indiceProduto(produto.getCodigo());
        
        this.listaProdutos.set(codigo, produto);
    }

    private int indiceProduto(int codigo) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public List<Produto> recuperarTodos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        
        for(int i = 0; i < listaProdutos.size(); i++){
            produtos.add(listaProdutos.get(i));
        }
        return produtos;
    }
}
