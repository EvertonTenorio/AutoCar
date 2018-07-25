package negocio;

import java.util.ArrayList;
import negocio.entidade.Funcionario;
import negocio.execao.cliente.ClienteInvalidoException;
import negocio.execao.funcionario.FuncionarioInvalidoException;
import negocio.execao.funcionario.FuncionarioJaExisteException;
import negocio.execao.funcionario.FuncionarioNaoExisteException;
import repositorio.RepositorioFuncionario;

public class NegocioFuncionario {

    private RepositorioFuncionario repositorio;

    public NegocioFuncionario() {
        this.repositorio = new RepositorioFuncionario();
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioInvalidoException, FuncionarioJaExisteException {
        Funcionario f = repositorio.buscarFuncionario(funcionario.getCpf());

        if (funcionario.getNome().equals("") && funcionario.getCpf().equals("") && funcionario.getTelefone().equals("") && funcionario.getLogin().equals("") && funcionario.getSenha().equals("")) {
            throw new FuncionarioInvalidoException();
        } else if (f == null) {
            repositorio.cadastrarFuncionario(funcionario);
        } else {
            throw new FuncionarioJaExisteException();
        }
    }

    public void alterarFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
        int indice = repositorio.indiceFuncionario(funcionario.getCpf());

        if (indice != -1) {
            repositorio.alterarFuncionario(indice, funcionario);
        } else {
            throw new FuncionarioNaoExisteException();

        }
    }

    public void removerFuncionario(String cpf) throws FuncionarioNaoExisteException {
        Funcionario f = repositorio.buscarFuncionario(cpf);
        if (f != null) {
            repositorio.removerFuncionario(f);
        } else {
            throw new FuncionarioNaoExisteException();
        }
    }

    public Funcionario buscarFuncionario(String cpf) throws FuncionarioNaoExisteException {
        Funcionario f = repositorio.buscarFuncionario(cpf);

        if (f != null) {
            return f;
        } else {
            throw new FuncionarioNaoExisteException();
        }

    }

    public ArrayList<Funcionario> listaFuncionario() {
        return repositorio.recuperarFuncionario();
    }

}
