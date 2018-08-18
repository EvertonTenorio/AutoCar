package negocio.entidade;

public class Servico extends Produto {

    private Mecanico mecanico;

    public Servico(double valor, String nome, Mecanico mecanico) {
        super(valor, nome);
        this.mecanico = mecanico;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return super.toString() + " Mecânico: " + mecanico.getNome();
    }

}
