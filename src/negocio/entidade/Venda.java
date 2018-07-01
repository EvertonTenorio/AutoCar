package negocio.entidade;

import java.util.ArrayList;

public class Venda {

    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;

    public Venda() {
        this.produtos = new ArrayList<>();
        this.servicos = new ArrayList<>();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }
    
    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }
    
    public void adicionarServico(Servico servico){
        this.servicos.add(servico);
    }
}
