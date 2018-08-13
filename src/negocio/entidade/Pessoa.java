package negocio.entidade;

import negocio.execao.pessoa.PessoaInvalidaException;

public class Pessoa {

    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) obj;
            if (this.cpf.equals(pessoa.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "; Cpf: " + this.cpf + "; Telefone: " + this.telefone;

    }

    public void valida() throws PessoaInvalidaException {
        if (this.nome.equals("") || this.nome.length() < 5 || this.cpf.equals("") || this.cpf.length() != 11 || this.telefone.equals("") || this.telefone.length() != 11) {
            throw new PessoaInvalidaException();
        }
    }

}
