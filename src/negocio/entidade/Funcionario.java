package negocio.entidade;

public class Funcionario extends Pessoa {

    private CargosEnum cargo;

    public Funcionario(String nome, String cpf, String telefone, CargosEnum cargo) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
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
