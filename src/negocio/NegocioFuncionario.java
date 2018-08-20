package negocio;

import negocio.execao.carro.LoginInvalidoException;
import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Funcionario;
import negocio.entidade.Gerente;
import negocio.entidade.Mecanico;
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
        funcionario.valida();
        Funcionario f = repositorio.buscarFuncionario(funcionario.getCpf());

        if (f == null) {
            repositorio.cadastrarFuncionario(funcionario);
        } else {
            throw new FuncionarioJaExisteException();
        }
    }

    public void cadastrarMecanico(String nome, String cpf, String telefone, double salario) throws FuncionarioJaExisteException, PessoaInvalidaException {
        Mecanico mecanico = new Mecanico(nome, cpf, telefone, salario);
        mecanico.valida();
        Funcionario f = repositorio.buscarFuncionario(mecanico.getCpf());

        if (f == null) {
            repositorio.cadastrarFuncionario(mecanico);
        } else {
            throw new FuncionarioJaExisteException();
        }
    }

    public void cadastrarGerente(String nome, String cpf, String telefone, double salario, String login, String senha) throws FuncionarioJaExisteException, PessoaInvalidaException {
        Gerente funcionario = new Gerente(login, senha, nome, cpf, telefone, salario);
        funcionario.valida();
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

    public boolean realizarLogin(String login, String senha) throws LoginInvalidoException {
        if (login.equals("") || senha.equals("")) {
            throw new LoginInvalidoException();
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

    public ArrayList<Mecanico> listaMecanico() {
        return repositorio.recuperarMecanicos();
    }

}
