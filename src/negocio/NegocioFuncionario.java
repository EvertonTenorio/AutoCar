package negocio;

import java.util.ArrayList;
import negocio.entidade.Funcionario;
import repositorio.RepositorioFuncionario;

public class NegocioFuncionario {
    private RepositorioFuncionario repositorio;

    public NegocioFuncionario() {
        this.repositorio = new RepositorioFuncionario();
    }
    public void cadastrarFuncionario(Funcionario funcionario) {
        Funcionario f = repositorio.buscarFuncionario(funcionario.getCpf());

        if (f == null) {
            repositorio.cadastrarFuncionario(funcionario);
        } else {
            System.out.println("Não foi possivel cadastrar");
        }
    }
    public void alterarFuncionario(Funcionario funcionario) {
        int indice = repositorio.indiceFuncionario(funcionario.getCpf());

        if (indice != -1) {
            repositorio.alterarFuncionario(indice, funcionario);
        } else {
            System.out.println("Não é possível alterar");

        }
    }
    public void removerFuncionario(String cpf) {
        Funcionario f = repositorio.buscarFuncionario(cpf);
        if (f != null) {
            repositorio.removerFuncionario(f);
        } else {
            System.out.println("Não é possivel remover");
        }
    }
    public Funcionario buscarFuncionario(String cpf) {
        Funcionario f = repositorio.buscarFuncionario(cpf);

        if (f != null) {
            return f;
        } else {
            System.out.println("Funcionário encontrado");
        }
        return null;
    }
    public ArrayList<Funcionario> listaFuncionario() {
        return repositorio.recuperarFuncionario();
    }

}
