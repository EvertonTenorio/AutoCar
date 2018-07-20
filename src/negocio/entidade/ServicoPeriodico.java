package negocio.entidade;

public class ServicoPeriodico extends Servico {

    private int kmAtual;
    private int kmProximoServico;

    public ServicoPeriodico(int kmAtual, int kmProximoServico, double valor, String nome) {
        super(valor, nome);
        this.kmAtual = kmAtual;
        this.kmProximoServico = kmProximoServico;
    }

    public int getKmAtual() {
        return kmAtual;
    }

    public int getKmProximoServico() {
        return kmProximoServico;
    }

    public void setKmProximoServico(int kmProximoServico) {
        this.kmProximoServico = kmProximoServico;
    }

    /* Thaís: Poderia reusar o toString() herdado de Servico. */
    @Override
    public String toString() {
        return "Código: " + this.getCodigo() + " Nome: " + this.getNome() + " Valor: " + this.getValor() + " KmAtual :" + this.kmAtual + " KmProximoServico: "+ this.kmProximoServico;   
    }

}
