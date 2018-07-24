package negocio.execao.servico;

public class ServicoNaoExisteException extends Exception {

    public ServicoNaoExisteException() {
        super("Este serviço não existe!");
    }

}
