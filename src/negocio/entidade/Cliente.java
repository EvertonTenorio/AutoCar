package negocio.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import negocio.execao.pessoa.PessoaInvalidaException;

public class Cliente extends Pessoa implements Serializable{

    private int frequencia;

    public Cliente(String nome, String cpf, String telefone) throws PessoaInvalidaException {
        super(nome, cpf, telefone);
        this.frequencia = 0;
        this.valida();
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void zerarFrequencia() {
        this.frequencia = 0;
    }

    public void incrementarFrequencia() {
        this.frequencia++;
    }

}
