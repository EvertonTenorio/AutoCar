package negocio.entidade;

import java.util.ArrayList;

public class Carro {

    private String placa;
    private int quilometragem;

    public Carro(String placa) {
        this.placa = placa;
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setKm(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int getKm() {
        return quilometragem;
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
