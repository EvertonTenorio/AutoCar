package negocio.entidade;

/*
* Thaís: Vai ter controle de acesso no sistema? Se sim, funcionário deveria ter login e senha, não?
* Qual a utilidade de cargo?
* */
public class Funcionario extends Pessoa {

    private String cargo; //Thaís: Sugiro que os possíveis cargos sejam configurados como constantes. FAZER O ENUM!

    public Funcionario(String nome, String cpf, String telefone, String cargo) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Nome do Funcionario: " + this.getNome() + "; Cpf: " + this.getCpf() + "; Cargo: " + this.cargo;
    }
}
