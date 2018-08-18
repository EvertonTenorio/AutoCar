package repositorio.interfaces;

import java.util.List;
import negocio.entidade.Carro;
import negocio.execao.carro.CarroNaoExisteException;

public interface IRepositorioCarro {
    
    void cadastrarCarro(Carro carro);
    
    void alterarCarro(Carro carro);
    
    void removerCarro(Carro carro);
    
    Carro buscarCarro(String placa);
    
    List<Carro> recuperarTodos();
}
