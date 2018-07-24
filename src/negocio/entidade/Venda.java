package negocio.entidade;

import java.util.ArrayList;

/*
* Thaís: E se quiser remover produto ou serviço, como faz? Outra coisa, para implementar o programa de fidelidade não
* seria necessário associar a Venda a um Cliente? Outra coisa, o texto diz que o cliente pode escolher o funcionário, mas
* não localizei código para viabilizar isso. O funcionário tanto pode atuar na venda quanto na prestação de serviço, então
* minha expectativa era existir relacionamento entre Venda e Funcionário e/ou Serviço e Funcionário. A
* loja pode querer acompanhar a produtividade do funcionário pelos atendimentos prestados (seria uma nova funcionalidade),
* o que daria ainda mais utilidade para tais relações.
* É aquilo que sempre digo: Com um pouco de criatividade e boa vontade é possível fazer um sistema útil, com riqueza de
* detalhes que vão dando espaço para usar os conceitos da disciplina. Se a equipe olha para o projeto e procura sempre
* escrever o mínimo de código para ter um projeto para entregar, vai acabar com um conjunto de classes com atributos
* sem utilidade prática e getters e setters. Ora, para que serve um projeto desses? Apesar de ainda estarmos no P2 podemos
* fazer algo útil, ainda que simples.
* */
public class Venda {

    private int codigo;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private double valorTotal;

    private static int gerarCodigo = 1;

    public Venda() {
        this.codigo = gerarCodigo++;
        this.produtos = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.valorTotal = 0;
    }

    public double getValorTotal() {
        this.calcularConta();
        return valorTotal;
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

    private void calcularConta() {
        for (int i = 0; i < produtos.size(); i++) {
            this.valorTotal += produtos.get(i).getValor();

        }
        for (int j = 0; j < servicos.size(); j++) {
            this.valorTotal += servicos.get(j).getValor();
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
