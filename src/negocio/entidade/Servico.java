package negocio.entidade;

import negocio.execao.produto.ProdutoInvalidoException;

public class Servico extends Produto {

    private Mecanico mecanico;

    public Servico(double valor, String nome) throws ProdutoInvalidoException {
        super(valor, nome);
        this.mecanico = null;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

}
