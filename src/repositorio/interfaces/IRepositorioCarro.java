package repositorio.interfaces;

import negocio.entidade.Carro;

public interface IRepositorioCarro {
    
    void cadastrarCarro(Carro carro);
    
    void alterarCarro(int indice, Carro carro);
    
    void removerCarro(Carro carro);
    
    Carro buscarCarro(String placa);
}
