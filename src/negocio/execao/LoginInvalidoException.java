package negocio.execao;

public class LoginInvalidoException extends Exception{

    public LoginInvalidoException() {
        super("Login ou senha inválido(s)!");
    }

}
