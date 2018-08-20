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

    public void cadastrarCarro(String placa) throws CarroJaExisteException, CarroInvalidoException {
        Carro carro = new Carro(placa);

        Carro c = repositorio.buscarCarro(carro.getPlaca());
        if (c == null) {
            this.repositorio.cadastrarCarro(carro);;
        } else {
            throw new CarroJaExisteException();
        }

    }

    public void alterarCarro(Carro carro) throws CarroNaoExisteException {
        Carro c = repositorio.buscarCarro(carro.getPlaca());

        if (c != null) {
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
