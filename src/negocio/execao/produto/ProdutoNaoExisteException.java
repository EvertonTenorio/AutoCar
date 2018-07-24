package negocio.execao.produto;

public class ProdutoNaoExisteException extends Exception {

    public ProdutoNaoExisteException() {
        super("Este produto não existe!");
    }

}
