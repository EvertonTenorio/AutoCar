package negocio.entidade;

import java.util.ArrayList;

public class Cliente extends Pessoa {

    private int frequencia;

    private ArrayList<Carro> carros;

    public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.frequencia = 0;
        this.carros = new ArrayList<>();
    }

    public int getFrequencia() {
        return frequencia;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void zerarFrequencia() {
        this.frequencia = 0;
    }

    public void incrementarFrequencia() {
        this.frequencia++;
    }

    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
    }

    public void removerCarro(Carro carro) {
        this.carros.remove(carro);
    }
}
