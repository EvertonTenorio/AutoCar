package negocio.entidade;

import java.util.ArrayList;

/*
* Thaís: Por que não há setters para os atributos? A menos que sejam constantes, deve ser possível alterá-los, em particular
* o histórico.
* */

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
