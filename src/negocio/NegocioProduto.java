package negocio;

import java.util.ArrayList;
import negocio.entidade.Produto;
import repositorio.RepositorioProduto;

public class NegocioProduto {

    private RepositorioProduto repositorio;

    public NegocioProduto() {
        this.repositorio = new RepositorioProduto();

    }

    public void cadastrarProduto(Produto produto) {
        Produto p = repositorio.recuperarProduto(produto.getCodigo());

        if (p == null) {
            repositorio.cadastrarProduto(produto);
        } else {
            System.out.println("Não foi possivel cadastrar");
        }
    }

    public void alterarProduto(Produto produto) {
        int indice = this.repositorio.indiceProduto(produto.getCodigo());
        
        if (indice != -1) {
            repositorio.alterarProduto(indice, produto);
        } else {
            System.out.println("Não é possivel alterar");
        }
    }

    public void removerProduto(int codigo) {
        Produto p = repositorio.recuperarProduto(codigo);

        if (p != null) {
            repositorio.removerProduto(p);
        } else {
            System.out.println("Não é possivel remover");
        }
    }

    public Produto buscarProduto(int codigo) {
        Produto p = repositorio.recuperarProduto(codigo);

        if (p == null) {
            System.out.println("Produto não encontrado");
            return null;
        } else {
            return p;
        }       
    }
    public ArrayList<Produto> listaProduto() {
        return repositorio.recuperarTodos();
    }
    
}
