package negocio;

import java.util.List;
import negocio.execao.carro.CarroInvalidoException;
import negocio.execao.carro.CarroJaExisteException;
import negocio.execao.carro.CarroNaoExisteException;
import negocio.entidade.Carro;
import repositorio.RepositorioCarro;
import repositorio.interfaces.IRepositorioCarro;

public class NegocioCarro {

    private IRepositorioCarro repositorio;

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

    public void alterarCarro(Carro carro) throws CarroNaoExisteException {
        Carro c = repositorio.buscarCarro(carro.getPlaca());
        
        if(c != null){
            repositorio.alterarCarro(carro);
        } else {
            throw new CarroNaoExisteException();
        }
        
    }

    public void removerCarro(String placa) throws CarroNaoExisteException {
        Carro c = repositorio.buscarCarro(placa);

        if (c != null) {
            repositorio.removerCarro(c);
        } else {
            throw new CarroNaoExisteException();
        }
    }

    public Carro buscarCarro(String placa) throws CarroNaoExisteException {
        Carro c = repositorio.buscarCarro(placa);

        if (c != null) {
            return c;
        } else {
            throw new CarroNaoExisteException();
        }
    }

    public List<Carro> listaCarros() {
        return repositorio.recuperarTodos();
    }
}
