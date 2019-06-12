package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Produto;
import repositorio.dao.ProdutoDAO;
import repositorio.interfaces.IRepositorioProduto;

public class RepositorioProduto implements IRepositorioProduto {

    private ProdutoDAO produtosDAO;

    public RepositorioProduto() {
        this.produtosDAO = new ProdutoDAO();
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        this.produtosDAO.cadastrar(produto);
    }

    @Override
    public void removerProduto(Produto produto) {
        this.produtosDAO.remover(produto);

    }

    @Override
    public Produto recuperarProduto(int codigo) {
        return null;
    }

    @Override
    public void alterarProduto(Produto produto) {
        this.produtosDAO.alterar(produto);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return null;
    }
}
