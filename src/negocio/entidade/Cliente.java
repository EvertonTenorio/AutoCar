package negocio.entidade;

public class Cliente extends Pessoa {

    private int frequencia;

    public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.frequencia = 0;
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
