package negocio.execao.cliente;

public class ClienteJaExisteException extends Exception{

    public ClienteJaExisteException() {
        super("Este cliente já existe!");
    }

}