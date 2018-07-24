package negocio.execao.venda;

public class VendaNaoExisteException extends Exception{

    public VendaNaoExisteException() {
        super("Esta venda não existe!");
    }

}
