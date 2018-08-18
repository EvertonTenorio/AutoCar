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
    
    public void bonificar(double valor){
        this.bonificacao += valor * 0.05;
    } 
    
    public double retirarBonificação(){
        double bonificacaoAux = this.bonificacao;
        this.bonificacao = 0;
        
        return bonificacaoAux;
    }
}
