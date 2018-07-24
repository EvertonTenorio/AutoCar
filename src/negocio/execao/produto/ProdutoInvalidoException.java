package negocio.execao.produto;

public class ProdutoInvalidoException extends Exception {

    public ProdutoInvalidoException() {
        super("Produto inválido!");
    }
}
