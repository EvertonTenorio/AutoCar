package negocio.execao.carro;

public class LoginInvalidoException extends Exception{

    public LoginInvalidoException() {
        super("Login ou senha inválido(s)!");
    }

}
