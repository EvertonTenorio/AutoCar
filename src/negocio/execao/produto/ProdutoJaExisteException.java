package negocio.execao.produto;

public class ProdutoJaExisteException extends Exception{

    public ProdutoJaExisteException() {
        super("Este produto já existe!");
    }
    

}
