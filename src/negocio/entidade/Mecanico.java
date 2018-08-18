package negocio.entidade;

import negocio.execao.pessoa.PessoaInvalidaException;

public class Mecanico extends Funcionario{
    
    private double bonificacao;

    public Mecanico(double bonificacao, String nome, String cpf, String telefone, double salario) throws PessoaInvalidaException {
        super(nome, cpf, telefone, salario);
        this.bonificacao = bonificacao;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }
    
    public void bonificar(double valor){
        
    }
    
    
    

}
