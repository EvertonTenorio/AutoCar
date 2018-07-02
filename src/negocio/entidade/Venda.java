package negocio.entidade;

import java.util.ArrayList;

public class Venda {

    private int codigo;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private double consumo;

    private static int gerarCodigo = 1;

    public Venda() {
        this.codigo = gerarCodigo++;
        this.produtos = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.consumo = 0;
    }

    public double getConsumo() {
        this.calcularConta();
        return consumo;
    }

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void calcularConta() {
        for (int i = 0; i <= produtos.size(); i++) {
            this.consumo += produtos.get(i).getValor();

        }
        for (int j = 0; j <= servicos.size(); j++) {
            this.consumo += servicos.get(j).getValor();
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Venda) {
            Venda venda = (Venda) obj;
            if (this.codigo == venda.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + " Produtos: " + this.produtos + " Serviços: " + this.servicos;
    }
}
