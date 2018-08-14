package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Carro;
import repositorio.interfaces.IRepositorioCarro;

public class RepositorioCarro implements IRepositorioCarro{

    private List<Carro> listaCarros;

    public RepositorioCarro() {
        this.listaCarros = new ArrayList<>();
    }
    
    @Override
    public void cadastrarCarro(Carro carro) {
        this.listaCarros.add(carro);
    }

    @Override
    public void alterarCarro(int indice, Carro carro) {
        this.listaCarros.set(indice, carro);
    }
    
    @Override
    public void removerCarro(Carro carro) {
        this.listaCarros.remove(carro);
    }

    @Override
    public Carro buscarCarro(String placa) {
        int indice = indiceCarro(placa);
        if (indice != -1) {
            return this.listaCarros.get(indice);
        } else {
            return null;
        }
    }

    public int indiceCarro(String placa) {
        for (int i = 0; i < this.listaCarros.size(); i++) {
            if (listaCarros.get(i).getPlaca().equals(placa)) {
                return i;
            }
        }
        return -1;
    }
    
    public List<Carro> recuperarTodos(){
        ArrayList<Carro> carros = new ArrayList<>();
        
        for(int i = 0; i < listaCarros.size(); i++){
            carros.add(listaCarros.get(i));
        }
        
        return carros;
    }
}
