package negocio;

import java.util.ArrayList;
import negocio.entidade.Produto;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.produto.ProdutoJaExisteException;
import negocio.execao.produto.ProdutoNaoExisteException;
import repositorio.RepositorioProduto;

public class NegocioProduto {

    private RepositorioProduto repositorio;

    public NegocioProduto() {
        this.repositorio = new RepositorioProduto();

    }

    public void cadastrarProduto(Produto produto) throws ProdutoInvalidoException, ProdutoJaExisteException {
        Produto p = repositorio.recuperarProduto(produto.getCodigo());

        if (produto.getNome().equals("") && produto.getValor() == 0) {
            throw new ProdutoInvalidoException();
        } else if (p == null) {
            repositorio.cadastrarProduto(produto);
        } else {
            throw new ProdutoJaExisteException();
        }
    }

    public void alterarProduto(Produto produto) throws ProdutoNaoExisteException {
        int indice = this.repositorio.indiceProduto(produto.getCodigo());

        if (indice != -1) {
            repositorio.alterarProduto(indice, produto);
        } else {
            throw new ProdutoNaoExisteException();
        }
    }

    public void removerProduto(int codigo) throws ProdutoNaoExisteException {
        Produto p = repositorio.recuperarProduto(codigo);

        if (p != null) {
            repositorio.removerProduto(p);
        } else {
            throw new ProdutoNaoExisteException();
        }
    }

    public Produto buscarProduto(int codigo) throws ProdutoNaoExisteException {
        Produto p = repositorio.recuperarProduto(codigo);

        if (p == null) {
            throw new ProdutoNaoExisteException();
        } else {
            return p;
        }
    }

    public ArrayList<Produto> listaProdutos() {
        return repositorio.recuperarTodos();
    }

}
