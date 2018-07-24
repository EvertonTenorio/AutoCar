package negocio.execao.funcionario;

public class FuncionarioJaExisteException extends Exception {

    public FuncionarioJaExisteException() {
        super("Este funcionário já existe!");
    }

}
