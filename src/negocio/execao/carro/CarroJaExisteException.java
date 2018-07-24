package negocio.execao.carro;

public class CarroJaExisteException extends Exception {

    public CarroJaExisteException() {
        super("Este carro já existe!");
    }

}
