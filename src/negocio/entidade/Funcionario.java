package negocio.entidade;

import negocio.execao.funcionario.FuncionarioInvalidoException;
import negocio.execao.pessoa.PessoaInvalidaException;

public class Funcionario extends Pessoa {

    private CargosEnum cargo;

    public Funcionario(String nome, String cpf, String telefone, CargosEnum cargo) throws PessoaInvalidaException {
        super(nome, cpf, telefone);
        this.cargo = cargo;
        this.valida();
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

    @Override
    public void valida() throws FuncionarioInvalidoException, PessoaInvalidaException {
        if (this.cargo == null) {
            throw new FuncionarioInvalidoException();
        }
        super.valida();
    }
}
