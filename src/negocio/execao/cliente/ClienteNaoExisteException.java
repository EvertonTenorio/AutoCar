package negocio.execao.cliente;

public class ClienteNaoExisteException extends Exception {

    public ClienteNaoExisteException() {
        super("Esse cliente não existe!");
    }
}
