package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Carro;
import negocio.execao.carro.CarroNaoExisteException;
import repositorio.dao.CarroDAO;
import repositorio.interfaces.IRepositorioCarro;

public class RepositorioCarro implements IRepositorioCarro {

    private CarroDAO carrosDAO;

    public RepositorioCarro() {
        this.carrosDAO = new CarroDAO();
    }

    @Override
    public void cadastrarCarro(Carro carro) {
        this.carrosDAO.cadastrar(carro);

    }

    @Override
    public void alterarCarro(Carro carro) {
        this.carrosDAO.alterar(carro);
    }

    @Override
    public void removerCarro(Carro carro) {
        this.carrosDAO.remover(carro);
    }

    @Override
    public Carro buscarCarro(String placa) {
        return this.carrosDAO.buscar(placa);

    }

    @Override
    public List<Carro> recuperarTodos() {

        return null;
    }

}
