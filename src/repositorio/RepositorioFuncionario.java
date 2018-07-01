package repositorio;

import negocio.entidade.Funcionario;
import java.util.ArrayList;

public class RepositorioFuncionario {

    private ArrayList<Funcionario> listaFuncionarios;

    public RepositorioFuncionario() {
        this.listaFuncionarios = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.listaFuncionarios.add(funcionario);
    }

    public Funcionario buscarFuncionario(String cpf) {
        for (int i = 0; i < this.listaFuncionarios.size(); i++) {
            if (this.listaFuncionarios.get(i).getCpf().equals(cpf)) {
                return this.listaFuncionarios.get(i);
            }
        }
        return null;
    }

    public void removerFuncionario(Funcionario funcionario) {
        listaFuncionarios.remove(funcionario);
    }

    public void alterarFuncionario(int indice, Funcionario funcionario) {
        listaFuncionarios.set(indice, funcionario);
    }

    public ArrayList<Funcionario> recuperarFuncionario() {
        return listaFuncionarios;
    }

    public int indiceFuncionario(String cpf) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

}
