package negocio.entidade;

import java.util.ArrayList;

public class Venda {
    private int codigo;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    
    private static int gerarCodigo = 1;

    public Venda() {
        this.codigo = gerarCodigo++;
        this.produtos = new ArrayList<>();
        this.servicos = new ArrayList<>();
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
    
    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }
    
    public void adicionarServico(Servico servico){
        this.servicos.add(servico);
    }
}
