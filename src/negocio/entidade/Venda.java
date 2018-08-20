package negocio.entidade;

import java.util.ArrayList;

public class Venda {

    private int codigo;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private Pessoa cliente;

    private static int gerarCodigo = 1;

    public Venda(Pessoa cliente) {
        this.codigo = gerarCodigo++;
        this.produtos = new ArrayList<>();
        this.valorTotal = 0;
        this.cliente = cliente;

    }

    public Venda() {
        this.codigo = gerarCodigo++;
        this.produtos = new ArrayList<>();
        this.valorTotal = 0;

    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public static int getGerarCodigo() {
        return gerarCodigo;
    }

    public static void setGerarCodigo(int gerarCodigo) {
        Venda.gerarCodigo = gerarCodigo;
    }

    public double getValorTotal() {
        this.valorTotal = 0;
        this.calcularConta();
        return valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void adicionarServico(Servico servico, String placa, Mecanico mecanico) {
        servico.setMecanico(mecanico);       

        for (int i = 0; i < cliente.getCarros().size(); i++) {
            if (cliente.getCarros().get(i).getPlaca().equals(placa)) {
                cliente.getCarros().get(i).adicionarNoHistorico(servico);
                break;
            }
        }

        this.produtos.add(servico);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    private void calcularConta() {

        for (int i = 0; i < produtos.size(); i++) {
            this.valorTotal += produtos.get(i).getValor();

        }

        if (cliente instanceof Funcionario) {
            this.valorTotal *= 0.90;
        } else if (cliente instanceof Cliente) {
            Cliente c = (Cliente) cliente;

            if (c.getFrequencia() == 10) {
                this.valorTotal *= 0.85;
                c.zerarFrequencia();
            }
            c.incrementarFrequencia();
        } else {
            this.valorTotal = valorTotal;
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
        return "Código: " + this.codigo + " Produtos: " + this.produtos;
    }
}
