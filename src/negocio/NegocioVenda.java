package negocio;

import java.util.ArrayList;
import negocio.entidade.Venda;
import repositorio.RepositorioVenda;

public class NegocioVenda {
    private RepositorioVenda repositorio;
    
    public NegocioVenda(){
        this.repositorio = new RepositorioVenda();
    }
    
    public void cadastrarVenda(Venda venda){
        Venda v = this.repositorio.buscarVenda(venda.getCodigo());
        
        if(v != null){
            this.repositorio.cadastrarVenda(venda);
        }else{
            System.out.println("Não foi possivel casdastrar");
        }
    }
    
    public void alterarVenda(Venda venda){
        int indice = this.repositorio.indiceVenda(venda.getCodigo());
        
        if(indice != -1){
            this.repositorio.alterarVenda(indice, venda);
        }else{
            System.out.println("Não foi possivel alterar");
        }
    }
    
    public void removerVenda(int codigo){
        Venda venda = this.repositorio.buscarVenda(codigo);
        
        if(venda != null){
            this.repositorio.removerVenda(venda);
        }else{
            System.out.println("Não foi possivel remover");
        }
    }
    
    public Venda buscarVenda(int codigo){
        Venda v = this.repositorio.buscarVenda(codigo);
        
        if(v != null){
            return v;
        }else{
            System.out.println("Venda não encontrada");
            return null;
        }
    }
    
    public ArrayList<Venda> listaVendas(){
        return this.repositorio.recuperarVendas();
    }
}
