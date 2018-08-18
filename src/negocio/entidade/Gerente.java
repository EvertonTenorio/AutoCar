package negocio.entidade;

import negocio.execao.funcionario.FuncionarioInvalidoException;
import negocio.execao.pessoa.PessoaInvalidaException;

public class Gerente extends Funcionario {

    private String login;
    private String senha;

    public Gerente(String login, String senha, String nome, String cpf, String telefone, double salario) throws PessoaInvalidaException {
        super(nome, cpf, telefone, salario);
        this.login = login;
        this.senha = senha;
        this.valida();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void valida() throws PessoaInvalidaException {
        if (this.login.equals("") || this.senha.equals("")) {
            throw new FuncionarioInvalidoException();
        }
        super.valida();

    }
}
