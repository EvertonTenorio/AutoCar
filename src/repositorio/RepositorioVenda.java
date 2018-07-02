package repositorio;

import java.util.ArrayList;
import negocio.entidade.Venda;

public class RepositorioVenda {
    private ArrayList<Venda> listaVendas;
    
    public RepositorioVenda(){
        this.listaVendas = new ArrayList<>();
    }
    
    public void cadastrarVenda(Venda venda){
        this.listaVendas.add(venda);
    }
    
    public Venda buscarVenda(int codigo){
        for(int i = 0; i < listaVendas.size(); i++){
            if(listaVendas.get(i).getCodigo() == codigo){
                return listaVendas.get(i);
            }
        }
        return null;
    }
}
