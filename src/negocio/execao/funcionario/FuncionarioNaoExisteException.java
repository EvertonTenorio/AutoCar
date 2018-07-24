package negocio.execao.funcionario;

public class FuncionarioNaoExisteException extends Exception {

    public FuncionarioNaoExisteException() {
        super("Este funcionário não existe!");
    }

}
