package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Carro;

public class RepositorioCarro {

    private List<Carro> listaCarros;

    public RepositorioCarro() {
        this.listaCarros = new ArrayList<>();
    }

    public void cadastrarCarro(Carro carro) {
        this.listaCarros.add(carro);
    }

    public void alterarCarro(int indice, Carro carro) {
        this.listaCarros.set(indice, carro);
    }

    public void removerCarro(Carro carro) {
        this.listaCarros.remove(carro);
    }

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
    
    public List<Carro> listaCarros(){
        return this.listaCarros;
    }
}
