package negocio.entidade;

public class Servico extends Produto {

    private Funcionario mecanico;

    public Servico(double valor, String nome, Funcionario mecanico) {
        super(valor, nome);
        this.mecanico = mecanico;
    }

    public Funcionario getMecanico() {
        return mecanico;
    }

    public void setMecanico(Funcionario mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return super.toString() + " Mecânico: " + mecanico.getNome();
    }

}
