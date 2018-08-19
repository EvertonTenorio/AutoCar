package negocio.entidade;

import negocio.execao.produto.ProdutoInvalidoException;

public class Produto {

    private int codigo;
    private double valor;
    private String nome;

    private static int GerarCodigo = 1;

    public Produto(double valor, String nome) {
        this.codigo = GerarCodigo++;
        this.valor = valor;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produto) {
            Produto produto = (Produto) obj;
            if (this.codigo == produto.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + " Nome: " + this.nome + " Valor: " + this.valor;

    }
    
    public void valida() throws ProdutoInvalidoException{
        if (this.nome.equals("") || this.valor <= 0) {
            throw new ProdutoInvalidoException();
        }
    }
}
