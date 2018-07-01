package negocio.entidade;

import java.util.ArrayList;

public class Carro {

    private String placa;
    private ArrayList<Servico> historico;

    public Carro(String placa) {
        this.placa = placa;
        this.historico = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public ArrayList<Servico> getHistorico() {
        return historico;
    }

}
