package negocio.entidade;

import java.util.ArrayList;

/* Thaís: E se o Cliente vender/trocar de carro, como faz para lidar? */

public class Cliente extends Pessoa {

    /* Thaís: Não sei se vale à pena manter isso. É que na prática, sabe-se a frequência com base na contratação de
    * serviços e compras, certo? Daí que é necessário manter a consistência. Seria mais prático concentrar a informação
    * em um só lugar. */
    private int frequencia;

    private ArrayList<Carro> listaCarros; //Thaís: Redundante mencionar "lista", bastaria "carros"

    public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.frequencia = 0;
        this.listaCarros = new ArrayList<>();
    }

    public int getFrequencia() {
        return frequencia;
    }

    public ArrayList<Carro> getListaCarros() {
        return listaCarros;
    }

    public void zerarFrequencia() {
        this.frequencia = 0;
    }

    public void incrementarFrequencia() {
        this.frequencia++;
    }
    
    public void adicionarCarro(Carro carro){
        this.listaCarros.add(carro);
    }
}
