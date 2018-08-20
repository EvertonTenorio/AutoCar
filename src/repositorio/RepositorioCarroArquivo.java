package repositorio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.entidade.Carro;
import repositorio.interfaces.IRepositorioCarro;

public class RepositorioCarroArquivo implements IRepositorioCarro {

    private ObjectOutputStream objOutput;
    private FileInputStream fileInput;
    private ObjectInputStream objInput;
    private FileOutputStream fileOutput;
    private ArrayList<Carro> listaCarros;

    public RepositorioCarroArquivo() throws FileNotFoundException, IOException {
        this.fileOutput = new FileOutputStream("carros.dat");
        this.objOutput = new ObjectOutputStream(fileOutput);
        this.fileInput = new FileInputStream("carros.dat");
        this.objInput = new ObjectInputStream(fileInput);
        this.listaCarros = new ArrayList<>();
    }

    @Override
    public void cadastrarCarro(Carro carro) {
        this.listaCarros.add(carro);
    }

    @Override
    public void alterarCarro(Carro carro) {
        int indice = indiceCarro(carro.getPlaca());

        this.listaCarros.set(indice, carro);
    }

    @Override
    public void removerCarro(Carro carro) {
        this.listaCarros.remove(carro);
    }

    @Override
    public Carro buscarCarro(String placa) {
        int indice = indiceCarro(placa);
        if (indice != -1) {
            return this.listaCarros.get(indice);
        } else {
            return null;
        }
    }

    public int indiceCarro(String placa) {
        for (int i = 0; i < this.listaCarros.size(); i++) {
            if (listaCarros.get(i).getPlaca().equals(placa)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Carro> recuperarTodos() {
        ArrayList<Carro> carros = new ArrayList<>();

        for (int i = 0; i < listaCarros.size(); i++) {
            carros.add(listaCarros.get(i));
        }

        return carros;
    }
    
    public void salvarNoArquivo() throws IOException{
        for(int i = 0; i < listaCarros.size(); i++){
            this.objOutput.writeObject(this.listaCarros.get(i));
        }
        
        this.objOutput.close();
    }
    
     public void lerDoArquivo() throws IOException{
         
     }
}
