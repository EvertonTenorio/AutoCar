package negocio.entidade;

import negocio.execao.funcionario.FuncionarioInvalidoException;
import negocio.execao.pessoa.PessoaInvalidaException;

public class Funcionario extends Pessoa {

    private double salario;

    public Funcionario(String nome, String cpf, String telefone, double salario) throws PessoaInvalidaException {
        super(nome, cpf, telefone);
        this.salario = salario;
        this.valida();
        
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome do Funcionario: " + this.getNome() + "; Cpf: " + this.getCpf();
    }

}
