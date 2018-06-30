package negocio.entidade;

public class Funcionario extends Pessoa {

    private String cargo;

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
    public boolean equals(Object obj) {
        if (obj instanceof Funcionario) {
            Funcionario funcionario = (Funcionario) obj;
            if (this.getCpf().equals(funcionario.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome do Funcionario: " + this.getNome() + "; Cpf: " + this.getCpf() + "; Cargo: " + this.cargo;
    }
}
