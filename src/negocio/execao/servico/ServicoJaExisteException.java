package negocio.execao.servico;

public class ServicoJaExisteException extends Exception {

    public ServicoJaExisteException() {
        super("Este serviço já existe!");
    }

}
