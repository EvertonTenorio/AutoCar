package negocio.entidade;

public class Funcionario extends Pessoa {

    private CargosEnum cargo;
    private String login;
    private String senha;

    public Funcionario(String nome, String cpf, String telefone, CargosEnum cargo) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
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

    public CargosEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargosEnum cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Nome do Funcionario: " + this.getNome() + "; Cpf: " + this.getCpf() + "; Cargo: " + this.cargo;
    }
}
