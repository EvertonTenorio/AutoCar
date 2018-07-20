package negocio.execao.cliente;

public class ClienteInvalidoException extends Exception{

    public ClienteInvalidoException() {
        super("Cliente inválido!");
    }

}