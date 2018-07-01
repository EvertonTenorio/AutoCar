package negocio;

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
}

