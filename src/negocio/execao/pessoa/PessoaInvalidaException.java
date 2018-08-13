package negocio.execao.pessoa;

public class PessoaInvalidaException extends Exception {

    public PessoaInvalidaException() {
        super("Dado(s) inválido(s)");
    }

}
