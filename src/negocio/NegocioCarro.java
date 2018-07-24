package negocio;

import java.util.List;
import negocio.execao.carro.CarroInvalidoException;
import negocio.execao.carro.CarroJaExisteException;
import negocio.execao.carro.CarroNaoExisteException;
import negocio.entidade.Carro;
import repositorio.RepositorioCarro;

public class NegocioCarro {

    private RepositorioCarro repositorio;

    public NegocioCarro() {
        this.repositorio = new RepositorioCarro();
    }

    public void cadastrarCarro(Carro carro) throws CarroJaExisteException, CarroInvalidoException {
        Carro c = repositorio.buscarCarro(carro.getPlaca());

        if (carro.getPlaca().equals("")) {
            throw new CarroInvalidoException();
        } else if (c != null) {
            throw new CarroJaExisteException();
        } else {
            this.repositorio.cadastrarCarro(carro);
        }
    }

    public void alterarCarro(Carro carro) throws CarroNaoExisteException{
        int indice = repositorio.indiceCarro(carro.getPlaca());

        if (indice != -1) {
            repositorio.alterarCarro(indice, carro);
        }else{
            throw new CarroNaoExisteException();
        }
    }
    
    public void removerCarro(String placa) throws CarroNaoExisteException{
        Carro c = repositorio.buscarCarro(placa);
        
        if(c != null){
            repositorio.removerCarro(c);
        }else{
            throw new CarroNaoExisteException();
        }
    }
    
    public Carro buscarCarro(String placa) throws CarroNaoExisteException{
        Carro c = repositorio.buscarCarro(placa);
        
        if(c != null){
            return c;
        }else{
            throw new CarroNaoExisteException();
        }
    }
    
    public List<Carro> listaCarros(){
        return repositorio.listaCarros();
    }
}
