package negocio.execao.venda;

public class VendaJaExisteException extends Exception {

    public VendaJaExisteException() {
        super("Essa venda Já existe!");
    }
}
