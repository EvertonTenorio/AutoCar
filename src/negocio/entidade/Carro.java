package negocio.entidade;

import java.io.Serializable;
import java.util.ArrayList;

public class Carro implements Serializable{

    private String placa;
    private ArrayList<Servico> historico;

    public Carro(String placa) {
        this.placa = placa;
        this.historico = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setHistorico(ArrayList<Servico> historico) {
        this.historico = historico;
    }

    public ArrayList<Servico> getHistorico() {
        return historico;
    }

    public void adicionarNoHistorico(Servico servico) {
        this.historico.add(servico);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Carro) {
            Carro c = (Carro) obj;

            if (this.placa.equals(c.getPlaca())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Placa: " + this.placa;
    }
}
