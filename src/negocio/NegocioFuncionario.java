package negocio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Funcionario;
import negocio.execao.funcionario.FuncionarioInvalidoException;
import negocio.execao.funcionario.FuncionarioJaExisteException;
import negocio.execao.funcionario.FuncionarioNaoExisteException;
import negocio.execao.pessoa.PessoaInvalidaException;
import repositorio.RepositorioFuncionario;
import repositorio.interfaces.IRepositorioFuncionario;

public class NegocioFuncionario {

    private IRepositorioFuncionario repositorio;

    public NegocioFuncionario() {
        this.repositorio = new RepositorioFuncionario();
    }

    public void cadastrarFuncionario(String nome, String cpf, String telefone, double salario) throws FuncionarioJaExisteException, PessoaInvalidaException {
        Funcionario funcionario = new Funcionario(nome, cpf, telefone, salario);
        Funcionario f = repositorio.buscarFuncionario(funcionario.getCpf());

        if (f == null) {
            repositorio.cadastrarFuncionario(funcionario);
        } else {
            throw new FuncionarioJaExisteException();
        }
    }

    public void alterarFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
        Funcionario f = repositorio.buscarFuncionario(funcionario.getCpf());

        if (f != null) {
            repositorio.alterarFuncionario(funcionario);
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

    public boolean realizarLogin(String login, String senha) {
        if (login.equals("") || senha.equals("")) {
            System.out.println("Login inválido!");
            return false;

        } else {
            Funcionario f = repositorio.logarGerente(login, senha);
            if (f == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    public List<Funcionario> listaFuncionario() {
        return repositorio.recuperarTodos();
    }

}
