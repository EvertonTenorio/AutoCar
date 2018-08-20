package negocio.entidade;

import negocio.execao.produto.ProdutoInvalidoException;

public class ServicoPeriodico extends Servico {

    private int kmAtual;
    private int kmProximoServico;

    public ServicoPeriodico(int kmAtual, int kmProximoServico, double valor, String nome, Mecanico mecanico) throws ProdutoInvalidoException {
        super(valor, nome);
        this.kmAtual = kmAtual;
        this.kmProximoServico = kmProximoServico;
    }

    public int getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(int kmAtual) {
        this.kmAtual = kmAtual;
    }

    public int getKmProximoServico() {
        return kmProximoServico;
    }

    public void setKmProximoServico(int kmProximoServico) {
        this.kmProximoServico = kmProximoServico;
    }

    @Override
    public String toString() {
        return "Código: " + this.getCodigo() + " Nome: " + this.getNome() + " Valor: " + this.getValor() + " KmAtual :" + this.kmAtual + " KmProximoServico: " + this.kmProximoServico;
    }

}
