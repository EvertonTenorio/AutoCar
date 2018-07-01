package negocio.entidade;

import java.util.ArrayList;

public class Cliente extends Pessoa {

    private int frequencia;
    private ArrayList<Carro> listaCarros;

    public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.frequencia = 0;
        this.listaCarros = new ArrayList<>();
    }

    public int getFrequencia() {
        return frequencia;
    }

    public ArrayList<Carro> getListaCarros() {
        return listaCarros;
    }

    public void zerarFrequencia() {
        this.frequencia = 0;
    }

    public void incrementarFrequencia() {
        this.frequencia++;
    }
}
