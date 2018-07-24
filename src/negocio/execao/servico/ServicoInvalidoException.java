package negocio.execao.servico;

public class ServicoInvalidoException extends Exception{

    public ServicoInvalidoException() {
        super("Serviço inválido!");
    }

}
