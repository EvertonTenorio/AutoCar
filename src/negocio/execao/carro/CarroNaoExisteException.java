package negocio.execao.carro;

public class CarroNaoExisteException extends Exception {

    public CarroNaoExisteException() {
        super("Este carro não existe!");
    }

}
