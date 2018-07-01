package repositorio;

import java.util.ArrayList;
import negocio.entidade.Produto;

public class RepositorioProduto {

    private ArrayList<Produto> listaProdutos;

    public RepositorioProduto() {
        this.listaProdutos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        this.listaProdutos.add(produto);
    }
    
    public void removerProduto(Produto produto){
        this.listaProdutos.remove(produto);
        
    }
    public ArrayList<Produto> recuperar() {
        return listaProdutos;
    }
    public Produto recuperarProduto(int codigo) {
        for (Produto p : this.listaProdutos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
    public void alterarProduto(int codigo, Produto produto){
       this.listaProdutos.set(codigo, produto);
    }
    
    public int indiceReserva(int codigo){
        for(int i=0; i<listaProdutos.size();i++){
            if(listaProdutos.get(i).getCodigo() == codigo){
                return i;
            }
        }
        return -1;
    }
}
