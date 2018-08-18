package negocio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Produto;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.produto.ProdutoJaExisteException;
import negocio.execao.produto.ProdutoNaoExisteException;
import repositorio.RepositorioProduto;
import repositorio.interfaces.IRepositorioProduto;

public class NegocioProduto {

    private IRepositorioProduto repositorio;

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
        Produto p = this.repositorio.recuperarProduto(produto.getCodigo());

        if (p != null) {
            repositorio.alterarProduto(produto);
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

    public List<Produto> listaProdutos() {
        return repositorio.recuperarTodos();
    }

}
